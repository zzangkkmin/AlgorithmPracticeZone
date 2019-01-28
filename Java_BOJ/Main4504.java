package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main4504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 0;
		while(true){
			a = sc.nextInt();
			if(a==0){
				break;
			}
			if(a%3!=0){
				System.out.println(a + " is NOT a multiple of "+n+".");
			}
			else{
				System.out.println(a + " is a multiple of "+n+".");
			}
		}
	}

}
