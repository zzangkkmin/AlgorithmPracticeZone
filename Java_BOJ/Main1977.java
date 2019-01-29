package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main1977 {
	public static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		int a = (int) Math.sqrt(m);
		int b = (int) Math.sqrt(n);
//		System.out.println(a + " " + b);
		int min = -1; int sum = 0;
		for(int i = a; i<=b;i++) {
			if(i*i>=m && i*i<=n) {
				sum += i*i;
				if(min == -1) {
					min = i*i;
				}
			}
		}
		if(min!=-1) {
			System.out.println(sum);
			System.out.println(min);
		}
		else {
			System.out.println(-1);
		}
	}

}
