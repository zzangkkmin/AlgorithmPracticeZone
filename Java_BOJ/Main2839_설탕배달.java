package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		//dp[n] = n kg일때 최소 개수
		int[] dp = new int[n+1];
		if(n<5) {
			if(n==3) {
				System.out.println(1);
			}
			else {
				System.out.println(-1);
			}
		}
		else {
			dp[1] = dp[2] = dp[4] = -1;
			dp[3] = dp[5] = 1;
			
			for(int i = 6; i <= n; i++) {
				dp[i] = 99999999;
				boolean mode = false;
				for(int j = 1; j <= i/2; j++) {
					if(dp[j] == -1 || dp[i-j] == -1) {
						continue;
					}
					else {
						mode = true;
						dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
					}
				}
				if(mode==false) {
					dp[i] = -1;
				}
			}
			System.out.println(dp[n]);
		}
	}

}
