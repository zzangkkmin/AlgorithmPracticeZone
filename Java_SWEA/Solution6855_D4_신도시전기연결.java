package com.ssafy.git.Java_SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution6855_D4_신도시전기연결 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			int[] diff = new int[n-1];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=0;i<n-1;i++) {
				diff[i] = arr[i+1] - arr[i];
			}
			Arrays.sort(diff);
			int sum = 0;
			if(n<k) {
				System.out.println("#"+t+" "+0);
			}
			else {
				for(int i=0;i<n-k;i++) {
					sum += diff[i];
				}
				System.out.println("#"+t+" "+sum);
			}
		}
	}

}
