#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int r, c, k, lr, lc, time = 0;
int arr[101][101] = { 0, };
vector<pair<int, int>> number, sortedTmp;
vector<int> tmp;

int compare(pair<int, int> a, pair<int, int> b) {
	if (a.second == b.second) return a.first < b.first;
	return a.second < b.second;
}

void sort() {
	for (int i = 0; i < tmp.size(); i++) {
		if (tmp[i] == 0) continue;
		number[tmp[i]].second++;
	}
	
	sort(number.begin(), number.end(), compare);
}

void R() {
	for (int i = 0; i < lr; i++) {
		for (int j = 0; j < lc; j++) {
			tmp.push_back(arr[i][j]);
		}
		sort();
		
		for (int j = 0; j < 101; j++) {
			if (number[j].second == 0) continue;
			sortedTmp.push_back(number[j]);
		}

		int size = sortedTmp.size();
		for (int j = 0; j < size * 2; j += 2) {
			if (j >= 100) break;
			arr[i][j] = sortedTmp[j / 2].first;
			arr[i][j + 1] = sortedTmp[j / 2].second;
		}
		for (int j = size * 2; j < 100; j++) arr[i][j] = 0;
		
		if (sortedTmp.size() * 2 >= 98) lc = 100;
		else lc = max(lc, size * 2);
		tmp.clear(), sortedTmp.clear(), number.clear();
		for (int j = 0; j < 101; j++) number.push_back(make_pair(j, 0));
	}
}

void C() {
	int mr = 0;
	for (int i = 0; i < lc; i++) {
		for (int j = 0; j < lr; j++) {
			tmp.push_back(arr[j][i]);
		}
		sort();

		for (int j = 0; j < 101; j++) {
			if (number[j].second == 0) continue;
			sortedTmp.push_back(number[j]);
		}

		int size = sortedTmp.size();
		for (int j = 0; j < size * 2; j += 2) {
			if (j >= 100) break;
			arr[j][i] = sortedTmp[j / 2].first;
			arr[j + 1][i] = sortedTmp[j / 2].second;
		}
		for (int j = size * 2; j < 100; j++) arr[j][i] = 0;

		if (size * 2 >= 98) lr = 100;
		else lr = max(lr, size * 2);
		tmp.clear(), sortedTmp.clear(), number.clear();
		for (int j = 0; j < 101; j++) number.push_back(make_pair(j, 0));
	}
}

int main() {
	cin >> r >> c >> k;
	for (int i = 0; i < 3; i++) 
		for (int j = 0; j < 3; j++) 
			cin >> arr[i][j];

	lr = 3, lc = 3;
	for (int i = 0; i < 101; i++) number.push_back(make_pair(i, 0));

	while (1) {
		if (time > 100) {
			cout << -1;
			return 0;
		}
		if (arr[r - 1][c - 1] == k) break;
		if (lr >= lc) R();
		else C();
	
		time++;
	}

	cout << time;
	return 0;
}