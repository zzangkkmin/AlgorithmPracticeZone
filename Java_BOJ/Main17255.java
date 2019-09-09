package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17255 {
	static String N;
	static int ans = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		
		splitString(N);
		System.out.println(ans);
	}
	public static void splitString(String X) {
		if(sameString(X)) {
			ans++;
			return;
		}
		String frontAppend = X.substring(1);
		String backAppend = X.substring(0, X.length()-1);
		splitString(frontAppend);
		splitString(backAppend);
	}
	public static boolean sameString(String X) {
		char str[] = X.toCharArray();
		char flag = str[0];
		for(int i=1;i<str.length;i++) {
			if(flag != str[i]) {
				return false;
			}
		}
		return true;
	}
}
