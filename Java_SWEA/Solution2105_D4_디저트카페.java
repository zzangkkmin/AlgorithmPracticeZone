package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution2105_D4_디저트카페 {
	public static int n,ans;
	public static int[][] map;
	public static boolean[] dessert;
	public static int[] dx = {1,1,-1,-1};
	public static int[] dy = {1,-1,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			ans = -1;
			n = sc.nextInt();
			map = new int[n][n];
			dessert = new boolean[100+1];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if((i==0&&j==0) || (i==0&&j==n-1) ||
						(i==n-1&&j==0) || (i==n-1&&j==n-1)) {
						continue;
					}
					go(i,j,i,j,0);
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<n&&y>=0&&y<n) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void go(int x, int y, int sx, int sy, int dir) {
		if(x==sx&&y==sy&&dir!=0) {
			int cnt = 0;
			for(int i=1;i<=100;i++) {
				if(dessert[i])
					cnt++;
			}
			ans = ans < cnt ? cnt : ans;
		}
		else {
			for(int d=0;d<2;d++) {
				int nd = dir + d;
				if(nd==4) {
					break;
				}
				int nx = x + dx[nd];
				int ny = y + dy[nd];
				if(inrange(nx,ny) && dessert[map[nx][ny]]==false) {
					dessert[map[nx][ny]] = true;
					go(nx,ny,sx,sy,nd);
					dessert[map[nx][ny]] = false;
				}
			}
		}
	}
}
