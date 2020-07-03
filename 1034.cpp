#include <iostream>
#include <cstring>

using namespace std;

int N, M, K, arr[51][51] = { 0, };

int canTurn(int pos) {
	int n = 0;
	for (int j = 0; j < M; j++) if (arr[pos][j] == 0) n++;
	if (n <= K && (K - n) % 2 == 0) return 1;
	return 0;
}

int sameRow(int idx) {
	int row[51], cnt = 1;
	memcpy(row, arr[idx], sizeof(arr[idx]));
	for (int i = 0; i < N; i++) {
		if (i == idx) continue;
		for (int j = 0; j < M; j++) {
			if (row[j] != arr[i][j]) break;
			if (j == M - 1) cnt++;
		}
	}
	return cnt;
}

int Max(int *arr) {
	int max = 0;
	for (int i = 0; i < N; i++) 
		if (max < arr[i]) max = arr[i];
	return max;
}

int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++) scanf_s("%1d", &arr[i][j]);
	cin >> K;
	int numRow[51] = { 0, };
	for (int i = 0; i < N; i++) if (canTurn(i)) numRow[i] = sameRow(i);
	cout << Max(numRow) << endl;
	return 0;
}