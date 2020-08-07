#include <iostream>
#include <queue>
#include <math.h>

using namespace std;

int N, M, arr[501][501] = { 0, }, maxValue = 0;
bool visited[501][501] = { 0, };

void clearQueue(queue<pair<int, int>>& sq) {
    queue<pair<int, int>>empty;
    swap(sq, empty);
}

int BFS1() {
    queue<pair<int, int>>q;
    int x, y , result = 0, sum = 0;
    q.push(make_pair(0, 0));
    while (!q.empty()) {
        y = q.front().first, x = q.front().second;
        q.pop();
        if (x + 3 <= M) {
            q.push(make_pair(y, x + 1));
            sum = arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y][x + 3];
            if (result < sum) result = sum;
        }
        else if (y + 1 < N) q.push(make_pair(y + 1, 0));
    }

    clearQueue(q);
    q.push(make_pair(0, 0));
    while (!q.empty()) {
        y = q.front().first, x = q.front().second;
        q.pop();
        if (y + 3 <= N) {
            q.push(make_pair(y + 1, x));
            sum = arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 3][x];
            if (result < sum) result = sum;
        }
        else if (x + 1 < M) q.push(make_pair(0, x + 1));
    }

    return result;
}

int BFS2() {
    queue<pair<int, int>>q;
    int x, y, result = 0, sum = 0;
    q.push(make_pair(0, 0));
    while (!q.empty()) {
        y = q.front().first, x = q.front().second;
        q.pop();
        if (x + 1 <= M && y + 1 <= N) {
            q.push(make_pair(y, x + 1));
            sum = arr[y][x] + arr[y][x + 1] + arr[y + 1][x] + arr[y + 1][x + 1];
            if (result < sum) result = sum;
        }
        else if (x >= M && y < N) q.push(make_pair(y + 1, 0));
        else if (x + 2 > M&& y + 2 > N) break;
    }

    return result;
}

/*
xxx
xxx 인 경우
    1   1
1 1 1   1 1 1 3

1 1 1   1 1 1 3
    1   1

  1 1   1 1
1 1       1 1 4

  1    1 1 1
1 1 1    1    5
*/
int width[8][2][3] = {
    { {0, 0, 1}, {1, 1, 1} },
    { {1, 0, 0}, {1, 1, 1} },
    { {1, 1, 1}, {0, 0, 1} },
    { {1, 1, 1}, {1, 0, 0} },
    { {0, 1, 1}, {1, 1, 0} },
    { {1, 1, 0}, {0, 1, 1} },
    { {0, 1, 0}, {1, 1, 1} },
    { {1, 1, 1}, {0, 1, 0} }
};

int BFS_width() {
    queue<pair<int, int>>q;
    int x, y, result = 0, sum = 0;
    q.push(make_pair(0, 0));
    while (!q.empty()) {
        y = q.front().first, x = q.front().second;
        q.pop();
        if (x + 2 <= M && y < N) {
            if (x + 2 == M && y < N) q.push(make_pair(y + 1, 0));
            else q.push(make_pair(y, x + 1));
            for (int k = 0; k < 8; k++) {
                sum = 0;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (width[k][i][j]) {
                            sum += arr[y + i][x + j];
                        }
                    }
                }
                if (result < sum) result = sum;
            }
        }
        else if (x + 2 > M && y + 2 > N) break;
    }

    return result;
}

/*
xx
xx
xx 인 경우

1      1
1      1
1 1  1 1 3

1 1  1 1
1      1
1      1 3

1      1
1 1  1 1
  1  1   4

  1  1
1 1  1 1 5
  1  1

*/

int height[8][3][2] = {
    { {1, 0}, {1, 0}, {1, 1}},
    { {0, 1}, {0, 1}, {1, 1}},
    { {1, 1}, {1, 0}, {1, 0}},
    { {1, 1}, {0, 1}, {0, 1}},
    { {1, 0}, {1, 1}, {0, 1}},
    { {0, 1}, {1, 1}, {1, 0}},
    { {0, 1}, {1, 1}, {0, 1}},
    { {1, 0}, {1, 1}, {1, 0}},
};

int BFS_height() {
    queue<pair<int, int>>q;
    int x, y, result = 0, sum = 0;
    q.push(make_pair(0, 0));
    while (!q.empty()) {
        y = q.front().first, x = q.front().second;
        q.pop();
        if (x < M && y + 2 <= N) {
            if (x < M && y + 2 == N) q.push(make_pair(0, x + 1));
            else q.push(make_pair(y + 1, x));
            for (int k = 0; k < 8; k++) {
                sum = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (height[k][i][j]) {
                            sum += arr[y + i][x + j];
                        }
                    }
                }
                if (result < sum) result = sum;
            }
        }
        else if (x + 1 >= M && y + 2 > N) break;
    }

    return result;
}


int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++) cin >> arr[i][j];
    maxValue = max(BFS1(), BFS2());
    maxValue = max(maxValue, BFS_height());
    maxValue = max(maxValue, BFS_width());
    cout << maxValue;
	return 0;
}