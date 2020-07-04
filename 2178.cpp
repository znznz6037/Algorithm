#include <iostream>
#include <queue>
using namespace std;

int N, M;
int maze[101][101] = { 0 , }, dist[101][101] = { 0, };
int dir[4][2] = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
bool visited[101][101] = { false, };

void BFS() {
	queue<pair<int, int>> q;
	q.push(make_pair(0, 0));
	visited[0][0] = true;
	dist[0][0] = 1;
	while (!q.empty()) {
		int x = q.front().first, y = q.front().second;
		q.pop();
		if (x == M - 1 && y == N - 1) break;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0], nextY = y + dir[i][1];
			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
			if (maze[nextX][nextY] && !visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				q.push(make_pair(nextX, nextY));
				dist[nextX][nextY] = dist[x][y] + 1;
			}
		}
	}

}

int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			scanf_s("%1d", &maze[i][j]);
	BFS();
	cout << dist[N - 1][M - 1];
}

/* DFS는 모든 경우의 수를 탐색하여 지수승으로 시간 초과
void dfs(int x, int y, int count) {
	visited[x][y] = true;
	if (x == xnum - 1 && y == ynum - 1) visited[x][y] = false;
	if (x == xnum - 1 && y == ynum - 1 && maze[xnum - 1][ynum - 1] == 1) {
		result = result >= count ? count : result;
		return;
	}
	for (int i = 0; i < 4; i++) {
		if (x + dir[i][0] < 0 || x + dir[i][0] >= xnum || y + dir[i][1] < 0 || y + dir[i][1] >= ynum) continue;
		if (maze[x + dir[i][0]][y + dir[i][1]] == 1 && !visited[x + dir[i][0]][y + dir[i][1]]) dfs(x + dir[i][0], y + dir[i][1], count + 1);
	}
}

int main() {
	memset(visited, false, sizeof(visited));
	cin >> xnum >> ynum;
	for (int i = 0; i < xnum; i++) {
		for (int j = 0; j < ynum; j++) {
			scanf("%1d", &maze[i][j]);
		}
	}
	dfs(0, 0, 1);
	cout << result;
}
*/