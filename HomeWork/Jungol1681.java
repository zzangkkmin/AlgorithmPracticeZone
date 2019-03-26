package com.ssafy.git.HomeWork;

import java.util.Scanner;

public class Jungol1681 {
	public static boolean find;
	public static int n, ans;
	public static int[] routeIdx;
	public static int[][] map, route;
	public static boolean[] selected;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		route = new int[n][n];
		routeIdx = new int[n];
		selected = new boolean[n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] != 0) {
					route[i][routeIdx[i]] = j;
					routeIdx[i]++;
				}
			}
		}
		ans = Integer.MAX_VALUE;
		selected[0] = true;
		go(0,1,0);
		System.out.println(ans);
	}
	public static void go(int idx, int cnt, int cost) {
		if(cnt==n) {
			if(map[idx][0] == 0) {
				return;
			}
			cost += map[idx][0];
			if(ans>cost) {
				find = true;
				ans = cost;
			}
			return;
		}
		else {
			int rIdx = routeIdx[idx];			
			for(int i=0;i<rIdx;i++) {
				if(!selected[route[idx][i]] && map[idx][route[idx][i]] != 0) {
					if(find && cost + map[idx][route[idx][i]] > ans) {
						continue;
					}
					selected[route[idx][i]] = true;
					go(route[idx][i], cnt+1, cost + map[idx][route[idx][i]]);
					selected[route[idx][i]] = false;
				}
			}
		}
	}
}
