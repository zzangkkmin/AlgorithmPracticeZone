package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3143_D4_가장빠른_문자타이핑 {
	public static String[] line;
	public static String A,B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			int ans = 0;
			line = br.readLine().trim().split(" ");
			A = line[0]; B = line[1];
			A = A.replaceAll(B, "?");
			ans = A.length();
			System.out.println("#"+t+" "+ans);
		}
	}
}
