package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2817_D3_부분수열합 {
	public static long ans;
	public static int n, k;
	public static int[] arr;
	public static boolean[] select;
	public static void solve(int idx) {
		if(idx==n) {
			int sum = 0;
			for(int i=0;i<n;i++) {
				if(select[i]) {
					sum+=arr[i];
				}
			}
			if(k==sum)
				ans++;
			return;
		}
		select[idx] = true;
		solve(idx+1);
		select[idx] = false;
		solve(idx+1);
	}
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = 0;
			String[] line = br.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			k = Integer.parseInt(line[1]);
			
			line = br.readLine().split(" ");
			arr = new int[n];
			select = new boolean[n];
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(line[i]);
			}
			solve(0);
			System.out.println("#"+t+" "+ans);
		}
	}

}
