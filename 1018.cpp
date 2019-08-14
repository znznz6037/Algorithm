#include <iostream>
#include <algorithm>

using namespace std;

int N, M;
char arr[51][51];
int sum = 0, result = 10000;

const char white[8][8] = {
	{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
	{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
	{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
	{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
	{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
	{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
	{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
	{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }
};

const char black[8][8] = {
	{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
	{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
	{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
	{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
	{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
	{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
	{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
	{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }
};

int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
		}
	}

	for (int i = 0; i < N - 7; i++) {
		for (int j = 0; j < M - 7; j++) {
			sum = 0;
			if (arr[i][j] == 'B') {
				for (int x = i; x < i + 8; x++) {
					for (int y = j; y < j + 8; y++) {
						if (black[x - i][y - j] != arr[x][y]) sum++;
					}
				}
			}
			else if(arr[i][j] == 'W') {
				for (int x = i; x < i + 8; x++) {
					for (int y = j; y < j + 8; y++) {
						if (white[x - i][y - j] != arr[x][y]) sum++;
					}
				}
			}
			if (sum > 32) sum = 64 - sum;
			result = min(sum, result);
		}
	}
	cout << result << endl;
	return 0;
}