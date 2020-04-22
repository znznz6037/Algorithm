#include <iostream>

using namespace std;

int main() {
	int A, B, C;
	cin >> A >> B >> C;
	if (B >= C) {
		cout << -1 << endl;
		return 0;
	}
	int x = (A / (C-B)) + 1 ;
	cout << x << endl;
	return 0;
}