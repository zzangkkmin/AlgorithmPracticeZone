package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution1491 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int t=1;t<=test_case;t++){
			int Ans = 0;
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			int r = (int)Math.sqrt(n);
			Ans = b*(n - r*r);
			System.out.println("#" + t + " "  + Ans);
		}
	}

}
