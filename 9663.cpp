#include <iostream>
#include <cstring>

using namespace std;

int N, col[15], cnt = 0;

bool isPromising(int row) {
	for (int i = 1; i < row; i++) {
		if (col[i] == col[row]) return false;
		if (abs(col[i] - col[row]) == abs(i - row))return false;
	}
	return true;
}

void dfs(int row) {
	if (row > N) cnt++;
	else {
		for (int i = 1; i <= N; i++) {
			col[row] = i;
			if (isPromising(row)) dfs(row + 1);
			else col[row] = 0;
		}
	}
}

int main() {
	cin >> N;
	for (int i = 1; i <= N; i++) {
		memset(col, 0, sizeof(col));
		col[1] = i;
		dfs(2);
	}
	cout << cnt << endl;
	return 0;
}