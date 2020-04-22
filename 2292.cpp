#include <iostream>

using namespace std;

int main() {
	int n = 1, num = 1;
	int obj = 0;
	cin >> obj;
	while (obj > num) {
		num += 6 * (n++);
	}
	cout << n << endl;
	return 0;
}