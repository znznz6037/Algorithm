<<<<<<< HEAD
#include <iostream>
#include <string>

using namespace std;

/*
int main(){
	int x, y;
	cin >> x >> y;

	int month_days[12] = { 31,28,31,30,31,30,31,31,30,31,30,31 };
	int total_days = 0;
	for (int i = 1; i < x; i++)total_days += month_days[i-1];
	total_days += y;

	switch (total_days % 7) {
		case 1: printf("MON");
			break;
		case 2: printf("TUE");
			break;
		case 3: printf("WED");
			break;
		case 4: printf("THU");
			break;
		case 5: printf("FRI");
			break;
		case 6: printf("SAT");
			break;
		case 0: printf("SUN");
			break;
		default:
			break;
	}
	return 0;
}
*/

// UNUCIC 8 6 8 2 4 2 36   30 + 6


int main() {
	string arr;
	int a = 0;
	int i;
	cin >> arr;

	for (i = 0; i < arr.length(); i++) {
		if (arr[i] >= 65 && arr[i] <= 67)
			a += 3;
		else if (arr[i] >= 68 && arr[i] <= 70)
			a += 4;
		else if (arr[i] >= 71 && arr[i] <= 73)
			a += 5;
		else if (arr[i] >= 74 && arr[i] <= 76)
			a += 6;
		else if (arr[i] >= 77 && arr[i] <= 79)
			a += 7;
		else if (arr[i] >= 80 && arr[i] <= 83)
			a += 8;
		else if (arr[i] >= 84 && arr[i] <= 86)
			a += 9;
		else if (arr[i] >= 87 && arr[i] <= 90)
			a += 10;
		else if (arr[i] == 0)
			a += 11;
		else if (arr[i] == 1)
			a += 2;
	}
	cout << a;

	return 0;
=======
#include <iostream>
#include <string>

using namespace std;

/*
int main(){
	int x, y;
	cin >> x >> y;

	int month_days[12] = { 31,28,31,30,31,30,31,31,30,31,30,31 };
	int total_days = 0;
	for (int i = 1; i < x; i++)total_days += month_days[i-1];
	total_days += y;

	switch (total_days % 7) {
		case 1: printf("MON");
			break;
		case 2: printf("TUE");
			break;
		case 3: printf("WED");
			break;
		case 4: printf("THU");
			break;
		case 5: printf("FRI");
			break;
		case 6: printf("SAT");
			break;
		case 0: printf("SUN");
			break;
		default:
			break;
	}
	return 0;
}
*/

// UNUCIC 8 6 8 2 4 2 36   30 + 6


int main() {
	string arr;
	int a = 0;
	int i;
	cin >> arr;

	for (i = 0; i < arr.length(); i++) {
		if (arr[i] >= 65 && arr[i] <= 67)
			a += 3;
		else if (arr[i] >= 68 && arr[i] <= 70)
			a += 4;
		else if (arr[i] >= 71 && arr[i] <= 73)
			a += 5;
		else if (arr[i] >= 74 && arr[i] <= 76)
			a += 6;
		else if (arr[i] >= 77 && arr[i] <= 79)
			a += 7;
		else if (arr[i] >= 80 && arr[i] <= 83)
			a += 8;
		else if (arr[i] >= 84 && arr[i] <= 86)
			a += 9;
		else if (arr[i] >= 87 && arr[i] <= 90)
			a += 10;
		else if (arr[i] == 0)
			a += 11;
		else if (arr[i] == 1)
			a += 2;
	}
	cout << a;

	return 0;
>>>>>>> c163b3a9c7fbfa6c637a042e8c9a9274dc6f4f4f
}