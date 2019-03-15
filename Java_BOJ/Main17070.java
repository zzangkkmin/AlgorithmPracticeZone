package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17070 {
	public static int n, ans;
	public static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		solve(0,1,3);
		System.out.println(ans);
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<n&&y>=0&&y<n) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void solve(int px, int py, int mode) {
		if(mode == 1) {
			if(px==n-1&&py==n-1) {
				ans++;
				return;
			}
			if(inrange(px+1, py) && map[px+1][py] == 0) {
				solve(px+1,py,1);
			}
			if(inrange(px+1,py) && inrange(px+1,py+1) && inrange(px,py+1) && 
				map[px+1][py] == 0 && map[px+1][py+1] == 0 && map[px][py+1] == 0) {
				solve(px+1,py+1,2);
			}
		}
		else if(mode == 2) {
			if(px==n-1&&py==n-1) {
				ans++;
				return;
			}
			if(inrange(px+1, py) && map[px+1][py] == 0) {
				solve(px+1,py,1);
			}
			if(inrange(px+1,py) && inrange(px+1,py+1) && inrange(px,py+1) && 
				map[px+1][py] == 0 && map[px+1][py+1] == 0 && map[px][py+1] == 0) {
				solve(px+1,py+1,2);
			}
			if(inrange(px, py+1) && map[px][py+1] == 0) {
				solve(px,py+1,3);
			}
		}
		else {
			if(px==n-1&&py==n-1) {
				ans++;
				return;
			}
			if(inrange(px, py+1) && map[px][py+1] == 0) {
				solve(px,py+1,3);
			}
			if(inrange(px+1,py) && inrange(px+1,py+1) && inrange(px,py+1) && 
				map[px+1][py] == 0 && map[px+1][py+1] == 0 && map[px][py+1] == 0) {
				solve(px+1,py+1,2);
			}
		}
	}
}
