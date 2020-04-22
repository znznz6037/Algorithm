#include <iostream>
using namespace std;

int main() {
	int N = 0;
	int num = 0;
	cin >> N;
	while (N) {
		if (N % 5 == 0) {
			N -= 5;
			num++;
		}
		else if (N % 3 == 0) {
			N -= 3;
			num++;
		}
		else if (N > 5) {
			N -= 5;
			num++;
		}
		else {
			num = -1;
			break;
		}
	}
	printf("%d", num);
	return 0;
}

/*
int main() {
	int N = 0;
	int num = 0;
	cin >> N;
	for (int i = 0; i<1667; i++) {
		for (int j = 0; j<1000; j++) {
			if (3 * i + 5 * j == N) {
				cout << i + j << endl;
				num++;
			}
			if (num == 1)break;
		}
		if (num == 1)break;
	}
	if (num == 0) {
		cout << "-1" << endl;
	}
	return 0;
}*/