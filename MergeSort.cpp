#include <iostream>
#include <vector>
using namespace std;

void merge(vector<int>& v, int start, int end, int middle) {
	vector<int> ret;
	int i = start, j = middle + 1, copy = 0;

	while (i <= middle && j <= end) {
		if (v[i] < v[j])ret.push_back(v[i++]);
		else if (v[i] > v[j])ret.push_back(v[j++]);
	}
	while (i <= middle)ret.push_back(v[i++]); //끝까지 저장하지 못한 배열의 값을 순서대로
	while (j <= end)ret.push_back(v[j++]); // 전부 다 ret 에 저장한다.

	for (int k = start; k <= end; k++) {
		v[k] = ret[copy++];
	}
}

void mergeSort(vector<int>& v, int start, int end) {
	if (start < end) {
		int middle = (start + end) / 2;
		mergeSort(v, start, middle);
		mergeSort(v, middle + 1, end);
		merge(v, start, end, middle);
	}
}

int main() {
	int N;
	vector<int>v;
	scanf_s("%d", &N);
	int x = 0;
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &x);
		v.push_back(x);
	}
	mergeSort(v, 0, N - 1);
	for (int j = 0; j < N; j++) printf("%d\n", v[j]);
}