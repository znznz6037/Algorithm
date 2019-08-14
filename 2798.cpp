<<<<<<< HEAD
//https://jaimemin.tistory.com/856 참고
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int N, M;
	int result = 0;
	int card[100] = { 0 };
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> card[i];
	}
	int pos = 0;
	for (int i = 0; i < N - 2; i++) {
		for (int j =  i + 1; j < N - 1; j++){
			for (int k = j + 1; k < N; k++) {
				if ((card[i] + card[j] + card[k]) > M)continue;
				else {
					result = max(card[i] + card[j] + card[k], result);
				}
			}
		}
	}
	cout << result << endl;
	return 0;
=======
//https://jaimemin.tistory.com/856 참고
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int N, M;
	int result = 0;
	int card[100] = { 0 };
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> card[i];
	}
	int pos = 0;
	for (int i = 0; i < N - 2; i++) {
		for (int j =  i + 1; j < N - 1; j++){
			for (int k = j + 1; k < N; k++) {
				if ((card[i] + card[j] + card[k]) > M)continue;
				else {
					result = max(card[i] + card[j] + card[k], result);
				}
			}
		}
	}
	cout << result << endl;
	return 0;
>>>>>>> c163b3a9c7fbfa6c637a042e8c9a9274dc6f4f4f
}