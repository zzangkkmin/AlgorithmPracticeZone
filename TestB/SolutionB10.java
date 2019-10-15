package com.ssafy.git.TestB;


import java.io.IOException;
import java.util.Scanner;

//SWEA 3993. [Professional] Pole
public class SolutionB10 {
	static int n,l,r;
	static long[][][] dp = new long[21][21][21];
	//dp[n][l][r] = n개 막대배치시 왼쪽으로 l개, 오른쪽으로 r개 보이는 경우의 수
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		setting();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n=sc.nextInt(); l=sc.nextInt(); r=sc.nextInt();
			System.out.println("#"+test_case+" "+dp[n][l][r]);
		}
	}
	public static void setting() {
		dp[1][1][1] = 1;
		//가장 짧은 막대 기준으로
		for(int i=2;i<=20;i++) {
			for(int j=1;j<=i;j++) {
				for(int k=1;k<=i;k++) {
					dp[i][j][k] = dp[i-1][j-1][k] + 	// 가장 짧은 막대가 맨 왼쪽에 있을 때 => n-1개 배치시 왼쪽 l-1개 오른쪽 r개 
								  dp[i-1][j][k-1] +		// 가장 짧은 막대가 맨 오른쪽에 있을 때 => n-1개 배치시 왼쪽 l개 오른쪽 r-1개
								  dp[i-1][j][k] * (i-2);// 가장 짧은 막대가 중간에 있을 때 => n-1개 배치시 왼쪽 l개 오른쪽 r개 X 경우의 수 n-2개
				}
			}
		}
	}
	
}
