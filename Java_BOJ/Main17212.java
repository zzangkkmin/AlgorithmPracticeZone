package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17212 {
	static int[][] d;
	static int[] cost;
	static final int INF = 100001;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[4][n+1];
		cost = new int[n+1];
		for(int i=0;i<=n;i++) {
			
			if(i<1) {
				d[0][i] = INF;
			} else if(i==1) {
				d[0][i] = 1;
			} else {
				d[0][i] = 1 + d[0][i-1];
			}
			
			if(i<2) {
				d[1][i] = INF;
			} else if(i==2) {
				d[1][i] = 1;
			} else {
				int min = INF;
				for(int j = 1; j>=0 ; j--) {
					min = min > d[j][i-2] ? d[j][i-2] : min;
				}
				d[1][i] = 1 + min;
			}
			
			if(i<5) {
				d[2][i] = INF;
			} else if(i==5) {
				d[2][i] = 1;
			} else {
				int min = INF;
				for(int j = 2; j>=0 ; j--) {
					min = min > d[j][i-5] ? d[j][i-5] : min;
				}
				d[2][i] = 1 + min;
			}
			
			if(i<7) {
				d[3][i] = INF;
			} else if(i==7) {
				d[3][i] = 1;
			} else {
				int min = INF;
				for(int j = 3; j>=0 ; j--) {
					min = min > d[j][i-7] ? d[j][i-7] : min;
				}
				d[3][i] = 1 + min;
			}
			
			int min = INF;
			for(int j=3;j>=0;j--) {
				min = min > d[j][i] ? d[j][i] : min;
			}
			if(min == INF)
				min = 0;
			cost[i] = min;
		}
		System.out.println(cost[n]);
	}

}
