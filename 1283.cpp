#include <iostream>
#include <cstring>
#include "stdio.h"

using namespace std;

int N;

string arr[31];
char shortcut[27] = { 0, };
int space[6] = { 0, };

int index(string str, int n) {
	return tolower(str[n]) - 96;
}

int allocShortcut(string str) {
	int len = str.length(), i = 0, idx = 0, spaceNum = 0;
	while (i != len) {
		idx = index(str, i);
		if (str[i] == ' ' && idx) space[spaceNum++] = i + 1;
		i++;
	}
	i = 0, idx = index(str, 0);
	if (!shortcut[idx]) {
		shortcut[idx] = 1;
		return i;
	}
	for (int a = 0; a < spaceNum; a++) {
		idx = index(str, space[a]);
		if (!shortcut[idx] && idx) {
			shortcut[idx] = 1;
			return space[a];
		}
	}
	i = 1;
	while (i != len) {
		idx = index(str, i);
		if (str[i] == '\n') return 100;
		if (str[i] != ' ' && !shortcut[idx] && idx) {
			shortcut[idx] = 1;
			return i;
		}
		i++;
	}
	memset(space, 0, sizeof(space));
	return 100;
}

int main() {
	char buffer[100];
	cin >> N;

	for (int i = 0; i <= N; i++) {
		memset(buffer, 0, sizeof(buffer));
		if(fgets(buffer, sizeof(buffer), stdin) != NULL)
			arr[i] = buffer;
	}
	for (int i = 1; i <= N; i++) {
		int idx = allocShortcut(arr[i]);
		for (int j = 0; j < arr[i].length(); j++) {
			if (idx == j) cout << '[';
			if(arr[i][j] != '\n')cout << arr[i][j];
			if (idx == j) cout << ']';
		}
		if (i != N) cout << endl;
	}
	return 0;
}
//aaaaaaaaaa bbbbbbbbbb cccccccccc dddddddddd eeeeeeeeee 