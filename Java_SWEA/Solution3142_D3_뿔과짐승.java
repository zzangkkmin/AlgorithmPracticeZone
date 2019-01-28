package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution3142_D3_뿔과짐승 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			//2X+Y=n
			//X+Y=m
			//X=n-m
			//Y=2m-n
			System.out.println("#"+t+" "+(n-m)+" "+(2*m-n));
		}
	}

}
