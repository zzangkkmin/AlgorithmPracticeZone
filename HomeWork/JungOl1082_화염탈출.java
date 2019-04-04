package com.ssafy.git.HomeWork;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JungOl1082_화염탈출 {
	public static int r,c, kx, ky;
	public static char[][] map;
	public static int[][] visit;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static Queue<node> q = new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		map = new char[r][c];
		visit = new int[r][c];
		for(int i=0;i<r;i++) {
			String line = sc.next();
			for(int j=0;j<c;j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '*') {
					q.add(new node(i, j, -1));
				}
				else if(map[i][j] == 'S') {
					kx = i; ky = j;
				}
				visit[i][j] = -1;
			}
		}
		int ans = bfs();
		if(ans==-1) {
			System.out.println("impossible");
		}
		else {
			System.out.println(ans);
		}
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<r&&y>=0&&y<c) {
			return true;
		}
		else
			return false;
	}
	public static int bfs() {
		visit[kx][ky] = 0;
		q.add(new node(kx, ky, 0));
		while(!q.isEmpty()) {
			node cur = q.poll();
			if(map[cur.x][cur.y] == 'D') {
				return visit[cur.x][cur.y];
			}
			if(cur.mode == -1) {
				for(int d = 0; d< 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if(inrange(nx,ny) && map[nx][ny] == '.') {
						map[nx][ny] = '*';
						q.add(new node(nx, ny, -1));
					}
				}
			}else {
				for(int d = 0; d< 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if(inrange(nx,ny) && (map[nx][ny] == '.' || map[nx][ny] == 'D') &&
						visit[nx][ny] == -1) {
						visit[nx][ny] = visit[cur.x][cur.y]+ 1 ;
						q.add(new node(nx, ny, 0));
					}
				}
			}
		}
		return -1;
	}
	static class node{
		int x; int y; int mode;

		public node(int x, int y, int mode) {
			super();
			this.x = x;
			this.y = y;
			this.mode = mode;
		}
		
	}
}
