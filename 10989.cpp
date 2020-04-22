#include <iostream>

using namespace std;

int main() {
	int N, n, count = 0, arr[10001] = { 0 };
	scanf_s("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &n);
		arr[n - 1]++;
	}

	for (int i = 0; i < 10000; i++) {
		for (int j = 0; j< arr[i]; j++) {
			count++;
			printf("%d\n", i + 1);
			if (count == N) break;
		}
	}

	return 0;
}