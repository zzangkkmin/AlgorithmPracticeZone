package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main5397_1 {
	static int tc;
	final static int SIZE = 1000001;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			String str = sc.next();
			solve(str);
		}
	}
	public static void solve(String str) {
		int idxA = 0; int idxB = 0;
		char[] tempA = new char[SIZE];
		char[] tempB = new char[SIZE];
		char[] input = str.toCharArray();
		for( char c : input) {
			if(c=='<') {
				if(idxA - 1 < 0)
					continue;
				char data = tempA[--idxA];
				tempA[idxA] = 0;
				tempB[idxB++] = data;
			}
			else if(c=='>') {
				if(idxB - 1 < 0)
					continue;
				char data = tempB[--idxB];
				tempB[idxB] = 0;
				tempA[idxA++] = data;
			}
			else if(c=='-') {
				if(idxA - 1 < 0)
					continue;
				tempA[--idxA] = 0;
			}
			else {
				tempA[idxA++] = c;
			}
		}
		for(int i = 0; i < idxA; i++) {
			System.out.print(tempA[i]);
		}
		for(int i = idxB - 1; i>=0;i--) {
			System.out.print(tempB[i]);
		}
		System.out.println();
	}
	
}
