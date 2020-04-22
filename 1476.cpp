#include <iostream>

int E, S, M = 0;
int year = 1;

/*
int main() {
	scanf_s("%d %d %d", &E, &S, &M);
	while (1) {
		if (E == 1 && S == 1 && M == 1)break;
		else {
			E--, S--, M--;
			year++;
			if (E < 1) E = 15;
			else if (S < 1 )S = 28;
			else if (M < 1 )M = 19;
		}
	}
	printf("%d", year);
	return 0;
}*/

int main() {
	scanf_s("%d %d %d", &E, &S, &M);
	int a = 1;
	int b = 1;
	int c = 1;
	while (!(a == E && b == S && c == M)) {
		if (a > 15)a = 1;
		else if (b > 28)b = 1;
		else if (c > 19)c = 1;
		else {
			a++;
			b++;
			c++;
			year++;
		}
	}
	printf("%d", year);
	return 0;
}