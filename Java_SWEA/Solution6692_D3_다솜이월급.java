package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution6692_D3_다솜이월급 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			double sum = 0;
			for(int i=0;i<N;i++) {
				double p = sc.nextDouble();
				int value = sc.nextInt();
				sum += p*value;
			}
			System.out.printf("#%d %.6f",test_case,sum);
		}
	}

}
