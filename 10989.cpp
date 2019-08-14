<<<<<<< HEAD
#include <iostream>

using namespace std;

int main() {
	int N, n, count = 0, arr[10001] = { 0 };
	scanf_s("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &n);
		arr[n - 1]++;
	}

	for (int i = 0; i < 10000; i++) {
		for (int j = 0; j< arr[i]; j++) {
			count++;
			printf("%d\n", i + 1);
			if (count == N) break;
		}
	}

	return 0;
=======
#include <iostream>
#include <vector>
using namespace std;

void merge(vector<int>& v, int start, int end, int middle) {
	vector<int>ret;
	int i = start, j = middle + 1, copy = 0;
	while (i <= middle && j <= end) {
		if (v[i] <= v[j])ret.push_back(v[i++]);
		else if (v[i] > v[j])ret.push_back(v[j++]);
	}
	while (i <= middle)ret.push_back(v[i++]);
	while (j <= end)ret.push_back(v[j++]);
	for (int x = start; x <= end; x++) {
		v[x] = ret[copy++];
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
	vector<int>arr;
	int N;
	cin >> N;
	int x = 0;
	for (int i = 0; i < N; i++) {
		cin >> x;
		arr.push_back(x);
	}
	mergeSort(arr, 0, N - 1);
	for (int j = 0; j < N; j++) printf("%d\n", arr[j]);
	return 0;
>>>>>>> c163b3a9c7fbfa6c637a042e8c9a9274dc6f4f4f
}