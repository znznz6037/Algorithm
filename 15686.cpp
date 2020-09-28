#include <iostream>
#include <climits>
#include <algorithm>

using namespace std;

int N, M, cnt = 0, minSum = INT_MAX, sum = 0;
int map[51][51] = { 0, };

int calMinDist(int y, int x) {
	int dir = 1;
	while (1) {
		for (int i = 0; i <= dir; i++) {
			int j = dir - i;
			int firstY = y + i, secondY = y - i;
			if (firstY < N) {
				if (x + j < N && map[firstY][x + j] == 2) return dir;
				if (x - j >= 0 && map[firstY][x - j] == 2) return dir;
			}
			if (secondY >= 0) {
				if (x + j < N && map[secondY][x + j] == 2) return dir;
				if (x - j >= 0 && map[secondY][x - j] == 2) return dir;
			}
		}
		dir++;
	}
	return 0;
}

int chickDist() {
	int dirSum = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] == 1) dirSum += calMinDist(i, j);
		}
	}
	return dirSum;
}

void dfs(int step, int Y, int X) {
	if (step == (cnt - M)) {
		minSum = min(minSum, chickDist());
		return;
	}
	int y = X < N - 1 ? Y : Y + 1, x = X < N - 1 ? X + 1 : 0;
	for (; y < N; y++) {
		for (; x < N; x++) {
			if (map[y][x] == 2) {
				map[y][x] = 0;
				dfs(step + 1, y, x);
				map[y][x] = 2;
			}
		}
		x = 0;
	}
	return;
}

int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
			if (map[i][j] == 2) cnt++;
		}
	}

	if (cnt == M) cout << chickDist();
	else {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
					dfs(1, i, j);
					map[i][j] = 2;
				}
			}
		}
		cout << minSum;
	}

	return 0;
}