package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main1712 {
	public static long a,b,c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		b = sc.nextLong();
		c = sc.nextLong();
		if(b==c) {
			System.out.println(-1);	
		}else {
			long x = a/(c-b);
			if(x<0) {
				System.out.println(-1);	
			}
			else {
				System.out.println(x+1);
			}
		}
	}

}
