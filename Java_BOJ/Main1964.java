package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main1964 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = 1 % 45678;
		for(int i=1;i<=n;i++) {
			k = (k + (3*i+1)) % 45678;
		}
		System.out.println(k);
	}

}
