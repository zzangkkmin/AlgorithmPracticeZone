package com.ssafy.git.Java_SWEA;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution5162_D3_두가지빵딜레마 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int Ans = 0;
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int max = C/A < C/B ? C/B : C/A;
			max = max < C / (A+B) ? C / (A+B) : max;
			System.out.println("#" + test_case + " " + max);
		}
	}

}
