#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace std;

int N, S[21][21] = { 0, };
vector<int> list;

int main() {
	cin >> N;
	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= N; j++)
			cin >> S[i][j];

	vector<int>list;
	for (int i = 1; i <= N / 2; i++)list.push_back(0);
	for (int i = 1; i <= N / 2; i++)list.push_back(1);

	int minResult = INT_MAX;
	do {
		int sSum = 0, eSum = 0;
		vector<int> sTeam, eTeam;
		for (int i = 0; i < N; i++) {
			if (list[i] == 0) sTeam.push_back(i + 1);
			else eTeam.push_back(i + 1);
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N/ 2; j++) {
				if (i == j) continue;
				sSum += S[sTeam[i]][sTeam[j]] + S[sTeam[j]][sTeam[i]];
				eSum += S[eTeam[i]][eTeam[j]] + S[eTeam[j]][eTeam[i]];
			}
		}

		minResult = min(minResult, abs(sSum - eSum));
	} while (next_permutation(list.begin(), list.end()));

	cout << minResult;

	return 0;
}