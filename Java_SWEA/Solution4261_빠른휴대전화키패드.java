package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution4261_빠른휴대전화키패드 {
	static String str, number;
	static int n, ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			ans = 0;
			number = sc.next();
			n = sc.nextInt();
			for(int i=0;i<n;i++) {
				str = sc.next();
				ans += compare();
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	public static int compare() {
		if(str.length() != number.length()) {
			return 0;
		}
		for(int i=0;i<str.length();i++) {
			char cur = str.charAt(i);
			if(translate(cur) != number.charAt(i)) {
				return 0;
			}
		}
		return 1;
	}
	public static char translate(char c) {
		if(c>='a' && c<='c') {
			return '2';
		}else if(c>='d' && c<='f') {
			return '3';
		}else if(c>='g' && c<='i') {
			return '4';
		}else if(c>='j' && c<='l') {
			return '5';
		}else if(c>='m' && c<='o') {
			return '6';
		}else if(c>='p' && c<='s') {
			return '7';
		}else if(c>='t' && c<='v') {
			return '8';
		}else{
			return '9';
		}
	}
}
