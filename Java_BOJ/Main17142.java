package com.ssafy.git.Java_BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main17142
{
	public static int N,M, Sidx;
	public static int[][] map;
	public static int[][] select;
	public static int ans = 9999;
	public static int Zcnt = 0;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String args[]) throws Exception{
		 Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 M = sc.nextInt();
		 select = new int[10][2];
		 for(int i=0;i<10;i++) {
			 select[i][0] = -1;
		 }
		 map = new int[N][N];
		 for(int i=0;i<N;i++) {
			 for(int j=0;j<N;j++) {
				 map[i][j] = sc.nextInt();
				 if(map[i][j] == 2) {
					 select[Sidx++][0] = i * N + j;
				 }
				 else if(map[i][j] == 0) {
					 Zcnt++;
				 }
			 }
		 }
		 selectFunc(0,0);
		 if(ans == 9999) {
			 System.out.println(-1);
		 }else {
			 System.out.println(ans);
		 }
	}
	public static void selectFunc(int si, int cnt) {
		if(Zcnt == 0) {
			ans = 0;
			return;
		}
		if(cnt == M) {
			int temp = spread();
			ans = temp < ans ? temp : ans;
			return;
		}
		if(si == Sidx) {
			return;
		}
		select[si][1] = 1;
		selectFunc(si+1,cnt+1);
		select[si][1] = 0;
		selectFunc(si+1,cnt);
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<N&&y>=0&&y<N) {
			return true;
		}
		else
			return false;
	}
	public static int spread() {
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] visit = new int[N][N];
		int czero = 0; int vTime = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				visit[i][j] = -1;
			}
		}
		for(int i=0; i<Sidx; i++) {
			if(select[i][1] == 1) {
				int vx = select[i][0] / N;
				int vy = select[i][0] % N;
				visit[vx][vy] = 0;
				q.add(select[i][0]);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			int cx = cur / N; int cy = cur % N;
			int visitTime = visit[cx][cy];
			if(map[cx][cy] == 0) {
				vTime = vTime < visitTime ? visitTime : vTime;
			}
			for(int d=0;d<4;d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if(!inrange(nx,ny) || map[nx][ny] == 1 || visit[nx][ny] != -1) {
					continue;
				} else if(map[nx][ny] == 2) {
					visit[nx][ny] = visit[cx][cy] + 1;
					q.add(nx * N + ny);
				} else {
					visit[nx][ny] = visit[cx][cy] + 1;
					q.add(nx * N + ny);
					czero++;
					
				}
			}
			
		}
		if(czero != Zcnt) {
			return 10000;
		} else {
			return vTime;
		}
	}
}