#include <iostream>

using namespace std;

int num = 0;

int number(int k, int n) {
	if (k == 0) {
		num += n;
		return num;
	}
	for (int i = 1; i <= n; i++) {
		number(k - 1, i);
	}
}

int main() {
	int T, k, n;
	cin >> T;
	while (T--) {
		cin >> k >> n;
		number(k, n);
		cout << num << endl;
		num = 0;
	}
	return 0;
}