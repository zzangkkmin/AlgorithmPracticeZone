#include <iostream>
#include <string>
using namespace std;

int main() {
	while (true) {
		string s; cin >> s;
		if (s == "0") {
			break;
		}
		int ans = 0;
		while (true) {
			int temp = 0;
			string s_temp = "";
			for (int i = 0; i < s.size(); i++) {
				temp += (s[i] - '0');
			}
			if (temp < 10) {
				ans = temp;
				break;
			}
			while (temp != 0) {
				s_temp = s_temp + (char) ((temp % 10) + '0');
				temp /= 10;
			}
			s = s_temp;
		}
		cout << ans << endl;
	}
}