#include <iostream>
#include <cmath>

using namespace std;

int gearWheel[5][8], K, rotation[101][2];

int direction(int dir) {
	if (dir == 1) return -1;
	else return 1;
}

void rotateWheel(int idx, int dir) {
	int tmpArr[8];
	if (dir == 1) {
		for (int i = 1; i < 8; i++) tmpArr[i] = gearWheel[idx][i - 1];
		tmpArr[0] = gearWheel[idx][7];
		for (int i = 0; i < 8; i++) gearWheel[idx][i] = tmpArr[i];
	}
	else {
		for (int i = 6; i >= 0; i--) tmpArr[i] = gearWheel[idx][i + 1];
		tmpArr[7] = gearWheel[idx][0];
		for (int i = 0; i < 8; i++) gearWheel[idx][i] = tmpArr[i];
	}
}

void Rotate(int idx, int dir) {
	int curdir = dir;
	int check[5] = { 0, };
	for (int i = idx; i < 4; i++) {
		if (gearWheel[i][2] != gearWheel[i + 1][6]) check[i + 1] = 1;
		else break;
	}
	for (int i = idx; i < 5; i++) {
		if(check[i]) rotateWheel(i, curdir = direction(curdir));
	}
	curdir = dir;
	for (int i = idx; i > 1; i--) {
		if (gearWheel[i][6] != gearWheel[i - 1][2]) check[i - 1] = 1;
		else break;
	}
	for (int i = idx; i > 0; i--) {
		if (check[i]) rotateWheel(i, curdir = direction(curdir));
	}
	rotateWheel(idx, dir);
}

int main() {
	for (int i = 1; i < 5; i++)
		for (int j = 0; j < 8; j++) scanf_s("%1d", &gearWheel[i][j]);
	cin >> K;
	for (int i = 0; i < K; i++) {
		cin >> rotation[i][0] >> rotation[i][1];
		Rotate(rotation[i][0], rotation[i][1]);
	}
	int sum = 0;
	for (int i = 0; i < 4; i++) if (gearWheel[i + 1][0]) sum += pow(2, i);
	cout << sum;
	return 0;
}

/*
N 0 S 1
1번 2
2번 6 2
3번 6 2
4번 6

10101111
01


시계방향 11010111
반시계방향 01011111


*/