package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main11006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int tt = 0; tt<tc; tt++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int u = 2 * m - n;
			int t = m - u;
			System.out.println(u+" "+t);
		}
	}

}
