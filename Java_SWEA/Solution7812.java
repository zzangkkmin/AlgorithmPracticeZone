package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution7812 {
	public static int n,m;
	public static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			arr = new int[n+1]; arr[0] = 0;
			for(int i=0;i<n;i++) {
				int t = sc.nextInt();
				arr[i+1] = arr[i] + t;
			}
			int p1 = 0; int p2 = 0;
			int ans = 0;
			while(p1!=n || p2!=n) {
				int a = arr[p1];
				int b = arr[p2];
				if(b-a == m) {
					ans++;
				}
				if(p1==p2) {
					p2++;
				}
				else if(b-a > m) {
					p1++;
				}
				else {
					if(p2 == n) {
						p1++;
					}
					else {
						p2++;
					}
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}

	/*
	 * 0 1 1 1 1 1
	 * =
	 * 0 1 2 3 4 5
	 * 
	 * 0 1 3 2 5 4 6 2 1 3 2
	 * =
	 * 0 1 4 6 11 15 21 23 24 27 29
	 */
}
