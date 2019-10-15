package com.ssafy.git.TestExam;

import java.util.Scanner;

public class Line04 {
	static int n,m;
	static int x,y;
	static long[][] d = new long[25][25];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		combi();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		if(x > n || y > m) {
			System.out.println("fail");
		} else {
			//min-time
			System.out.println(x+y);
			//route
			System.out.println(d[x+y][x]);
		}
	}
	public static void combi() {
		d[0][0] = 1;
		for(int i=1;i<=24;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) {
					d[i][j] = 1;
				} else if(j==i) {
					d[i][j] = 1;
				} else {
					d[i][j] = d[i-1][j-1] + d[i-1][j];
				}
			}
		}
	}
}
