package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution3750_D3_DigitSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
			String n = sc.next();//1 ~ 10^18
			int size = n.length();
			while(size != 1) {
				int sum = 0;
				for(int i=0;i<size;i++) {
					sum += (n.charAt(i) - '0');
				}
				n = "" + sum;
				size = n.length();
			}
			System.out.println("#"+test_case+" "+n);
		}
	}

}
