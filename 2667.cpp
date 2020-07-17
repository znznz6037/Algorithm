#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int N, map[26][26] = { 0, }, visited[26][26] = { 0, };
int dir[4][2] = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
int group[320] = { 0, };

int checkRange(int nextX, int nextY) {
	if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) return 0;
	else return 1;
}

bool cmp(int x, int y) {
	if (x < y) return true;
	return false;
}

void BFS() {
	queue<pair<int, int>>q;
	int nextX, nextY, cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] && !visited[i][j]) {
				visited[i][j] = 1;
				q.push(make_pair(i, j));
				group[cnt]++;
				while (!q.empty()) {
					int ax = q.front().first, ay = q.front().second;
					q.pop();
					for (int k = 0; k < 4; k++) {
						nextX = ax + dir[k][0], nextY = ay + dir[k][1];
						if (checkRange(nextX, nextY) && map[nextX][nextY] && !visited[nextX][nextY]) {
							visited[nextX][nextY] = 1;
							group[cnt]++;
							q.push(make_pair(nextX, nextY));
						}
					}
				}
				cnt++;
			}
		}
	}
	sort(group, group + cnt, cmp);
	cout << cnt << endl;
	for (int i = 0; i < cnt; i++) cout << group[i] << endl;
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) 
		for (int j = 0; j < N; j++) scanf_s("%1d", &map[i][j]);
	BFS();
	return 0;
}