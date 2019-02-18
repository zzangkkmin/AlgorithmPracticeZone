#include <iostream>
#include <queue>

using namespace std;

int n;//2~20;
int ans = 0;
int s_size = 2;//shark size = 2;
int s_status = 0;//shark status = 0;
int sx, sy;//shark position
int map[20][20];
int visit[20][20];
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,-1,0,1 };
queue<pair<int, int>> q;
priority_queue<pair<int, int>> pq;
bool inrange(int x, int y) {
	if (x >= 0 && x < n&&y >= 0 && y < n) {
		return true;
	}
	else {
		return false;
	}
}
void init() {
	while (!q.empty()) {
		q.pop();
	}
	while (!pq.empty()) {
		pq.pop();
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			visit[i][j] = -1;
		}
	}
}
bool move() {
	bool taste = false;
	init();
	q.push({ sx,sy });
	visit[sx][sy] = 0;
	map[sx][sy] = 0;
	while (!q.empty()) {
		int qsize = q.size();
		for (int i = 0; i < qsize; i++) {
			int cx = q.front().first;
			int cy = q.front().second;
			q.pop();
			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if (inrange(nx, ny) && visit[nx][ny] == -1 && map[nx][ny] <= s_size) {
					visit[nx][ny] = visit[cx][cy] + 1;
					if (map[nx][ny] != 0 && map[nx][ny] < s_size) {
						pq.push({ -nx,-ny });
					}
					q.push({ nx,ny });
				}
			}
		}
		if (pq.size() != 0) {
			taste = true;
			int mx = -pq.top().first;
			int my = -pq.top().second;
			ans += visit[mx][my];
			s_status++;
			if (s_size == s_status) {
				s_size++;
				s_status = 0;
			}
			map[mx][my] = 0;
			sx = mx; sy = my;
			break;
		}
	}

	return taste;
}
int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
			if (map[i][j] == 9) {
				sx = i; sy = j;
			}
		}
	}

	while (move()) {}
	cout << ans << endl;
	return 0;
}
