#include <iostream>
#include <algorithm>

using namespace std;

int N, T[17] = { 0, }, P[17] = { 0, }, money[17] = { 0, };

int main() {
	cin >> N;
	for (int i = 1; i <= N; i++) cin >> T[i] >> P[i];

	int maxProfit = 0;
	for (int i = 1; i <= N + 1; i++) {
		for (int j = 1; j < i; j++) {
			money[i] = max(money[i], money[j]);
			if (j + T[j] == i) money[i] = max(money[i], money[j] + P[j]);
		}
		maxProfit = max(maxProfit, money[i]);
	}
	cout << maxProfit << endl;
	return 0;
}