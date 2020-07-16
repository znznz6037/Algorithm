#include <iostream>

using namespace std;

int N, M, x, y, K, tmp1, tmp2;

int map[21][21] = { 0, };
int command[1001] = { 0, };
int dice[4][3] = { 0, };

void checkMap() {
    if (map[x][y] == 0) map[x][y] = dice[3][1];
    else {
        dice[3][1] = map[x][y];
        map[x][y] = 0;
    }
}

/* ±âÁØ
  2
4 1 3
  5
  6 */

/* ºÏÂÊ 1Ä­
  6
4 2 3
  1
  5 */
int north() {
    if (x - 1 < 0) return 0;
    tmp1 = dice[0][1];
    dice[0][1] = dice[3][1];
    tmp2 = dice[1][1];
    dice[1][1] = tmp1;
    tmp1 = dice[2][1];
    dice[2][1] = tmp2;
    dice[3][1] = tmp1;
    --x;
    checkMap();
    return 1;
}

/* µ¿ÂÊ 1Ä­
  2
1 3 6
  5
  4 */
int east() {
    if (y + 1 >= M) return 0;
    tmp1 = dice[1][1]; // 1
    dice[1][1] = dice[1][2];
    tmp2 = dice[1][0]; 
    dice[1][0] = tmp1;
    tmp1 = dice[3][1];
    dice[3][1] = tmp2;
    tmp2 = dice[1][2];
    dice[1][2] = tmp1;
    ++y;
    checkMap();
    return 1;
}

/* ¼­ÂÊ 1Ä­
  2
6 4 1
  5
  3 */
int west() {
    if (y - 1 < 0) return 0;
    tmp1 = dice[1][0];
    dice[1][0] = dice[3][1];
    tmp2 = dice[1][1];
    dice[1][1] = tmp1;
    tmp1 = dice[1][2];
    dice[1][2] = tmp2;
    dice[3][1] = tmp1;
    --y;
    checkMap();
    return 1;
}

/* ³²ÂÊ 1Ä­
  1
4 5 3
  6
  2 */
int south() {
    if (x + 1 >= N) return 0;
    tmp1 = dice[0][1];
    dice[0][1] = dice[1][1];
    tmp2 = dice[3][1];
    dice[3][1] = tmp1;
    tmp1 = dice[2][1];
    dice[2][1] = tmp2;
    dice[1][1] = tmp1;
    ++x;
    checkMap();
    return 1;
}

int main() {
	cin >> N >> M >> x >> y >> K;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}
	for (int i = 0; i < K; i++) cin >> command[i];
    
    for (int i = 0; i < K; i++) {
        switch (command[i]) {
        case 1:
            if(east()) cout << dice[1][1] << endl;
            break;
        case 2:
            if (west()) cout << dice[1][1] << endl;
            break;
        case 3:
            if(north()) cout << dice[1][1] << endl;
            break;
        case 4:
            if (south()) cout << dice[1][1] << endl;
            break;
        }
    }
	return 0;
}