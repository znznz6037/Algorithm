#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct pos {
	int cctv;
	int y;
	int x;
	pos(int cctv, int y, int x) : cctv(cctv), y(y), x(x) {};
};

vector<pos>vec;
vector<vector<int>> map(8, vector<int>(8, 0));
int N, M;
int minAnswer = 100, cctv_cnt = 0;

void move(int dir, int y, int x) {
	switch (dir) {
	case 0:
		for (int i = y - 1; i >= 0; i--) {
			if (map[i][x] == 6) break;
			if (map[i][x] == 0) map[i][x] = -1;
		}
		break;
	case 1:
		for (int i = x + 1; i < M; i++) {
			if (map[y][i] == 6) break;
			if (map[y][i] == 0) map[y][i] = -1;
		}
		break;
	case 2:
		for (int i = y + 1; i < N; i++) {
			if (map[i][x] == 6) break;
			if (map[i][x] == 0) map[i][x] = -1;
		}
		break;
	case 3:
		for (int i = x - 1; i >= 0; i--) {
			if (map[y][i] == 6) break;
			if (map[y][i] == 0) map[y][i] = -1;
		}
		break;
	}
}

void dfs(int step) {
	if (step == cctv_cnt) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) cnt++;
			}
		}
		minAnswer = min(minAnswer, cnt);
		return;
	}

	int cctv = vec[step].cctv;
	int y = vec[step].y, x = vec[step].x;
	vector<vector<int>> map2 = map;

	switch (cctv) {
	case 1:
		for (int dir = 0; dir < 4; dir++) {
			move(dir, y, x);
			dfs(step + 1);
			map = map2;
		}
		break;
	case 2:
		for (int dir = 0; dir < 2; dir++) {
			move(dir, y, x);
			move(dir + 2, y, x);
			dfs(step + 1);
			map = map2;
		}
		break;
	case 3:
		for (int dir = 0; dir < 4; dir++) {
			move(dir, y, x);
			move((dir + 1) % 4, y, x);
			dfs(step + 1);
			map = map2;
		}
		break;
	case 4:
		for (int dir = 0; dir < 4; dir++) {
			move(dir, y, x);
			move((dir + 1) % 4, y, x);
			move((dir + 2) % 4, y, x);
			dfs(step + 1);
			map = map2;
		}
		break;
	case 5:
		for (int dir = 0; dir < 4; dir++) move(dir, y, x);
		dfs(step + 1);
		break;
	}
}


int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] && map[i][j] < 6) {
				cctv_cnt++;
				vec.push_back(pos(map[i][j], i, j));
			}
		}
	}
	dfs(0);
	cout << minAnswer;
	return 0;
}





/* CCTV가 일제히 같은 방향으로 회전하는 줄 알았음..
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
int office[9][9] = { 0, }, arr[9][9] = { 0, };
int dir[4][2] = {
	{0, 1},
	{1, 0},
	{0, -1},
	{-1, 0}
};

int curDir = 0;
int cctv2[2][2] = { {0,2}, {1, 3} };
int cctv3[4][2] = { {0,3}, {0,1}, {2,1}, {2,3} };
int cctv4[2][3] = { {0,2,3},{0,2,1} };

int isBorder(int y, int x) {
	if ((y >= N && y != 35) || y < 0 || (x >= M && x != 35) || x < 0 || arr[y][x] == 6)return 1;
	//cout << y << " " << x << endl;
	return 0;
}

int checkAnswer(int tmp[9][9]) {
	int ans = 0;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			if (tmp[i][j] == 0) ans++;
	return ans;
}

void copyArr() {
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			arr[i][j] = office[i][j];
}

void checkRange(int idx, int y, int x) {
	int tmpY = y, tmpX = x;
	if (idx == 1) {
		while (1) {
			int nextY = tmpY + dir[curDir][0], nextX = tmpX + dir[curDir][1];
			tmpY = nextY, tmpX = nextX;
			if (isBorder(nextY, nextX)) break;
			if (arr[nextY][nextX] && arr[nextY][nextX] < 6) continue;
			arr[nextY][nextX] = '#';
			tmpY = nextY, tmpX = nextX;
		}
	}
	if (idx == 2) {
		int locDir = curDir % 2;
		for (int i = 0; i < 2; i++) {
			tmpY = y, tmpX = x;
			while (1) {
				int nextY = tmpY + dir[cctv2[locDir][i]][0], nextX = tmpX + dir[cctv2[locDir][i]][1];
				tmpY = nextY, tmpX = nextX;
				if (isBorder(nextY, nextX)) break;
				if (arr[nextY][nextX] && arr[nextY][nextX] < 6) continue;
				arr[nextY][nextX] = '#';
			}
		}
	}
	if (idx == 3) {
		for (int i = 0; i < 2; i++) {
			tmpY = y, tmpX = x;
			while (1) {
				int nextY = tmpY + dir[cctv3[curDir][i]][0], nextX = tmpX + dir[cctv3[curDir][i]][1];
				tmpY = nextY, tmpX = nextX;
				if (isBorder(nextY, nextX)) break;
				if (arr[nextY][nextX] && arr[nextY][nextX] < 6) continue;
				arr[nextY][nextX] = '#';
			}
		}
	}
	if (idx == 4) {
		int locDir = curDir % 2;
		for (int i = 0; i < 3; i++) {
			tmpY = y, tmpX = x;
			while (1) {
				int nextY = tmpY + dir[cctv4[locDir][i]][0], nextX = tmpX + dir[cctv4[locDir][i]][1];
				tmpY = nextY, tmpX = nextX;
				if (isBorder(nextY, nextX)) break;
				if (arr[nextY][nextX] && arr[nextY][nextX] < 6) continue;
				arr[nextY][nextX] = '#';
			}
		}
	}
	if (idx == 5) {
		for (int i = 0; i < 4; i++) {
			tmpY = y, tmpX = x;
			while (1) {
				int nextY = tmpY + dir[i][0], nextX = tmpX + dir[i][1];
				tmpY = nextY, tmpX = nextX;
				if (isBorder(nextY, nextX)) break;
				if (arr[nextY][nextX] && arr[nextY][nextX] < 6) continue;
				arr[nextY][nextX] = '#';
			}
		}
	}
}

int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) 
		for (int j = 0; j < M; j++)
			cin >> office[i][j];

	int minAns = 64;
	for (int i = 0; i < 4; i++) {
		copyArr();
		curDir = i;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (arr[y][x] == 1) checkRange(1, y, x);
				if (arr[y][x] == 2) checkRange(2, y, x);
				if (arr[y][x] == 3) checkRange(3, y, x);
				if (arr[y][x] == 4) checkRange(4, y, x);
				if (arr[y][x] == 5) checkRange(5, y, x);
			}
		}
		minAns = min(minAns, checkAnswer(arr));
	}

	cout << minAns << endl;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cout << arr[i][j] << " ";
		}
		cout << endl;
	}



	return 0;
}
*/