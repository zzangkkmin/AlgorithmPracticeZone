package com.ssafy.swe;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution5215_D3_햄버거다이어트 {//Solution
	static int N, L, Ans;
	public static void solve(int idx, int[][] tk, int score, int limit) {
		if(idx==N) {
			Ans = Ans < score ? score : Ans;
			return;
		}
		else {
			score += tk[idx][0];
			limit += tk[idx][1];
			if(limit>L) {
				score -= tk[idx][0];
				limit -= tk[idx][1];
				solve(idx + 1, tk, score, limit);
			}
			else {
				solve(idx + 1, tk, score, limit);
				score -= tk[idx][0];
				limit -= tk[idx][1];
				solve(idx + 1, tk, score, limit);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		N = 0; L = 0;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++){
			Ans = 0;
			N=sc.nextInt();//1~20
			L=sc.nextInt();//1~10000
			int[][] TK = new int[N][2];//(T,K)
			//int[] selected = new int[N];
			for(int i=0;i<N;i++) {
				TK[i][0] = sc.nextInt();
				TK[i][1] = sc.nextInt();
			}
			solve(0,TK,0,0);
			System.out.println("#" + test_case + " " + Ans);
		}
	}
}
