#include <iostream>
using namespace std;

int arr[300] = { 0 };

int main() {
	int num , x, score = 0;
	int limit = 0;

	int i = 0;
	cin >> num;
	for(int a = 0; a < num; a++){
		cin >> x;
		arr[a] = x;
	}
	while (i < num) {
		if (i == 0) {
			score += arr[i];
			//printf("|%d|\n", arr[i]);
			i += 1;
		}
		else if (i == num - 3) {
			score += arr[i+2];
			//printf("|%d|\n", arr[i+2]);
			break;
		}
		else if (limit == 1) {
			i += 1;
			score += arr[i];
			//printf("|%d|\n", arr[i]);
			limit = 0;
		}
		else {
			score += arr[i];
			//printf("|%d|\n", arr[i]);
			limit++;
			i += 1;
		}
	}
	printf("%d", score);
	return 0;
}