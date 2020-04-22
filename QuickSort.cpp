#include <iostream>
#include <vector>
using namespace std;

/*
int n;
int quick[1000000] = { 0 };

void quickSort(int i, int j) {
	if (i >= j)return;
	int pivot = quick[(i + j) / 2];
	int left = i;
	int right = j;

	while (left <= right) {
		while (quick[left] < pivot)left++;
		while (quick[right] > pivot)right--;
		if (left <= right) {
			swap(quick[left], quick[right]);
			left++;
			right--;
		}
		quickSort(i, right);
		quickSort(left, j);
	}
}

int main() {
	int N;
	scanf_s("%d", &N);
	for (int i = 0; i < N; i++) scanf_s("%d", &quick[i]);
	quickSort(0, N - 1);
	for (int j = 0; j < N; j++) cout << quick[j] << endl;
}
*/

void quickSort(vector<int>& v, int left, int right) {
	int pivot = v[left];
	int i = left, j = right;
	while (left < right) {
		while (pivot <= v[right] && left < right) right--;
		if (left > right)break;
		while (pivot >= v[left] && left < right) left++;
		if (left > right)break;
		swap(v[left], v[right]);
	}
	swap(v[i], v[left]);
	if (i < left)quickSort(v, i, left - 1);
	if (j > right)quickSort(v, left+1, j);
}

int main() {
	vector<int>v;
	int N;
	int x;
	scanf_s("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &x);
		v.push_back(x);
	}
	quickSort(v, 0, N - 1);
	for (int j = 0; j < N; j++) printf("%d\n", v[j]);
}