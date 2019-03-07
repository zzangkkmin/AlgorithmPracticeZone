package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution3752_D4_가능한_시험점수 {
	public static String[] line;
	public static int n,sum, ans;
	public static int[][] dp;
	public static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			sum = 0; ans = 0;
			n = Integer.parseInt(br.readLine().trim());
			arr =  new int[n+1];
			
			line = br.readLine().trim().split(" ");
			for(int i=0;i<n;i++) {
				arr[i+1] = Integer.parseInt(line[i]);
				sum += arr[i+1];
			}
			dp = new int[n+1][sum+1]; dp[0][0] = 1;
			sum = 0;
			for(int i=1;i<=n;i++) {
				sum += arr[i];
				for(int j=0;j<=sum;j++) {
					if(j<arr[i]) {
						dp[i][j] = dp[i-1][j];
					}
					else {
						dp[i][j] = dp[i-1][j-arr[i]];
						if(dp[i-1][j] == 1) {
							dp[i][j] = dp[i-1][j];
						}
					}
				}
			}
			for(int i=0;i<=sum;i++) {
				if(dp[n][i] == 1) {
					ans++;
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}

}
