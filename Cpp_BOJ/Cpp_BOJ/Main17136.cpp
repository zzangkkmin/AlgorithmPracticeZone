#include <iostream>
using namespace std;

int map[10][10];
int tmap[10][10];
int paper[6];
int ans = 26;
int onearr[100];
int idx = 0;
bool is_paper_in(int x, int y, int size) {
	if (x > 10 - size || y > 10 - size) {
		return false;
	}
	for (int i = x; i < x + size; i++) {
		for (int j = y; j < y + size; j++) {
			if (map[i][j] == 0 || tmap[i][j] == 1)
				return false;
		}
	}
	return true;
}
void paper_chk_in(int x, int y, int size) {
	for (int i = x; i < x + size; i++) {
		for (int j = y; j < y + size; j++) {
			tmap[i][j] = 1;
		}
	}
}
void paper_chk_out(int x, int y, int size) {
	for (int i = x; i < x + size; i++) {
		for (int j = y; j < y + size; j++) {
			tmap[i][j] = 0;
		}
	}
}
void find_paper(int nth, int one, int two, int three, int four, int five) {
	if (one > 5 || two > 5 || three > 5 || four > 5 || five > 5) {
		return;
	}
	if (one + two + three + four + five > ans) {
		return;
	}
	if (nth == idx) {
		int temp = one + two + three + four + five;
		ans = ans > temp ? temp : ans;
		return;
	}
	int x = onearr[nth] / 10;
	int y = onearr[nth] % 10;
	if (tmap[x][y] == 1) {
		find_paper(nth + 1, one, two, three, four, five);
		return;
	}
	for (int s = 5; s >= 1; s--) {
		if (is_paper_in(x, y, s)) {
			paper_chk_in(x, y, s);
			if (s == 5) {
				find_paper(nth + 1, one, two, three, four, five + 1);
			}
			else if (s == 4) {
				find_paper(nth + 1, one, two, three, four + 1, five);
			}
			else if (s == 3) {
				find_paper(nth + 1, one, two, three + 1, four, five);
			}
			else if (s == 2) {
				find_paper(nth + 1, one, two + 1, three, four, five);
			}
			else if (s == 1) {
				find_paper(nth + 1, one + 1, two, three, four, five);
			}
			paper_chk_out(x, y, s);
		}
	}
}
int main() {
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) {
				onearr[idx++] = i * 10 + j;
			}
		}
	}
	find_paper(0, 0, 0, 0, 0, 0);
	if (ans == 26) {
		cout << -1 << endl;
	}
	else {
		cout << ans << endl;
	}
	return 0;
}


