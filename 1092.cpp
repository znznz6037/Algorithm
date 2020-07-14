#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, M, t = 0, crane[51] = { 0, };
vector<int>box;

bool compare(int a, int b) {
	return a > b;
}

bool isPossible(int wIdx, int bIdx) {
	return crane[wIdx] >= box[bIdx];
}

int load() {
	while (1) {
		if (!isPossible(0, 0)) return -1;
		for (int i = 0; i < N; i++) {
			if (M == 0) break;
			for (int j = 0; j < M; j++)
				if (isPossible(i, j) && box[j] != 0) {
					box.erase(box.begin() + j, box.begin() + j + 1);
					M--, j--;
					break;
				}
		}
		t++;
		if (M == 0) return t;
	}
}

int main() {
	int weight;
	cin >> N;
	for (int i = 0; i < N; i++) cin >> crane[i];
	cin >> M;
	for (int i = 0; i < M; i++) {
		cin >> weight;
		box.push_back(weight);
	}
	sort(crane, crane + N, compare);
	sort(box.begin(), box.end(), compare);
	cout << load();
	return 0;
}