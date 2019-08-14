<<<<<<< HEAD
#include <iostream>

using namespace std;

int main() {
	int n = 0;
	cin >> n;
	int an = n, x, y, cycle = 0;
	do{
		x = an / 10;
		y = an % 10;
		an = (y)*10 +((x + y) % 10);
		cycle++;
	} while (n != an);

	cout << cycle << endl;
	return 0;
=======
#include <iostream>

using namespace std;

int main() {
	int n = 0;
	cin >> n;
	int an = n, x, y, cycle = 0;
	do{
		x = an / 10;
		y = an % 10;
		an = (y)*10 +((x + y) % 10);
		cycle++;
	} while (n != an);

	cout << cycle << endl;
	return 0;
>>>>>>> c163b3a9c7fbfa6c637a042e8c9a9274dc6f4f4f
}