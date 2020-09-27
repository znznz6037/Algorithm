#include <iostream>
#include <vector>

using namespace std;

int N, x, y, d, g; //d : 방향, g : 세대
int map[101][101] = { 0, }, visited[101][101] = { 0, };
int dir[4][2] = { {0, 1}, {-1, 0}, {0, -1}, {1, 0} };
int end_y, end_x;
vector<int> curve;

void make_dragon() {
	int len = curve.size();
	for (int i = len - 1; i >= 0; i--) {
		int curDir = (curve[i] + 1) % 4;
		curve.push_back(curDir);
		end_x = end_x + dir[curDir][1], end_y = end_y + dir[curDir][0];
		map[end_y][end_x] = 1;
	}
}

int main() {
	cin >> N;
	
	for (int i = 0; i < N; i++) {
		cin >> x >> y >> d >> g;
		curve.push_back(d);
		map[y][x] = 1;
		end_y = y + dir[d][0], end_x = x + dir[d][1];
		map[end_y][end_x] = 1;
		for (int i = 1; i <= g; i++) make_dragon();
		curve.clear();
	}

	int ans = 0;
	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) ans++;
		}
	}

	cout << ans;
	return 0;
}