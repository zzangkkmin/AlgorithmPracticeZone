package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6959_D4_이상한나라의덧셈게임 {
	public static String numStr;
	public static int sum, index;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			numStr = br.readLine().trim();
			sum = 0; index = 0;
			for(int i=0;i<numStr.length();i++) {
				sum += (numStr.charAt(i) - '0');
				index++;
				if(sum > 9) {
					sum = sum % 9;
					index++;
				}
			}
			if(index % 2 == 1) {
				System.out.println("#"+t+" B");
			}
			else {
				System.out.println("#"+t+" A");
			}
		}
	}

}
