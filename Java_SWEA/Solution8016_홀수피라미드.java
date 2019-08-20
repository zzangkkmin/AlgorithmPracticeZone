package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution8016_홀수피라미드 {
	public static long floor, center, n, k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			center = 1;
			floor = sc.nextLong();
			if(floor == 1) {
				n = k = 1;
			}
			else {
				long floorDiff = floor - center;
				long diff = ((1+floorDiff)*floorDiff / 2 )* 4;
				
				center += diff;
				n = center - 2 * floorDiff;
				k = center + 2 * floorDiff;
			}
			System.out.println("#"+test_case+" "+n+" "+k);
		}
	}

}
