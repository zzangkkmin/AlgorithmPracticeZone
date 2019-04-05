package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution4366_은행업무 {
	static char[] two, three;
	static boolean find;
	static long ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			find = false; ans = 0;
			two = sc.next().toCharArray();
			three = sc.next().toCharArray();
			select_two();
			System.out.println("#"+t+" "+ans);
		}
	}
	public static void select_two() {
		int strlen = two.length;
		for(int i=0;i<strlen;i++) {
			two[i] = (two[i]=='1'?'0':'1');
			select_three();
			if(find) {
				return;
			}
			two[i] = (two[i]=='1'?'0':'1');
		}
	}
	public static void select_three() {
		int strlen = three.length;
		for(int i=0;i<strlen;i++) {
			if(three[i] == '0') {
				three[i] = '1';
				calculate();
				if(find) {
					return;
				}
				three[i] = '2';
				calculate();
				if(find) {
					return;
				}
				three[i] = '0';
			}
			else if(three[i] == '1') {
				three[i] = '0';
				calculate();
				if(find) {
					return;
				}
				three[i] = '2';
				calculate();
				if(find) {
					return;
				}
				three[i] = '1';
			}
			else {
				three[i] = '0';
				calculate();
				if(find) {
					return;
				}
				three[i] = '1';
				calculate();
				if(find) {
					return;
				}
				three[i] = '2';
			}
		}
	}
	public static void calculate() {
		int twoLen = two.length; long twoVal = 0;
		int threeLen = three.length; long threeVal = 0;
		for(int i=twoLen-1;i>=0;i--) {
			twoVal += Math.pow(2, (twoLen-1) - i) * (two[i] - '0');
		}
		for(int i=threeLen-1;i>=0;i--) {
			threeVal += Math.pow(3, (threeLen-1) - i) * (three[i] - '0');
		}
		if(twoVal == threeVal) {
			find = true;
			ans = twoVal;
			return;
		}
	}
}
