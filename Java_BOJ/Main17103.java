package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17103 {
	static int n;//2<n<=1,000,000 => two prime number add
	static boolean[] numbers = new boolean[1000001];
	static int[] pn = new int[100000];
	static int pnidx = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		primeChe();
		//System.out.println("complete");
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int input = sc.nextInt();
			System.out.println(gold(input));
		}
	}
	public static void primeChe() {
		for(int i=2;i<=1000000;i++) {
			numbers[i] = true;
		}
		for(int i=2;i*i<=1000000;i++) {
			if(numbers[i] == true) {
				for(int j=i+i;j<=1000000;j=j+i) {
					numbers[j] = false;
				}
			}
		}
		for(int i=2;i<=1000000;i++) {
			if(numbers[i] == true) {
				pn[pnidx++] = i;
			}
		}
	}
	public static int gold(int input) {
		int cnt = 0;
		for(int i=0;i<pnidx;i++) {
			if(pn[i] > input/2) {
				break;
			}
			if(numbers[input - pn[i]] == true) {
				cnt++;
			}
		}
		return cnt;
	}
}
