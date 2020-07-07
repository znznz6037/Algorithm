#include <iostream>

using namespace std;

int N, K, L;

int tournament(int k, int l) {
	int min = 0;
	while (k != l) {
		k = k / 2 + k % 2;
		l = l / 2 + l % 2;
		min++;
	}
	return min;
}

int main() {
	cin >> N >> K >> L;
	cout << tournament(K, L);
	return 0;
}