package com.ssafy.git.TestB;

import java.util.Scanner;

//4038. [Professional] 단어가 등장하는 횟수
public class SolutionB04 {
	static String p,k;
	static int[] arr, kArr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			p = sc.next();
			k = sc.next();
			int[] Ki = getKi(k);
			int ans = kmp(p,k,Ki);
			System.out.println("#"+test_case+" "+ans);
		}
	}
	static int[] getKi(String patt) {
		int pattLen = patt.length();
		int j = 0;
		int[] Ki = new int[pattLen];
		for(int i=1;i<pattLen;i++) {
			while(j>0 && patt.charAt(i) != patt.charAt(j)) {
				j = Ki[j-1];
			}
			if(patt.charAt(i) == patt.charAt(j)) {
				Ki[i] = ++j;
			}
		}
		return Ki;
	}
	static int kmp(String str, String patt, int[] Ki) {
		int ans = 0;
		int strLen = str.length();
		int pattLen = patt.length();
		int j=0;
		for(int i=0;i<strLen;i++) {
			while(j>0 && str.charAt(i) != patt.charAt(j)) {
				j = Ki[j-1];
			}
			if(str.charAt(i) == patt.charAt(j)) {
				if(j==pattLen - 1) {
					ans++;
					j = Ki[j];
				}else {
					j++;
				}
			}
		}
		return ans;
	}
}
