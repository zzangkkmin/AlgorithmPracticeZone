package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main1357 {
	public static int power10(int n, int k) {
		int ret = n;
		for(int i=0;i<k;i++) {
			ret *= 10;
		}
		return ret;
	}
	public static int Rev(int k) {
		int tempK = k;
		int size = 0;
		int ret = 0;
		while(tempK!=0) {
			tempK/=10;
			size++;
		}
		for(int i=size-1;i>=0;i--) {
			ret += power10(k%10, i);
			k/=10;
		}
		return ret;
	}
	public static int Rev(char[] str) {
		int ret = 0;
		for(int i=str.length-1;i>=0;i--) {
			ret += power10(str[i]-'0', i);
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[] X = sc.next().toCharArray();
		char[] Y = sc.next().toCharArray();
		int k = Rev(X) + Rev(Y);
		System.out.println(Rev(k));
		//System.out.println(k);
		
		System.out.println();
	}

}
