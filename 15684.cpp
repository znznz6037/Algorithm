#include <iostream>
#include <vector>

using namespace std;

int N, M, H; // 세로, 가로, 가로선 위치의 개수
vector<vector<int>> map(31, vector<int>(11, 0));

int isAnswer() {
	int ans = 0;
	for (int col = 1; col <= N; col++) {
		int col_idx = col;
		for (int row = 1; row <= H; row++) {
			if (map[row][col_idx]) col_idx++;
			else if (map[row][col_idx - 1])col_idx--;
		}
		if (col_idx != col) return 0;
	}
	return 1;
}

int dfs(int endStep, int step, int Row, int Col) {
	if (step == endStep) {
		if (isAnswer()) {
			cout << step;
			exit(0);
		}
		return 0;
	}
	int row = Col + 1 > N ? Row++ : Row;
	int col = Col + 1 > N ? 1 : Col + 1;
	for (; row <= H; row++) {
		for (; col <= N; col++) {
			if (map[row][col] || map[row][col - 1] || map[row][col + 1]) continue;
			map[row][col] = 1;
			dfs(endStep, step + 1, row, col);
			map[row][col] = 0;
		}
		col = 1;
	}
	return 0;
}


int main() {
	cin >> N >> M >> H;
	/*
	가로선의 정보
	a, b : b 번 세로선과 b+1번 세로선을 a 번 점선에서 연결
	*/
	int row, col;
	for (int i = 1; i <= M; i++) {
		cin >> row >> col;
		map[row][col] = 1;
	}
	if (isAnswer()) {
		cout << 0;
		return 0;
	}
	for (int step = 1; step <= 3; step++) {
		for (int row = 1; row <= H; row++) {
			for (int col = 1; col <= N; col++) {
				if (map[row][col] || map[row][col - 1] || map[row][col + 1]) continue;
				map[row][col] = 1;
				dfs(step, 1, row, col);
				map[row][col] = 0;
			}
		}
	}
	cout << -1;
	return 0;
}