#include <iostream>
#include <math.h>
using namespace std;

int arr[501];
int sum[501];
int n; int k;
double ans = 10000000000.0;
int main() {
	cin >> n >> k;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		sum[i] = sum[i - 1] + arr[i];
	}
	while (k <= n) {
		for (int i = k; i <= n; i++) {
			double m = (double)(sum[i] - sum[i - k]) / (double)k;
			double temp = 0;
			for (int j = i - k + 1; j <= i; j++) {
				temp += (arr[j] - m) * (arr[j] - m);
			}
			double res = sqrt(temp / (double)k);
			if (ans == -1 || ans > res) {
				ans = res;
			}
		}
		k++;
	}
	printf("%.11f\n", ans);
	return 0;
}