package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14501 {
	public static int n, ans;
	public static String[] line;
	public static int[][] tp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		tp = new int[n+1][2];
		for(int i=0;i<n;i++) {
			line = br.readLine().split(" ");
			tp[i+1][0] = Integer.parseInt(line[0]);//T
			tp[i+1][1] = Integer.parseInt(line[1]);//P
		}
		solve(1,0);
		System.out.println(ans);
	}	
	public static void solve(int day, int cost) {
		if(day == n+1) {
			ans = ans < cost ? cost : ans;
		}
		else if(day > n+1){
			return;
		}
		else {
			solve(day+tp[day][0], cost+tp[day][1]);
			solve(day+1,cost);
		}
	}
}
