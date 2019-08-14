<<<<<<< HEAD
/*
#include <iostream>
#include <string>
using namespace std;

char board[5][5];
int cache[5][5][10];
string word;

int canFindWord(int y, int x, int wordIndex) {
	if ((x > 4) || (x < 0) || (y > 4) || (y < 0)) {
		return 0;
	}
	int &ret = cache[y][x][wordIndex];
	if (ret != -1) {
		return ret;
	}
	if (word.at(wordIndex) != board[y][x]) {
		return ret = 0;
	}
	wordIndex++;
	if (wordIndex >= word.size()) {
		return ret = 1;
	}
	return ret = (
		canFindWord(y - 1, x - 1, wordIndex) || canFindWord(y - 1, x, wordIndex) || canFindWord(y - 1, x + 1, wordIndex)
		|| canFindWord(y, x - 1, wordIndex) || canFindWord(y, x + 1, wordIndex)
		|| canFindWord(y + 1, x - 1, wordIndex) || canFindWord(y + 1, x, wordIndex) || canFindWord(y + 1, x + 1, wordIndex)
		);
}

int main() {
	int C;
	scanf_s("%d\n", &C);
	for (int i = 0; i < C; i++) {
		for (int j = 0; j < 5; j++) {
			scanf_s("%c%c%c%c%c\n", &board[j][0], &board[j][1], &board[j][2], &board[j][3], &board[j][4]);
		}
		int N;
		scanf_s("%d\n", &N);
		for (int j = 0; j < N; j++) {
			memset(cache, -1, sizeof(cache));
			word.clear();
			getline(cin, word);
			bool isFound = false;
			for (int k = 0; k < 5; k++) {
				for (int l = 0; l < 5; l++) {
					if (canFindWord(k, l, 0) == 1) {
						isFound = true;
						break;
					}
				}
				if (isFound) {
					break;
				}
			}
			if (isFound) {
				cout << word << " YES" << endl;
			}
			else {
				cout << word << " NO" << endl;
			}
		}
	}
	return 0;
}
*/
#include <iostream>
#include <string>
#include <string.h>
#pragma warning(disable:4996)

using namespace std;

char board[5][5];    // 입력받은 게임판
int cache[5][5][10];    // 결과값들을 저장한다. memset으로 -1로 초기화 후 사용. 1:성공, 0:실패
string word;    // 찾아야할 단어

				/*
				핵심 재귀 함수.
				(y,x) 포인트에서 word Index에 해당하는 단어를 찾는다.
				성공시 1 리턴, 실패시 0 리턴.
				리턴 값들을 캐시에도 저장한다.
				*/
int canFindWord(int y, int x, int wordIndex) {
	/* 범위를 벗어날 경우 */
	if ((x > 4) || (x < 0) || (y > 4) || (y < 0)) {
		return 0;
	}

	int& ret = cache[y][x][wordIndex];    // 이 코드를 통해 ret == cache[y][x][wordIndex] 가 된다.

										  /* 캐시에 이미 결과가 계산되어 있으면, 추가로 계산하지 않고 그 값을 그대로 리턴(활용)한다. */
	if (ret != -1) {
		return ret;
	}

	/* 여기부터 이 함수 끝까지가 실제 핵심 계산부 */

	/*
	word Index에 해당하는 단어가, 현재 게임판에서 (y,x)에 있는 단어와 다른 경우. 이미 시작부터 글러먹은 경우. (첫글자부터 틀렸다)
	: 0을 리턴하며 그 값을 캐시에 저장한다.
	*/
	if (word.at(wordIndex) != board[y][x]) {
		return ret = 0;
	}

	/*
	여기까지 왔다는 것은, 게임판에서 현재 위치 (y,x)에 내가 찾으려는 단어의 첫글자가 있다는 것이다.
	(비로소 시작할 수 있다)
	*/

	wordIndex++;    // 다음 글자(character)를 찾기 위해, index++

					/*
					index 가 범위를 벗어난 경우 (방금 전 index에 해당하는 글자가 마지막 글자였던 것이다)
					그렇다면 원하는 글자를 다 찾은 것이므로
					: 1을 리턴하며 그 값을 캐시에 저장한다.
					*/
	if (wordIndex >= word.size()) {
		return ret = 1;
	}

	/*
	o o o
	o 나o
	o o o
	나(현재위치 y,x)를 기준으로 인접한 좌표 8개 모두를 재귀로 탐색한다.
	그 중에 하나라도 찾게 된다면 성공한 것이므로 OR 연산을 시킨다.
	: 결과적으로 0이나 1이 리턴되며 그 값을 캐시에 저장한다.
	*/
	return ret = (
		canFindWord(y - 1, x - 1, wordIndex) || canFindWord(y - 1, x, wordIndex) || canFindWord(y - 1, x + 1, wordIndex)
		|| canFindWord(y, x - 1, wordIndex) || canFindWord(y, x + 1, wordIndex)
		|| canFindWord(y + 1, x - 1, wordIndex) || canFindWord(y + 1, x, wordIndex) || canFindWord(y + 1, x + 1, wordIndex)
		);
}

int main() {
	/* 테스트 케이스의 수 C */
	int C;
	scanf_s("%d\n", &C);

	for (int i = 0; i < C; i++) {
		/* 게임판 (board[5][5]) 생성 */
		for (int j = 0; j < 5; j++) {
			scanf_s("%c%c%c%c%c\n", &board[j][0], &board[j][1], &board[j][2], &board[j][3], &board[j][4]);
		}

		/* 찾을 단어의 수 N */
		int N;
		scanf_s("%d\n", &N);

		for (int j = 0; j < N; j++) {
			memset(cache, -1, sizeof(cache));    // 단어를 찾는 루프를 돌 때마다 캐시를 -1로 초기화해준다.

												 /* 찾을 단어 word */
			word.clear();
			getline(cin, word);

			bool isFound = false;

			/*
			5X5 상의 모든 점을 대상으로 탐색한다.
			발견시 isFound = true 하며, 이중 break로 완전히 탈출
			*/
			for (int k = 0; k < 5; k++) {
				for (int l = 0; l < 5; l++) {
					if (canFindWord(k, l, 0) == 1) {
						isFound = true;
						break;
					}
				}
				if (isFound) {
					break;
				}
			}

			/* 결과에 따른 출력 */
			if (isFound) {
				cout << word << " YES" << endl;
			}
			else {
				cout << word << " NO" << endl;
			}
		}
	}

	return 0;
=======
/*
#include <iostream>
#include <string>
using namespace std;

char board[5][5];
int cache[5][5][10];
string word;

int canFindWord(int y, int x, int wordIndex) {
	if ((x > 4) || (x < 0) || (y > 4) || (y < 0)) {
		return 0;
	}
	int &ret = cache[y][x][wordIndex];
	if (ret != -1) {
		return ret;
	}
	if (word.at(wordIndex) != board[y][x]) {
		return ret = 0;
	}
	wordIndex++;
	if (wordIndex >= word.size()) {
		return ret = 1;
	}
	return ret = (
		canFindWord(y - 1, x - 1, wordIndex) || canFindWord(y - 1, x, wordIndex) || canFindWord(y - 1, x + 1, wordIndex)
		|| canFindWord(y, x - 1, wordIndex) || canFindWord(y, x + 1, wordIndex)
		|| canFindWord(y + 1, x - 1, wordIndex) || canFindWord(y + 1, x, wordIndex) || canFindWord(y + 1, x + 1, wordIndex)
		);
}

int main() {
	int C;
	scanf_s("%d\n", &C);
	for (int i = 0; i < C; i++) {
		for (int j = 0; j < 5; j++) {
			scanf_s("%c%c%c%c%c\n", &board[j][0], &board[j][1], &board[j][2], &board[j][3], &board[j][4]);
		}
		int N;
		scanf_s("%d\n", &N);
		for (int j = 0; j < N; j++) {
			memset(cache, -1, sizeof(cache));
			word.clear();
			getline(cin, word);
			bool isFound = false;
			for (int k = 0; k < 5; k++) {
				for (int l = 0; l < 5; l++) {
					if (canFindWord(k, l, 0) == 1) {
						isFound = true;
						break;
					}
				}
				if (isFound) {
					break;
				}
			}
			if (isFound) {
				cout << word << " YES" << endl;
			}
			else {
				cout << word << " NO" << endl;
			}
		}
	}
	return 0;
}
*/
#include <iostream>
#include <string>
#include <string.h>
#pragma warning(disable:4996)

using namespace std;

char board[5][5];    // 입력받은 게임판
int cache[5][5][10];    // 결과값들을 저장한다. memset으로 -1로 초기화 후 사용. 1:성공, 0:실패
string word;    // 찾아야할 단어

				/*
				핵심 재귀 함수.
				(y,x) 포인트에서 word Index에 해당하는 단어를 찾는다.
				성공시 1 리턴, 실패시 0 리턴.
				리턴 값들을 캐시에도 저장한다.
				*/
int canFindWord(int y, int x, int wordIndex) {
	/* 범위를 벗어날 경우 */
	if ((x > 4) || (x < 0) || (y > 4) || (y < 0)) {
		return 0;
	}

	int& ret = cache[y][x][wordIndex];    // 이 코드를 통해 ret == cache[y][x][wordIndex] 가 된다.

										  /* 캐시에 이미 결과가 계산되어 있으면, 추가로 계산하지 않고 그 값을 그대로 리턴(활용)한다. */
	if (ret != -1) {
		return ret;
	}

	/* 여기부터 이 함수 끝까지가 실제 핵심 계산부 */

	/*
	word Index에 해당하는 단어가, 현재 게임판에서 (y,x)에 있는 단어와 다른 경우. 이미 시작부터 글러먹은 경우. (첫글자부터 틀렸다)
	: 0을 리턴하며 그 값을 캐시에 저장한다.
	*/
	if (word.at(wordIndex) != board[y][x]) {
		return ret = 0;
	}

	/*
	여기까지 왔다는 것은, 게임판에서 현재 위치 (y,x)에 내가 찾으려는 단어의 첫글자가 있다는 것이다.
	(비로소 시작할 수 있다)
	*/

	wordIndex++;    // 다음 글자(character)를 찾기 위해, index++

					/*
					index 가 범위를 벗어난 경우 (방금 전 index에 해당하는 글자가 마지막 글자였던 것이다)
					그렇다면 원하는 글자를 다 찾은 것이므로
					: 1을 리턴하며 그 값을 캐시에 저장한다.
					*/
	if (wordIndex >= word.size()) {
		return ret = 1;
	}

	/*
	o o o
	o 나o
	o o o
	나(현재위치 y,x)를 기준으로 인접한 좌표 8개 모두를 재귀로 탐색한다.
	그 중에 하나라도 찾게 된다면 성공한 것이므로 OR 연산을 시킨다.
	: 결과적으로 0이나 1이 리턴되며 그 값을 캐시에 저장한다.
	*/
	return ret = (
		canFindWord(y - 1, x - 1, wordIndex) || canFindWord(y - 1, x, wordIndex) || canFindWord(y - 1, x + 1, wordIndex)
		|| canFindWord(y, x - 1, wordIndex) || canFindWord(y, x + 1, wordIndex)
		|| canFindWord(y + 1, x - 1, wordIndex) || canFindWord(y + 1, x, wordIndex) || canFindWord(y + 1, x + 1, wordIndex)
		);
}

int main() {
	/* 테스트 케이스의 수 C */
	int C;
	scanf_s("%d\n", &C);

	for (int i = 0; i < C; i++) {
		/* 게임판 (board[5][5]) 생성 */
		for (int j = 0; j < 5; j++) {
			scanf_s("%c%c%c%c%c\n", &board[j][0], &board[j][1], &board[j][2], &board[j][3], &board[j][4]);
		}

		/* 찾을 단어의 수 N */
		int N;
		scanf_s("%d\n", &N);

		for (int j = 0; j < N; j++) {
			memset(cache, -1, sizeof(cache));    // 단어를 찾는 루프를 돌 때마다 캐시를 -1로 초기화해준다.

												 /* 찾을 단어 word */
			word.clear();
			getline(cin, word);

			bool isFound = false;

			/*
			5X5 상의 모든 점을 대상으로 탐색한다.
			발견시 isFound = true 하며, 이중 break로 완전히 탈출
			*/
			for (int k = 0; k < 5; k++) {
				for (int l = 0; l < 5; l++) {
					if (canFindWord(k, l, 0) == 1) {
						isFound = true;
						break;
					}
				}
				if (isFound) {
					break;
				}
			}

			/* 결과에 따른 출력 */
			if (isFound) {
				cout << word << " YES" << endl;
			}
			else {
				cout << word << " NO" << endl;
			}
		}
	}

	return 0;
>>>>>>> c163b3a9c7fbfa6c637a042e8c9a9274dc6f4f4f
}