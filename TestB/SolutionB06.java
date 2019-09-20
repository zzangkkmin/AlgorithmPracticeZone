package com.ssafy.git.TestB;

import java.util.Scanner;

//SWEA 3954. [Professional] 파이의 합
public class SolutionB06 {
	static final int max = 1000000;
	static long[] pi = new long[max+1];
	static int[] fac = new int[max+1];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		setting();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			long ans = pi[b] - pi[a-1];
			System.out.println("#"+test_case+" "+ans);
		}
	}
	public static void setting() {
		pi[1] = 1;
		for(int i=2;i<=max;i++) {
			if(pi[i] == 0) {
				pi[i] = i-1;			
				fac[i] = 1;
				for(int j=i*2;j<=max; j = j+i) {
					if(pi[j] == 0) {
						pi[j] = -1;
					}
					fac[j] = i;
				}
			}
			else if(pi[i] == -1) {
				int N = i; int div = fac[i]; int retFac = 1;
				while(N % div == 0) {
					N /= div;
					retFac *= div;
				}
				pi[i] = (retFac / div) * (div - 1) * pi[N];
			}
		}
		for(int i=2;i<=max;i++) {
			pi[i] = pi[i] + pi[i-1];
		}
		//System.out.println("end");
	}
	public static int pow(int a, int b) {
		int ret = 1;
		for(int i=0;i<b;i++) {
			ret *= a;
		}
		return ret;
	}
	public static int gcd(int a, int b) {
		if(a<b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int r = a % b;
		if(r == 0) {
			return b;
		}
		return gcd(b,r);
	}
}
