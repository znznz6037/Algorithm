#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string DNA[1000];
char minHammingDNA[51];
int N, M, min= 10000, result;

char returnChar(int a, int t, int g, int c, int max) {
	if (a == max) return 'A';
	else if (c == max)return 'C';
	else if (g == max) return 'G';
	else if (t == max) return 'T';
	else return 0;
}

int compare() {
	int hammingDistance = 0;
	for (int i = 0; i < M; i++) {
		int a = 0, t = 0, g = 0, c = 0;
		for (int j = 0; j < N; j++) {	 
			switch (DNA[j][i]) {
			case 'A':
				a++; 
				break;
			case 'T': 
				t++; 
				break;
			case 'G': 
				g++; 
				break;
			case 'C': 
				c++;
				break;
			}
		}
		int maxPos = max(a > t ? a : t, g > c ? g : c);
		minHammingDNA[i] = returnChar(a, t, g, c, maxPos);
		hammingDistance += (a + t + g + c - maxPos);
	}
	return hammingDistance;
}

int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> DNA[i];
	}
	int result = compare();
	for (int i = 0; i < M; i++)cout << minHammingDNA[i];
	cout << endl << result;
	return 0;
}