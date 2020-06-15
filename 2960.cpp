#include <iostream>

using namespace std;

int N, K, arr[1001] = { 0, };

int eratos(int count) {
	int idx = 0, min = 0;
	while (1) {
		for (int i = 2; i <= N; i++) {
			if (arr[i] == 2 || arr[i] == 3) {
				min = arr[i];
				break;
			}
			if (arr[i] != 0 && arr[i] % 2 != 0 && arr[i] % 3 != 0) {// 2
				min = arr[i];
				break;
			}
		}
		for (int i = min; i <= N; i = i + min) { //3
			if (arr[i] != 0) idx++;
			if (idx == count) return arr[i];
			arr[i] = 0;
		}
	}
}

int main() {
	cin >> N >> K;
	for (int i = 2; i <= N; i++) arr[i] = i;
	cout << eratos(K);
	return 0;
}