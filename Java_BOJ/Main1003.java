package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1003 {
	public static int[][] d = new int[41][2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		fibo01();
		for(int i=0;i<n;i++) {
			int in = Integer.parseInt(br.readLine().trim());
			System.out.println(d[in][0] + " " + d[in][1]);
		}
	}
	public static void fibo01() {
		d[0][0] = 1; d[0][1] = 0;
		d[1][0] = 0; d[1][1] = 1;
		for(int i=2;i<=40;i++) {
			d[i][0] = d[i-1][0] + d[i-2][0];
			d[i][1] = d[i-1][1] + d[i-2][1];
		}
	}
}
