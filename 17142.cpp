#include<iostream>
#include<queue>
#include<vector>
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#include<algorithm>

using namespace std;

#define MIN 987654321
#define MAX 50
#define VIRUS_MAX 10

int arr[MAX][MAX];
int visit[MAX][MAX];
int N, M;
int secure_count = 0;
int result = MIN;
bool Virus_visit[VIRUS_MAX];
vector<pair<int, int>> virus;
int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

void BFS(int max_virus) {
	queue<pair<int, int>> q;
	memset(visit, -1, sizeof(visit));
	for (int i = 0; i < max_virus; i++) {
		if (Virus_visit[i]) {
			q.push(make_pair(virus[i].first, virus[i].second));
			visit[virus[i].first][virus[i].second] = 0;
		}
	}

	int check = 0; int time = 0;
	while (!q.empty()) {
		int x = q.front().first; int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i]; int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (arr[nx][ny] != 1 && visit[nx][ny] == -1) {
				visit[nx][ny] = visit[x][y] + 1;
				if (arr[nx][ny] == 0) {
					check++;
					time = visit[nx][ny];
				}
				q.push(make_pair(nx, ny));
			}
		}
	}
	if (check == secure_count) result = min(result, time);
}

void Virus_Check(int virus_index, int virus_count, int virus_size) {
	if (virus_count == M) {
		BFS(virus_size);
		return;
	}
	for (int i = virus_index; i < virus_size; i++) {
		if (!Virus_visit[i]) {
			Virus_visit[i] = true;
			Virus_Check(i + 1, virus_count + 1, virus_size);
			Virus_visit[i] = false;
		}
	}
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 2) virus.push_back(make_pair(i, j));
			if (arr[i][j] == 0) secure_count++;
		}
	}

	Virus_Check(0, 0, virus.size());
	if (result == MIN) cout << -1;
	else cout << result;
	return 0;
}