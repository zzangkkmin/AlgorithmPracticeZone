package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17252 {
	static int n;
	static int[] threeN;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		threeSetting();
		threeSearch(n);
	}
	public static void threeSetting() {
		threeN = new int[20];
		for(int i=19;i>=0;i--) {
			int t = 1;
			for(int j=0;j<i;j++) {
				t *= 3;
			}
			threeN[i] = t;
		}
	}
	public static void threeSearch(int n) {
		int num = n;
		if(n==0) {
			System.out.println("NO");
			return;
		}
		for(int i=19;i>=0;i--) {
			if(num>=threeN[i]) {
				num -= threeN[i];
			}
		}
		if(num == 0) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
