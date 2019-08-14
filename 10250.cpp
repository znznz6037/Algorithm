<<<<<<< HEAD
#include <iostream>

using namespace std;

int main() {
	int T;
	cin >> T;
	int H, W, N, floor, weight;
	while (T--) {
		cin >> H >> W >> N;
		floor = N % H;
		if (floor == 0) floor = H;
		weight = N / H;
		if ( (N % H) != 0)weight++;
		cout << (floor * 100) + weight << endl;
	}
	return 0;
=======
#include <iostream>

using namespace std;

int main() {
	int T;
	cin >> T;
	int H, W, N, floor, weight;
	while (T--) {
		cin >> H >> W >> N;
		floor = N % H;
		if (floor == 0) floor = H;
		weight = N / H;
		if ( (N % H) != 0)weight++;
		cout << (floor * 100) + weight << endl;
	}
	return 0;
>>>>>>> c163b3a9c7fbfa6c637a042e8c9a9274dc6f4f4f
}