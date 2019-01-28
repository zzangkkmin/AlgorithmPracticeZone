package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main2213 {
	public static int n, ans;
	public static int[] arr;
	public static int[][] dp;
	public static Map<Integer, ArrayList<Integer>> connect = 
			new HashMap<Integer, ArrayList<Integer>>();
	public static ArrayList<Integer> route;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		arr = new int[n+1]; 
		dp = new int[n+1][2];
		route = new ArrayList<Integer>();
		String[] val = br.readLine().split(" ");
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(val[i-1]);
		}
		for(int i=1;i<n;i++) {
			String[] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			if(connect.containsKey(a)) {
				connect.get(a).add(b);
			}
			else {
				connect.put(a, new ArrayList<Integer>());
				connect.get(a).add(b);
			}
			if(connect.containsKey(b)) {
				connect.get(b).add(a);
			}
			else {
				connect.put(b, new ArrayList<Integer>());
				connect.get(b).add(a);
			}
		}
		dfs(1,-1);
		ans = dp[1][0] < dp[1][1] ? dp[1][1] : dp[1][0];
		System.out.println(ans);
		int select = dp[1][0] < dp[1][1] ? 1: 0;
		find(1,select,-1);
		Collections.sort(route);
		for(int a : route) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	public static void dfs(int cur, int p) {
		dp[cur][1] = arr[cur];//select
		for(int next : connect.get(cur)) {
			if(next == p)
				continue;
			dfs(next,cur);
			dp[cur][1] += dp[next][0];
			dp[cur][0] += Math.max(dp[next][1], dp[next][0]);
		}
	}
	public static void find(int cur, int select, int p) {
		if(select==1)
			route.add(cur);
		for(int next : connect.get(cur)) {
			if(next == p)
				continue;
			if(select==1) {
				find(next, 0, cur);
			}
			else {
				if(dp[next][0] < dp[next][1])
					find(next,1,cur);
				else
					find(next,0,cur);
			}
		}
	}
}
