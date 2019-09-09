package com.ssafy.git.Java_BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main15649 {
	static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[] select = new int[n];
		int[] num = new int[n];
		int[] ans = new int[m];
		for(int i=0;i<n;i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		solve(select,ans,num,0,0);
	}
	public static void solve(int[] select, int[] ans, int[] num, int idx, int cnt) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		if(idx==n) {
			return;
		}
		for(int i=0;i<n;i++) {
			select[i] = 1;
			ans[cnt] = num[i];
			solve(select,ans,num,i+1,cnt+1);
			ans[cnt] = 0;
			select[i] = 0;
		}
	}
}
