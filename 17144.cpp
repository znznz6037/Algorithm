#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int R, C, T;
int map[51][51] = { 0, }, spreadMap[51][51] = { 0, };
int spreadDir[4][2] = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
int cleaner1Dir[4][2] = { {0, 1}, {-1, 0}, {0, -1}, {1 , 0} };
int cleaner2Dir[4][2] = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
int airCleaner_y = 0;

void spread(int y, int x) {
	vector<pair<int, int>> spreadList;
	int dirNum = 0, dust = map[y][x];
	for (int i = 0; i < 4; i++) {
		int nr = y + spreadDir[i][0], nc = x + spreadDir[i][1];
		if (map[nr][nc] == -1 || nr < 1 || nr > R || nc < 1 || nc > C) continue;
		dirNum++;
		spreadList.push_back(make_pair(nr, nc));
	}
	
	for (int i = 0; i < dirNum; i++) 
		spreadMap[spreadList[i].first][spreadList[i].second] += dust / 5;

	map[y][x] -= (dust / 5) * dirNum;
}

void airCleaner() {
	//first cleaner
	vector<pair<int, int>> cleaner;
	vector<int> dustList;
	int y = 0, x = 0, nx = 2, ny = airCleaner_y - 1, size = 0;
	cleaner.push_back(make_pair(ny, nx));
	dustList.push_back(map[ny][nx]);
	for (int i = 0; i < 4; i++) {
		while (1) {
			ny += cleaner1Dir[i][0], nx += cleaner1Dir[i][1];
			if (map[ny][nx] == -1) break;
			cleaner.push_back(make_pair(ny, nx)), dustList.push_back(map[ny][nx]);
			if (ny == 1 && nx == 1 || ny == airCleaner_y - 1 && nx == C || ny == 1 && nx == C) break;
		}
	}
	size = cleaner.size();
	for (int i = 1; i < size; i++) {
		map[cleaner[i].first][cleaner[i].second] = dustList[i - 1];
	}
	map[airCleaner_y - 1][2] = 0;
	cleaner.clear(), dustList.clear();
	
	//second cleaner
	nx = 2, ny = airCleaner_y;
	cleaner.push_back(make_pair(ny, nx));
	dustList.push_back(map[ny][nx]);
	for (int i = 0; i < 4; i++) {
		while (1) {
			ny += cleaner2Dir[i][0], nx += cleaner2Dir[i][1];
			if (map[ny][nx] == -1) break;
			cleaner.push_back(make_pair(ny, nx)), dustList.push_back(map[ny][nx]);
			if (ny == R && nx == 1 || ny == airCleaner_y && nx == C || ny == R && nx == C) break;
		}
	}
	size = cleaner.size();
	for (int i = 1; i < size; i++) {
		map[cleaner[i].first][cleaner[i].second] = dustList[i - 1];
	}
	map[airCleaner_y][2] = 0;
}

int dustSum() {
	int sum = 0;
	for (int i = 1; i <= R; i++) 
		for (int j = 1; j <= C; j++) 
			if (map[i][j] > 0) sum += map[i][j];
	return sum;
}

int main() {
	cin >> R >> C >> T;
	for (int i = 1; i <= R; i++) {
		for (int j = 1; j <= C; j++) {
			cin >> map[i][j];
			if (map[i][j] == -1) {
				airCleaner_y = i;
			}
		}
	}

	while (T--) {
		for (int i = 1; i <= R; i++)
			for (int j = 1; j <= C; j++)
				spread(i, j);

		for (int i = 1; i <= R; i++)
			for (int j = 1; j <= C; j++)
				map[i][j] += spreadMap[i][j];
		memset(spreadMap, 0, sizeof(spreadMap));
		airCleaner();
	}

	cout << dustSum();	
	
	return 0;
}