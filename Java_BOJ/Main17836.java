package com.ssafy.git.Java_BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main17836 {
	static int N,M,T;
	static int[][] map, visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static boolean inrange(int x, int y) {
		if(x>=1&&x<=N&&y>=1&&y<=M) {
			return true;
		}
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		map = new int[N+1][M+1];
		visit = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				map[i][j] = sc.nextInt();
				visit[i][j] = -1;
			}
		}
		search();
		sc.close();
	}
	public static void search() {
		Queue<point> q = new LinkedList<point>();
		visit[1][1] = 0;
		q.add(new point(1,1));
		int dist = N*M + 1;
		while(!q.isEmpty()) {
			point cp = q.poll();
			if(cp.x == N && cp.y == M) {
				dist = dist > visit[cp.x][cp.y] ? visit[cp.x][cp.y] : dist;  
				break;
			}
			for(int d=0;d<4;d++) {
				int nx = cp.x + dx[d];
				int ny = cp.y + dy[d];
				if(inrange(nx,ny) && visit[nx][ny] == -1 && map[nx][ny] != 1) {
					if(map[nx][ny] == 2) {
						int swordDist = (N - nx) + (M - ny) + visit[cp.x][cp.y] + 1;
						dist = dist > swordDist ? swordDist : dist;
					}else {
						visit[nx][ny] = visit[cp.x][cp.y] + 1;
						q.add(new point(nx,ny));
					}
				}
			}
		}
		if(dist == N*M + 1 || dist > T) {
			System.out.println("Fail");
		}else {
			System.out.println(dist);
		}
	}
	static class point{
		int x; int y;

		public point() {
			super();
			// TODO Auto-generated constructor stub
		}

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "( x = " + x + ", y= " + y + " )";
		}
		
	}
}
