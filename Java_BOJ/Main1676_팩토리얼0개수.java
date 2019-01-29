package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main1676_팩토리얼0개수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		int five = 5;
		while(five<=n) {
			ans += n/five;
			five *= 5;
		}
		System.out.println(ans);
	}

}
