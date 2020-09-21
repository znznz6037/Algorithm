#include <iostream>

using namespace std;

long long N, B, C;
long long A[1000001] = { 0, };

long long minSupervisor() {
	long long num = 0;
	for (int i = 1; i <= N; i++) {
		long long eachRoom = A[i];
		long long subSupervisor = eachRoom - B;
		if (subSupervisor <= 0) {
			num++;
			continue;
		}
		num++;
		if (subSupervisor) {
			long long quotient = subSupervisor / C;
			long long remainder = subSupervisor % C;
			if (subSupervisor < C) num++;
			else if (remainder != 0) {
				quotient++;
				num += quotient;
			}
			else {
				num += quotient;
			}
		}
	}
	return num;
}

int main() {
	cin >> N;
	for (int i = 1; i <= N; i++) cin >> A[i];
	cin >> B >> C;

	cout << minSupervisor();

	return 0;
}