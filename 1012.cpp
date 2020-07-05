#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int field[51][51], visited[51][51];
int dir[4][2] = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
int T, M, N, K, x, y;

int checkRange(int nextX, int nextY) {
	if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) return 0;
	else return 1;
}

int BFS() {
	queue<pair<int, int>>q;
	int nextX, nextY, cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (field[i][j] && !visited[i][j]) {
				cnt++;
				visited[i][j] = 1;
				q.push(make_pair(i, j));
				while (!q.empty()) {
					int ax = q.front().first, ay = q.front().second;
					q.pop();
					for (int k = 0; k < 4; k++) {
						nextX = ax + dir[k][0], nextY = ay + dir[k][1];
						if (checkRange(nextX, nextY) && field[nextX][nextY] && !visited[nextX][nextY]) {
							visited[nextX][nextY] = 1;
							q.push(make_pair(nextX, nextY));
						}
					}
				}
			}
		}
	}
	return cnt;
}

int main() {
	cin >> T;
	for (int t = 0; t < T; t++) {
		cin >> M >> N >> K;
		memset(field, 0, sizeof(field)), memset(visited, 0, sizeof(visited));
		for (int i = 0; i < K; i++) {
			cin >> y >> x;
			field[x][y] = 1;
		}
		cout << BFS() << endl;
	}
	return 0;
}