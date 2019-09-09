package com.ssafy.git.Java_BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16973 {
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int N,M, H,W, Sr,Sc, Fr,Fc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		H = sc.nextInt();
		W = sc.nextInt();
		Sr = sc.nextInt();
		Sc = sc.nextInt();
		Fr = sc.nextInt();
		Fc = sc.nextInt();
		System.out.println(solve());
	}
	public static boolean inrange(int x, int y) {
		if(x >= 1 && x <= N && y >= 1 && y <= M) {
			return true;
		}
		return false;
	}
	public static int solve() {
		int[][] visit = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				visit[i][j] = -1;
			}
		}
		Queue<rect> q = new LinkedList<rect>();
		visit[Sr][Sc] = 0;
		q.add(new rect(H, W, Sr, Sc));
		while(!q.isEmpty()) {
			rect cur = q.poll();
			if(cur.LTx == Fr && cur.LTy == Fc) {
				return visit[Fr][Fc];
			}
			for(int d=0;d<4;d++) {
				int nx = cur.LTx + dx[d];
				int ny = cur.LTy + dy[d];
				rect nextR = new rect(H, W, nx, ny);
				if(inrange(nx,ny) && visit[nx][ny] == -1 && isValid(nextR)) {
					visit[nx][ny] = visit[cur.LTx][cur.LTy] + 1;
					q.add(nextR);
				}
			}
		}
		return -1;
	}
	public static boolean isValid(rect cur) {
		for(int dir = 0; dir<4; dir++) {
			switch(dir) {
			case 0:
				for(int i = cur.LTy; i<=cur.RTy; i++) {
					if(!inrange(cur.LTx, i) || map[cur.LTx][i] == 1) {
						return false;
					}
				}
				break;
			case 1:
				for(int i = cur.RTx; i<=cur.RBx; i++) {
					if(!inrange(i, cur.RTy) || map[i][cur.RTy] == 1) {
						return false;
					}
				}
				break;
			case 2:
				for(int i = cur.RBy; i>=cur.LBy; i--) {
					if(!inrange(cur.RBx, i) || map[cur.RBx][i] == 1) {
						return false;
					}
				}
				break;
			case 3:
				for(int i = cur.LBx; i>=cur.LTx; i--) {
					if(!inrange(i, cur.LBy) || map[i][cur.LBy] == 1) {
						return false;
					}
				}
				break;
			}
		}
		return true;
	}
	public static class rect{
		int LTx, LTy;
		int RTx, RTy;
		int RBx, RBy;
		int LBx, LBy;
		public rect(int h, int w, int sr, int sc) {
			super();
			this.LTx = sr;			this.LTy = sc;
			this.RTx = sr;			this.RTy = sc + w - 1;
			this.RBx = sr + h - 1;	this.RBy = sc + w - 1;
			this.LBx = sr + h - 1;	this.LBy = sc;
		}
	}
	
}
