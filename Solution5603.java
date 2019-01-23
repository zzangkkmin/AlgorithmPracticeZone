package com.ssafy.algo;

import java.util.Scanner;

public class Solution5603 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int T = 1; T<=test_case;T++){
			int Ans = 0;
			int n = sc.nextInt();
			int[] arr = new int[n];
			int avg = 0;
			for(int i=0;i<n;i++){
				arr[i] = sc.nextInt();
				avg += arr[i];
			}
			avg /= n;
			for(int i=0;i<n;i++){
				Ans += (avg - arr[i] > 0 ? avg - arr[i] : 0);			
			}
			System.out.println("#" + T + " " + Ans);
		}
	}

}
