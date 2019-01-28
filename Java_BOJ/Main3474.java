package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main3474 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++){
			long n = sc.nextLong();
			long ans = 0;
			long five = 5;
			while(five<=n){
				ans += n/five;
				five *= 5;
			}
			System.out.println(ans);
		}
	}

}
