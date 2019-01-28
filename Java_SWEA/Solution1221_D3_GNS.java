package com.ssafy.git.Java_SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1221_D3_GNS {
	public static String numToStr(int x) {
		if(x==0) {
			return "ZRO";
		}
		else if(x==1) {
			return "ONE";
		}
		else if(x==2) {
			return "TWO";
		}
		else if(x==3) {
			return "THR";
		}
		else if(x==4) {
			return "FOR";
		}
		else if(x==5) {
			return "FIV";
		}
		else if(x==6) {
			return "SIX";
		}
		else if(x==7) {
			return "SVN";
		}
		else if(x==8) {
			return "EGT";
		}
		else if(x==9) {
			return "NIN";
		}
		return "";
	}
	public static int strToNum(String x) {
		if(x.equals("ZRO")) {
			return 0;
		}
		else if(x.equals("ONE")) {
			return 1;
		}
		else if(x.equals("TWO")) {
			return 2;
		}
		else if(x.equals("THR")) {
			return 3;
		}
		else if(x.equals("FOR")) {
			return 4;
		}
		else if(x.equals("FIV")) {
			return 5;
		}
		else if(x.equals("SIX")) {
			return 6;
		}
		else if(x.equals("SVN")) {
			return 7;
		}
		else if(x.equals("EGT")) {
			return 8;
		}
		else if(x.equals("NIN")) {
			return 9;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int T=1;T<=tc;T++) {
			String tt = sc.next();
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				String str = sc.next();
				arr[i] = strToNum(str);
			}
			Arrays.sort(arr);
			System.out.println(tt);
			for(int i=0;i<n;i++) {
				System.out.print(numToStr(arr[i]) + " ");
			}
			System.out.println();
		}
	}

}
