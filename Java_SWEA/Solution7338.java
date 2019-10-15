package com.ssafy.git.Java_SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution7338 {
	public static long y = 2016;
	public static long m = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			long a,b;
			a = sc.nextLong();
			b = sc.nextLong();
			long YY = a - y;
			long MM = b - m;
			long totalM = YY * 12 + MM;
			long y13 = totalM / 13;
			long m13 = totalM % 13;
			YY = y + y13;
			MM = m + m13;
			System.out.println("#"+test_case+" "+YY+" "+MM);
		}
		
	}

}
