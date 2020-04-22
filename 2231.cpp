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
}