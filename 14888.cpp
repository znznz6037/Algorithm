#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

int N, num[12] = { 0, };
int add, sub, multiply, divide;
vector<int>op;

void op_list() {
	int idx = 0;
	for (idx = 0; idx < add; idx++) op.push_back(0);
	for (idx = 0; idx < sub; idx++) op.push_back(1);
	for (idx = 0; idx < multiply; idx++) op.push_back(2);
	for (idx = 0; idx < divide; idx++) op.push_back(3);
}
 
int main() {
	cin >> N;
	for (int i = 0; i < N; i++) cin >> num[i];
	cin >> add >> sub >> multiply >> divide;
	op_list();
	int minSum = INT_MAX, maxSum = INT_MIN;

	do {
		int sum = num[0];
		for (int i = 0; i < N - 1; i++) {
			if (op[i] == 0) sum += num[i + 1];
			if (op[i] == 1) sum -= num[i + 1];
			if (op[i] == 2) sum *= num[i + 1];
			if (op[i] == 3) {
				if (num[i] < 0) {
					sum *= -1;
					sum /= num[i + 1];
					sum *= -1;
				}
				else sum /= num[i + 1];
			}
		}
		minSum = min(minSum, sum), maxSum = max(maxSum, sum);

	} while (next_permutation(op.begin(), op.end()));

	cout << maxSum << endl << minSum;

	return 0;
}