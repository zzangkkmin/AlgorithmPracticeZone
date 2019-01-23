package com.ssafy.swe;

import java.util.Scanner;

public class Solution3233_D3_정삼각형분할 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int T = 1 ; T <= tc ; T++) {
			long A = sc.nextLong();
			long B = sc.nextLong();
			System.out.println("#"+T+" "+(A/B)*(A/B));
		}
	}

}
