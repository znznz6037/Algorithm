#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N, M, fuel = 0, taxi_y = 0, taxi_x = 0;
int dir[4][2] = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
int passCnt[21][21] = { 0, };
vector<pair<int, int>> passList;
vector<vector<int>> map(21, vector<int>(21));
vector<vector<pair<int, int>>> passengerMap(21, vector<pair<int, int>>(21));

bool distComp(pair<pair<int ,int>, int> a, pair<pair<int, int>, int> b) {
	if (a.second == b.second) {
		if (a.first.first == b.first.first) return a.first.second < b.first.second;
		return a.first.first < b.first.first;
	}
	return a.second < b.second;
}

// 최단경로 목적지로 이동
int destination_BFS(int Y, int X, int dest_y, int dest_x) {
	queue<pair<int, int>> q;
	vector<vector<int>> visited(21, vector<int>(21));
	q.push(make_pair(Y, X));
	visited[Y][X] = 1;
	if (Y == dest_y && X == dest_x) {
		return 1;
	}
	while (!q.empty()) {
		int y = q.front().first, x = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = y + dir[i][0], nx = x + dir[i][1];
			if (ny < 1 || ny > N || nx < 1 || nx > N || map[ny][nx] == 1 || visited[ny][nx]) continue;
			if (ny == dest_y && nx == dest_x) { // 목적지일 경우
				fuel -= visited[y][x];
				if (fuel < 0) return -1;
				fuel += visited[y][x] * 2;
				taxi_y = ny, taxi_x = nx;
				return 1;
			}
			if (visited[ny][nx] == fuel) continue; // 연료 다 쓴 경우
			q.push(make_pair(ny, nx));
			visited[ny][nx] = visited[y][x] + 1;
		}
	}
	return -1;
}

//최단경로 손님 찾기
int passenger_BFS(int Y, int X) {
	int curFuel = fuel;
	queue<pair<int, int>> q;
	vector<vector<int>> visited(21, vector<int>(21));
	vector<pair<pair<int, int>, int>> pass;
	q.push(make_pair(Y, X));
	visited[Y][X] = 1;
	if (map[Y][X] == 2) {
		map[Y][X] = 0;
		return destination_BFS(Y, X, passengerMap[Y][X].first, passengerMap[Y][X].second);
	}
	else {
		while (!q.empty()) {
			int y = q.front().first, x = q.front().second;
			q.pop();
			for (int i = 0; i < 4; i++) {
				int ny = y + dir[i][0], nx = x + dir[i][1];
				if (ny < 1 || ny > N || nx < 1 || nx > N || visited[ny][nx] || map[ny][nx] == 1) continue;
				if (map[ny][nx] == 2) pass.push_back(make_pair(make_pair(ny, nx), visited[y][x]));
				if (visited[ny][nx] == curFuel) continue; 
				q.push(make_pair(ny, nx));
				visited[ny][nx] = visited[y][x] + 1;
			}
		}
		if (pass.empty()) return -1;
		else {
			sort(pass.begin(), pass.end(), distComp);
			int pass_y = pass[0].first.first, pass_x = pass[0].first.second;
			map[pass_y][pass_x] = 0;
			fuel -= pass[0].second;
			if (fuel < 0) return -1;
			return destination_BFS(pass_y, pass_x, passengerMap[pass_y][pass_x].first, passengerMap[pass_y][pass_x].second);
		}
	}
}

int main() {
	int result = 0;
	cin >> N >> M >> fuel;
	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= N; j++) cin >> map[i][j];

	cin >> taxi_y >> taxi_x;
	for (int i = 0; i < M; i++) {
		int y, x, dy, dx;
		cin >> y >> x >> dy >> dx;
		map[y][x] = 2;
		passCnt[y][x]++;
		passengerMap[y][x] = make_pair(dy, dx);
	}
	while (M--) {
		result = passenger_BFS(taxi_y, taxi_x);
		if (result < 0) {
			cout << -1;
			return 0;
		}
	}
	
	cout << fuel;

	return 0;
}