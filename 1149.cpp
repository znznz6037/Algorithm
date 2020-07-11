#include <iostream>
#include <algorithm>

using namespace std;

int rgb[1001][3], dp[1001][3], N;

int minDist() {
	int ans = 10000000;
	for (int i = 1; i < N; i++) {
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
	}
	for (int i = 0; i < 3; i++) if (dp[N - 1][i] < ans) ans = dp[N - 1][i];
	return ans;
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> rgb[i][j];
		}
	}
	dp[0][0] = rgb[0][0];
	dp[0][1] = rgb[0][1];
	dp[0][2] = rgb[0][2];

	cout << minDist();

	return 0;
}