package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution3234_D4_양팔저울 {
	static int n, ans;
	static int[] arr, p;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		long start = System.currentTimeMillis();
		for(int t=1;t<=tc;t++) {
			ans = 0;
			n = sc.nextInt();
			arr = new int[n];
			p = new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			permu(0,0);
			//scale(0,0,0,0);
			System.out.println("#"+t+" "+ans);
		}
		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"sec.");
	}
	public static void permu(int idx, int selectBit) {
		if(idx==n) {
			scale(0,0,0);
			return;
		}
		for(int i=0;i<n;i++) {
			if((selectBit & (1<<i)) == 0) {
				p[idx] = arr[i];
				permu(idx+1,(selectBit | (1<<i)));
			}
		}
	}
	public static void scale(int L, int R, int idx) {
		if(idx==n) {
			ans++;
			return;
		}
		if(L>=R+p[idx]) {
			scale(L,R+p[idx],idx+1);
		}
		scale(L+p[idx],R,idx+1);
	}
	
	public static void scale(int L, int R, int idx, int selectBit) {
		if(idx==n) {
			ans++;
			return;
		}
		for(int i=0;i<n;i++) {
			if((selectBit & (1<<i)) == 0) {
				if(L>=R+arr[i]) {
					scale(L,R+arr[i],idx+1, selectBit | (1<<i));
				}
				scale(L+arr[i],R,idx+1,selectBit | (1<<i));
			}
		}
	}
}




