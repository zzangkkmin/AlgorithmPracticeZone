package com.ssafy.git.Java_BOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2407 {
	public static BigInteger[][] d = new BigInteger[101][101];
	//public static long[][] d = new long[101][101];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		d[1][0] = d[1][1] = new BigInteger("1");
		
		for(int i = 2;i <= n;i++) {
			for(int j = 0; j<=i;j++) {
				if(i==j||j==0) {
					d[i][j] = new BigInteger("1");
				}
				else {
					d[i][j] = d[i-1][j-1].add(d[i-1][j]);
				}
			}
		}
		System.out.println(d[n][m]);
	}
}
