package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17830 {

	static int testcase, Bmin1n, Bmax1n;
	static String B; 
	static int[] A, AXB;
	static int[] minMax = new int[2];
	static int[][] Bm;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		testcase = sc.nextInt();
		for(int t=0;t<testcase;t++) {
			int len = sc.nextInt();
			B = sc.next();
			setB(len);
			mul(len);
			System.out.println(minMax[1] + " " + minMax[0]);
		}
	} 
	public static void setB(int len) {
		Bm = new int[2][len]; Bmin1n = 0; Bmax1n = 0;
		for(int i=0;i<len;i++) {
			if(B.charAt(i) == '?') {
				Bm[0][i] = 0;
				Bm[1][i] = 1;
				Bmax1n++;
			} else {
				Bm[0][i] = B.charAt(i) - '0';
				Bm[1][i] = B.charAt(i) - '0';
				if(Bm[0][i] == 1) {
					Bmin1n++;
				}
				if(Bm[1][i] == 1) {
					Bmax1n++;
				}
			}
		}
	}
	public static void mul(int len) {
		minMax[0] = 1; minMax[1] = 1;
		for(int mode=0;mode<2;mode++) {
			int ans = 1;
			for(int i=0;i<len;i++) {
				if(Bm[mode][i] == 1) {
					ans = len + len - i;
					if(mode == 0 && Bmin1n <= 1) {
						ans--;
					} else if(mode == 1 && Bmax1n <= 1 ) {
						ans--;
					}
					break;
				}
			}
			minMax[mode] = ans;
		}
	}
}
