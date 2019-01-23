package com.ssafy.swe;

import java.util.Scanner;

public class Main2004 {
	public static long min(long a, long b) {
		return a < b ? a : b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		long cnt2 = 0;
		long cnt5 = 0;
		for(long i = 2; i<=n; i = i*2) {
			cnt2 = cnt2 + n/i;
		}
		for(long i = 2; i<=m; i = i*2) {
			cnt2 = cnt2 - m/i;
		}
		for(long i = 2; i<=(n-m); i = i*2) {
			cnt2 = cnt2 - (n-m)/i;
		}
		
		for(long j = 5; j<=n; j = j * 5) {
			cnt5 = cnt5 + n/j;
		}
		for(long j = 5; j<=m; j = j * 5) {
			cnt5 = cnt5 - m/j;
		}
		for(long j = 5; j<=(n-m); j = j * 5) {
			cnt5 = cnt5 - (n-m)/j;
		}
		
		System.out.println(min(cnt2,cnt5));
	}

}
