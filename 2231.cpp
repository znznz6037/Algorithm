<<<<<<< HEAD
#include <stdio.h>

int n, i, j, cnt, sum;

int main() {
	scanf("%d", &n);
	i = n;
	while (i) i /= 10, cnt++;
	for (i = n - 9 * cnt; i < n; i++) {
		sum = i;
		for (j = i; j; j /= 10) sum += j % 10;
		if (sum == n) break;
	}
	printf("%d", i != n ? i : 0);
	return 0;
=======
#include <iostream>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int N;
	cin >> N;
	int org = N, len = N, i = 0;
	while (len > 0) {
		i++;
		len = len / 10;
	}

	int sum = 0;
	int min = 9 * i;
	N -= min;
	while (N + sum != org) {
		sum = 0;
		int x = i;
		int origin = N;
		while (--x) {
			sum += origin / 10 ^ (x);
			origin %= 10 ^ x;
			if (x == 0) sum += origin;
		}
		if (sum + N > org)continue;
		N++;
	}
	cout << N << endl;

	return 0;
>>>>>>> c163b3a9c7fbfa6c637a042e8c9a9274dc6f4f4f
}