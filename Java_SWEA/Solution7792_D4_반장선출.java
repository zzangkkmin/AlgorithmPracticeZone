package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution7792_D4_반장선출 {
	static int tc, n;
	static String save;
	static int abcDiv;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			for(int i=0;i<=n;i++) {
				String str = sc.nextLine();
				if(i==0) { 
					continue;
				}
				else if(i==1) {
					abcDiv = abcDivCount(str);
					save = str;
				}
				else {
					int tempABC = abcDivCount(str);
					if(abcDiv < tempABC) {
						abcDiv = tempABC;
						save = str;
					}
					else if(abcDiv == tempABC) {
						if(save.compareTo(str) > 0)
							save = str;
					}
				}
			}
			System.out.println(save);
		}
	}
	public static int abcDivCount(String str) {
		char[] abcStr = str.toCharArray();
		int[] alphabet = new int[26];
		int abcCount = 0;
		for(char abc : abcStr) {
			if(abc == ' ') continue;
			if(alphabet[abc-'A'] == 0) {
				abcCount++;
				alphabet[abc-'A'] = 1;
			}
		}
		return abcCount;
	}
}
