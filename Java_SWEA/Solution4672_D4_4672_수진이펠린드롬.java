package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution4672_D4_4672_수진이펠린드롬 {
	static String str;
	static int[] combiNum;
	static int[] abc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		setting();
		for(int t=1;t<=tc;t++) {
			int ans = 0;
			str = sc.next();
			abc = new int[26];
			for(int i=0;i<str.length();i++) {
				abc[str.charAt(i)-'a']++;
			}
			for(int i=0;i<26;i++) {
				ans += combiNum[abc[i]];
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	public static void setting() {
		combiNum = new int[11];
		for(int i=1;i<=10;i++) {
			combiNum[i] = combiNum[i-1] + i;
		}
	}
}
