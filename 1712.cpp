<<<<<<< HEAD
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
=======
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
>>>>>>> c163b3a9c7fbfa6c637a042e8c9a9274dc6f4f4f
}