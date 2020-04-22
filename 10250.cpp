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
}