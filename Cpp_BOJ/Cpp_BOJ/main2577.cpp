#include <iostream>
using namespace std;

int main() {
	long long a, b, c;
	cin >> a >> b >> c;
	long long mul = a*b*c;
	int num[10] = { 0 };
	while (mul != 0) {
		num[mul % 10]++;
		mul /= 10;
	}
	for (int i = 0; i < 10; i++) {
		cout << num[i] << endl;
	}
}