<<<<<<< HEAD
#include <iostream>
#include <string.h>
#include <stdio.h>

using namespace std;

char str[101] = {};
int pos[26] = { };
int main() {
	cin >> str;
	memset(pos, -1, sizeof(pos));
	for (int i = 0; i < strlen(str); i++) {
		if (pos[str[i] - 97] > -1)continue;
		pos[str[i] - 97] = i;
	}
	for (int i = 0; i < 26; i++) {
		cout << pos[i] << " ";
	}
	return 0;
=======
#include <iostream>
#include <string.h>
#include <stdio.h>

using namespace std;

char str[101] = {};
int pos[26] = { };
int main() {
	cin >> str;
	memset(pos, -1, sizeof(pos));
	for (int i = 0; i < strlen(str); i++) {
		if (pos[str[i] - 97] > -1)continue;
		pos[str[i] - 97] = i;
	}
	for (int i = 0; i < 26; i++) {
		cout << pos[i] << " ";
	}
	return 0;
>>>>>>> c163b3a9c7fbfa6c637a042e8c9a9274dc6f4f4f
}