package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution1949_D4_등산로2 {
	public static int n,k, maxx, spIdx, ans;
	public static int[][] map;
	public static int[][] visit;
	public static int[] startPoint;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			map = new int[n][n];
			visit = new int[n][n];
			spIdx = 0; maxx = 0; ans = 0;
			startPoint = new int[5];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
					maxx = maxx < map[i][j] ? map[i][j] : maxx;
				}
			}
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<n;j++) {
//					if(map[i][j] == maxx) {
//						startPoint[spIdx++] = i*n+j;
//					}
//				}
//			}
			//
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==maxx) {
						visit[i][j] = 1;
						solve(i, j, 1, 0, map[i][j]);
						visit[i][j] = 0;
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
		sc.close();
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<n&&y>=0&&y<n) {
			return true;
		}
		else
			return false;
	}
	public static void solve(int x, int y, int len, int mode, int h) {
		int fourWayfind = 0;
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(inrange(nx,ny) && map[nx][ny] < h && visit[nx][ny] == 0) {
				visit[nx][ny] = 1;
				solve(nx,ny,len+1,mode,map[nx][ny]);
				visit[nx][ny] = 0;
			}
			else if(mode==0 && inrange(nx,ny) && map[x][y] > map[nx][ny] - k && visit[nx][ny] == 0) {
				visit[nx][ny] = 1;
				solve(nx,ny,len+1,1,map[x][y] - 1);
				visit[nx][ny] = 0;
			}
			else {
				fourWayfind++;
			}
		}
		if(fourWayfind==4) {
			ans = len > ans ? len : ans;
		}
	}
}
