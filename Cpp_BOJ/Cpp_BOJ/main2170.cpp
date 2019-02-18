#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n; cin >> n;
	vector <pair<int, int>> v;
	for (int i = 0; i < n; i++) {
		int x, y;
		scanf("%d %d",&x,&y);
		if (x > y) {
			int temp = y;
			y = x;
			x = temp;
		}
		v.push_back({ x,y });
	}
	sort(v.begin(), v.end());

	int start = v[0].first;
	int end = v[0].second;
	int len = end - start;
	int idx = 1;
	while (idx < n) {
		if (start <= v[idx].first && v[idx].first <= end && end <= v[idx].second) {
			len += (v[idx].second - end);
			end = v[idx].second;
			idx++;
		}
		else if(end < v[idx].first){
			start = v[idx].first;
			end = v[idx].second;
			len += (end - start);
			idx++;
		}
		else {
			idx++;
		}
	}
	cout << len << endl;
	return 0;
}