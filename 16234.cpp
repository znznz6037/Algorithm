#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

struct pos {
	int y;
	int x;
	int idx;
	pos(int Y, int X, int Idx) : y(Y), x(X), idx(Idx) {};
};

int N, L, R, groupCnt = 0, unionN = 0;
int A[101][101] = { 0, }, visited[101][101] = { 0, };
vector<pos> nearby;
vector<int> groupSum;
queue<pair<int, int>> list;

void visitGroup(int y, int x, int n) {
	list.push(make_pair(y, x));
	nearby.push_back(pos(y, x, n));
	visited[y][x] = 1;
}

void checkUnion(int Y, int X) {
	groupCnt++;
	list.push(make_pair(Y, X));
	nearby.push_back(pos(Y, X, groupCnt));
	visited[Y][X] = 1;
	while (!list.empty()) {
		int y = list.front().first, x = list.front().second;
		if (y + 1 < N && abs(A[y][x] - A[y + 1][x]) <= R && abs(A[y][x] - A[y + 1][x]) >= L && !visited[y + 1][x]) visitGroup(y + 1, x, groupCnt);
		if (y - 1 >= 0 && abs(A[y][x] - A[y - 1][x]) <= R && abs(A[y][x] - A[y - 1][x]) >= L && !visited[y - 1][x]) visitGroup(y - 1, x, groupCnt);
		if (x + 1 < N && abs(A[y][x] - A[y][x + 1]) <= R && abs(A[y][x] - A[y][x + 1]) >= L && !visited[y][x + 1]) visitGroup(y, x + 1, groupCnt);
		if (x - 1 >= 0 && abs(A[y][x] - A[y][x - 1]) <= R && abs(A[y][x] - A[y][x - 1]) >= L && !visited[y][x - 1]) visitGroup(y, x - 1, groupCnt);
		list.pop();
	}

	int sum = 0, cnt = 0;
	for (int i = nearby.size() - 1; i >= 0; i--) {
		if (nearby[i].idx == groupCnt) {
			sum += A[nearby[i].y][nearby[i].x];
			cnt++;
		}
	}
	groupSum.push_back(sum / cnt);
	for (int i = nearby.size() - 1; i >= 0; i--) {
		A[nearby[i].y][nearby[i].x] = groupSum[nearby[i].idx - 1];
		nearby.pop_back();
	}
}

int main() {
	cin >> N >> L >> R;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> A[i][j];
		}
	}
	
	while (1) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) checkUnion(i, j);
			}
		}

		if (groupCnt == N * N) {
			cout << unionN;
			break;
		}

		unionN++;
		if (groupCnt == 1) {
			cout << unionN;
			break;
		}

		nearby.clear(), groupSum.clear();
		groupCnt = 0, memset(visited, 0, sizeof(visited));
	}
	return 0;
}

/*
시간 초과 소스
#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

struct pos {
	int y;
	int x;
	int idx;
	pos(int Y, int X, int Idx) : y(Y), x(X), idx(Idx) {};
};

int N, L, R, groupCnt = 0, unionN = 0;
int A[101][101] = { 0, }, visited[101][101] = { 0, };
vector<pos> nearby;
vector<int> groupSum;
queue<pos> list;

void visitGroup(int y, int x, int n) {
	list.push(pos(y, x, n));
	nearby.push_back(pos(y, x, n));
	visited[y][x] = 1;
}

void checkUnion(int Y, int X) {
	groupCnt++;
	list.push(pos(Y, X, groupCnt));
	nearby.push_back(pos(Y, X, groupCnt));
	visited[Y][X] = 1;
	while (!list.empty()) {
		int y = list.front().y, x = list.front().x;
		if (y + 1 < N && abs(A[y][x] - A[y + 1][x]) <= R && abs(A[y][x] - A[y + 1][x]) >= L && !visited[y + 1][x]) visitGroup(y + 1, x, groupCnt);
		if (y - 1 >= 0 && abs(A[y][x] - A[y - 1][x]) <= R && abs(A[y][x] - A[y - 1][x]) >= L && !visited[y - 1][x]) visitGroup(y - 1, x, groupCnt);
		if (x + 1 < N && abs(A[y][x] - A[y][x + 1]) <= R && abs(A[y][x] - A[y][x + 1]) >= L && !visited[y][x + 1]) visitGroup(y, x + 1, groupCnt);
		if (x - 1 >= 0 && abs(A[y][x] - A[y][x - 1]) <= R && abs(A[y][x] - A[y][x - 1]) >= L && !visited[y][x - 1]) visitGroup(y, x - 1, groupCnt);
		list.pop();
	}
}

void calSum() {
	for (int group = 1; group <= groupCnt; group++) {
		int sum = 0, cnt = 0;
		for (int i = 0; i < nearby.size(); i++) {
			if (nearby[i].idx == group) {
				sum += A[nearby[i].y][nearby[i].x];
				cnt++;
			}
		}
		groupSum.push_back(sum / cnt);
	}
}

int main() {
	cin >> N >> L >> R;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> A[i][j];
		}
	}

	while (1) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) checkUnion(i, j);
			}
		}

		if (groupCnt == N * N) {
			cout << unionN;
			break;
		}

		unionN++;
		if (groupCnt == 1) {
			cout << unionN;
			break;
		}
		calSum();
		for (int i = 0; i < nearby.size(); i++) {
			A[nearby[i].y][nearby[i].x] = groupSum[nearby[i].idx - 1];
		}

		nearby.clear(), groupSum.clear();
		groupCnt = 0, memset(visited, 0, sizeof(visited));
	}
	return 0;
}
*/