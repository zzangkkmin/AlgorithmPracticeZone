package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main2725 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] d = new int[1001];
		d[1] = 3;
		for(int i=2;i<=1000;i++){
			d[i] = d[i-1] + (1<<(((i-1)/2)+1));
		}
		
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++){
			int n = sc.nextInt();
			System.out.println(d[n]);
		}
	}

}
