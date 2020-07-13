#include <iostream>
#include <queue>

using namespace std;

int N, idx = 9;
queue<long long> q;
long long arr[1000001] = { 0, };

void checkDescent() {
	while (idx <= N) {
		if (q.empty()) return;
		long long num = q.front();
		q.pop();
		int last = num % 10;
		for (int i = 0; i < last; i++) {
			q.push(num * 10 + i);
			arr[++idx] = num * 10 + i;
		}
	}
}

int main() {
	cin >> N;
	for (int i = 1; i < 10; i++) {
		q.push(i);
		arr[i] = i;
	}
	checkDescent();
	if (!arr[N] && N) cout << -1;
	else cout << arr[N];
	return 0;
}