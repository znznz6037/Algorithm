#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

//&array 로 주소값을 넘겨줘야함!!!!!!!!
void selectionSort(vector<int> &array, int len) {
	for (int i = 0; i < len - 1; i++) {
		int tmp = i;
		for (int j = i + 1; j < len; j++) {
			if (array[tmp] >= array[j])tmp = j;
		}
		swap(array[i], array[tmp]);
	}
}

void insertionSort(vector<int> &array, int len) {
	for (int i = 1; i < len; i++) {
		int tmp = array[i], j = i - 1;
		while (j >= 0 && tmp < array[j]) {
			swap(array[j], array[j + 1]);
			j--;
		}
		//array[j + 1] = tmp;
	}
}

void bubbleSort(vector<int> &array, int len) {
	for (int i = 0; i < len - 1; i++) {
		for (int j = 1; j < len - i; j++) {
			if (array[j - 1] > array[j]) swap(array[j - 1], array[j]);
		}
	}
}

void merge(vector<int> &array, int s, int e, int m) {
	vector<int> ret;
	int i = s, j = m + 1, copy = 0;

	while (i <= m && j <= e) {
		if (array[i] < array[j]) ret.push_back(array[i++]);
		else if (array[i] > array[j]) ret.push_back(array[j++]);
	}

	while (i <= m) ret.push_back(array[i++]);
	while (j <= e) ret.push_back(array[j++]);

	for (int k = s; k <= e; k++) {
		array[k] = ret[copy++];
	}
}

void mergeSort(vector<int> &array, int s, int e) {
	if (s < e) {
		int m = (s + e) / 2;
		mergeSort(array, s, m);
		mergeSort(array, m + 1, e);
		merge(array, s, e, m);
	}
}


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
	if (j > right)quickSort(v, left + 1, j);
}

void heapify(vector<int>& heap, int i, int n) {
	int cur = 2 * i; // cur = 왼쪽 자식 노드
	if (cur < n && heap[cur] < heap[cur + 1]) cur++; 
	// 오른쪽 자식 노드가 있고, 왼쪽 자식보다 크다면 cur ++
	if (heap[i] < heap[cur]) { // 부모보다 자식이 더 크면 교환
		swap(heap[i], heap[cur]);
		if (cur <= n / 2) heapify(heap, cur, n); //
	}
}

void heapSort(vector<int> &heap, int i) {
	swap(heap[1], heap[i]);
	
	int root = 1, cur = 2;
	while (cur / 2 < i) {
		cur = 2 * root;
		if (cur < i - 1 && heap[cur] < heap[cur + 1]) cur++;
		if (cur < i && heap[root] < heap[cur]) swap(heap[root], heap[cur]);
		root = cur;
	}
}



int N, n;
vector<int> arr(1001, 0);

int main() {
	cin >> N;

	/*
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	
	//mergeSort(arr, 0, N - 1);
	//quickSort(arr, 0, N - 1);

	for (int i = 0; i < N; i++) {
		cout << arr[i] << endl;
	}
	*/

	for (int i = 1; i <= N; i++) { // 힙은 배열이 1부터 시작
		cin >> arr[i];
	}

	for (int i = N / 2; i > 0; i--) heapify(arr, i, N);
	for (int i = N; i > 0; i--) heapSort(arr, i);


	for (int i = 1; i <= N; i++) {
		cout << arr[i] << endl;
	}

	return 0;
}