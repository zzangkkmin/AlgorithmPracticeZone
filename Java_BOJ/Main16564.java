package com.ssafy.git.Java_BOJ;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main16564 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextLong();
		long[] a = new long[n];
		long sum = 0;
		for(int i=0;i<n;i++) {
			a[i] = sc.nextLong();
			sum += a[i];
		}
		long avg = (sum + k) / (long) n;
		Arrays.sort(a);
		int idx = 0; long max;
		while(true) {
			if(k==0) {
				break;
			}
			long plus = avg - a[idx];
			plus = plus < k ? plus : k;
			k = k - plus;
			a[idx] = a[idx] + plus;
			idx++;
		}
	}

}
