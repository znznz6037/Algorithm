#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int N, len = 0, num[1001];

class Book {
public:
	string title = "";
	int count = 0;
};

ostream & operator << (ostream& stream, Book book) {
	cout << book.title << endl;
	return stream;
}

Book bookList[1001];


void printBest() {

}

int checkDup(int len, Book book) {
	for (int i = 0; i < len; i++) {
		if (book.title.compare(bookList[i].title) == 0) {
			bookList[i].count++;
			return 1;
		}
	}
	return 0;
}

int compare(Book a, Book b) {
	if (a.count < b.count) return 0;
	else if (a.count > b.count) return 1;
	else {
		int cmp = a.title.compare(b.title);
		if (cmp < 0)return 1;
		else return 0;
	}
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		Book book;
		cin >> book.title;
		if (checkDup(len, book) == 0) {
			bookList[len] = book;
			bookList[len].count++;
			len++;
		}
	}
	sort(bookList, bookList + len, compare);
	cout << bookList[0];
	return 0;
}