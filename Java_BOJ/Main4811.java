package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main4811 {
	static int n;
	static long[][] d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			d = new long[n+1][n+1];
			if(n==0) {
				break;
			}
			System.out.println(go(n-1,1));
		}
	}
	//d[w][h] = d[w-1][h+1] + d[w][h-1]
	public static long go(int w, int h) {
		if(w==0) {
			return d[w][h] = 1; 
		}
		else if(w>0 && d[w][h] != 0) {
			return d[w][h];
		}
		else {
			long sum = 0;
			sum += go(w-1,h+1);
			if(h>=1) {
				sum += go(w,h-1);
			}
			return d[w][h] = sum;
		}
	}
}
