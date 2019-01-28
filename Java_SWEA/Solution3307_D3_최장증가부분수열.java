package com.ssafy.git.Java_SWEA;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution3307_D3_최장증가부분수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int Ans = 0;
			int N = sc.nextInt();
			int[] a = new int[N + 1];
			int[] d = new int[N + 1];
			int[] b = new int[N + 1];
			for(int i=1;i<=N;i++) {
				a[i] = sc.nextInt();
			}
			//int cur = 0; 
			int cIdx = 0;
			for(int i=1;i<=N;i++) {
//				//O(n^2)
//				if(cur > a[i]) {
//					int maxD = 0;
//					for(int j=0;j<i;j++) {
//						if(a[i] > a[j])
//							maxD = d[j] < maxD ? maxD : d[j];
//					}
//					d[i] = maxD + 1;
//				}
//				else {
//					int maxD = 0;
//					for(int j=0;j<i;j++) {
//						maxD = d[j] < maxD ? maxD : d[j];
//					}
//					d[i] = maxD + 1;
//					cur = a[i];
//				}
				//O(nlogn)
				if(b[cIdx] < a[i]) {
					b[cIdx + 1] = a[i];
					d[cIdx + 1] = d[cIdx] + 1;
					cIdx++;
				}
				else {
					int left = 0; int right = cIdx;
					while(left <= right) {
						int mid = (left + right) / 2;
						if(b[mid] < a[i]) {
							left = mid + 1;
						}
						else {
							right = mid - 1;
						}
					}
					b[left] = a[i];
				}
			}
			Ans = d[cIdx];
			System.out.println("#" + test_case + " " + Ans);
		}
	}

}
