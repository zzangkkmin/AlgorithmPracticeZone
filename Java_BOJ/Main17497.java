package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17497 {
	static long x; 
	static long upperLimit = 1;
	static int ansCnt = -1;
	static String ansStr = "";
	static boolean findAns;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setLimit();
		Scanner sc = new Scanner(System.in);
		x = sc.nextLong();
		calculate();
		ansCnt = ansStr.length();
		System.out.println(ansCnt);
		for(int i=ansCnt-1;i>=0;i--) {
			System.out.print("["+ansStr.charAt(i)+"] ");
		}
		sc.close();
	}
	public static void setLimit() {
		for(int i=0;i<63;i++) {
			upperLimit *= 2;
		}
		upperLimit -= 1;
	}
	public static void calculate() {
		while(x>0) {
			if((x&1) != 0) {
				ansStr = ansStr.concat("/");
				x *= 2;
			} else if((x&2) != 0) {
				ansStr = ansStr.concat("+");
				x -= 2;
			} else {
				ansStr = ansStr.concat("*");
				x /= 2;
			}
		}
	}
}
