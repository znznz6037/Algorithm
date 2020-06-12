#include <iostream>
#include <cstring>
using namespace std;

int T, N, M;
int prob[31][31];

void init() {
	for (int i = 1; i <= M; i++) prob[1][i] = i;
}

int cal() {
	for (int i = 2; i <= N; i++) {
		for (int j = i; j <= M; j++) {
			for (int k = j; k >= i; k--) {
				prob[i][j] = prob[i][j] + prob[i - 1][k - 1];
			}
		}
	}
	return prob[N][M];
}

int main() {
	cin >> T;
	for (int i = 0; i < T; i++) {
		memset(prob, 0, sizeof(prob));
		cin >> N >> M;
		init();
		cout << cal() << endl;
	}
	return 0;
}