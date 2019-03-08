package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main16923 {
	public static String S;
	public static boolean[] abc = new boolean[26];
	public static boolean[] minusABC = new boolean[26];
	public static int pointer;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine().trim(); 
		Arrays.fill(minusABC, true);
		for(int i=0;i<S.length();i++) {
			abc[S.charAt(i) - 'a'] = true;
			minusABC[S.charAt(i) - 'a'] = false;
		}
		find(0);
	}
	public static void find(int point) {
		for(int i = point; i < 26; i++) {
			if(abc[i] == false) {
				System.out.println(S + ((char) ('a'+i)));
				return;
			}
		}
		int start = S.charAt(S.length() - 1) - 'a';
		abc[start] = false;
		if(start - 1 < 0) {
			System.out.println(-1);
			return;
		}
		S = S.substring(0, start - 1);
		find(start);
		
	}
}
