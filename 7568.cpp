#include <iostream>

using namespace std;

int N;
int arr[50][2] = { 0 };
int score[50] = { 0 };

int main() {
	memset(&arr, 0, sizeof(arr)*2);
	for (int i = 0; i < 50; i++) {
		score[i] = 1;
	}

	cin >> N;
	for(int i = 0; i< N; i++){
		cin >> arr[i][0] >> arr[i][1];
	}
	
	for (int i = 0; i <= N - 1; i++) {
		for (int j = i + 1; j <= N; j++) {
			if ((arr[i][0] > arr[j][0]) && (arr[i][1] > arr[j][1])) score[j] += 1;
			else if ((arr[i][0] < arr[j][0]) && (arr[i][1] < arr[j][1])) score[i]+= 1;
			else continue;
		}
	}

	for (int i = 0; i < N; i++) {
		cout << score[i] << endl;
	}
	return 0;
}