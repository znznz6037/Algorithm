#include <iostream>
#include <queue>

using namespace std;

int N, arr[101][101] = { 0, }, time = 0;
int length = 1, curDir = 0, curX = 0, curY = 0;
int dir[4][2] = { {0, 1}, {1, 0}, {0, -1},{-1, 0} }; // 동 남 서 북

queue<pair<int, char>> q;
queue<pair<int, int>> snake;

void snakeDir(char d) {
	if (d == 'L') curDir += -1;
	else if (d == 'D') curDir += 1;

	if (curDir < 0) curDir = 3;
	else if (curDir > 3) curDir = 0;
}

int isOver() {
	if (curX >= N || curX < 0 || curY >= N || curY < 0 || arr[curY][curX] == 2) return 1;
	return 0;
}

int move() {
	//방향 전환
	if (!q.empty() && (q.front().first == time)) {
		snakeDir(q.front().second);
		q.pop();
	}

	curX += dir[curDir][1], curY += dir[curDir][0];
	if (isOver()) return 0; //게임 끝났는지 체크

	snake.push(make_pair(curY, curX));

	//사과 체크
	if (!snake.empty() && arr[curY][curX] != 1) { // 사과가 없다면 꼬리 없애기
		int rearY = snake.front().first, rearX = snake.front().second;
		snake.pop();
		arr[rearY][rearX] = 0;
	}
	arr[curY][curX] = 2; // 현재 머리 부분 추가
	time++;
	return 1;
}

int main() {
	int K;
	cin >> N >> K;
	//사과의 위치
	for (int i = 0; i < K; i++) {
		int aY, aX;
		cin >> aY >> aX;
		arr[aY - 1][aX - 1] = 1;
	}
	arr[0][0] = 2;
	snake.push(make_pair(0, 0));

	int dirN;
	cin >> dirN;
	//방향 변환
	for (int i = 0; i < dirN; i++) {
		int t;
		char d;
		cin >> t >> d;
		q.push(make_pair(t, d));
	}

	while (move());

	cout << ++time;
	return 0;
}