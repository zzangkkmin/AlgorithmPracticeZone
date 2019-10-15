package com.ssafy.git.Java_BOJ;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main17472 {
	static int n,m,l;
	static int[][] map, dist;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[] parent;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		map = setIsland();
		setBridge();
		System.out.println(connect());
	}
	public static boolean inRange(int x, int y) {
		if(x>=0&&x<n&&y>=0&&y<m) {
			return true;
		}
		else {
			return false;
		}
	}
	public static int[][] setIsland() {
		int[][] update = new int[n][m];
		int land = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 1 && update[i][j] == 0) {
					Queue<int[]> q = new LinkedList<int[]>();
					int[] xy = {i,j};
					update[i][j] = land;
					q.add(xy);
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						for(int d=0;d<4;d++) {
							int[] next = {cur[0]+dx[d], cur[1]+dy[d]};
							if(inRange(next[0], next[1]) && map[next[0]][next[1]] == 1 &&
								update[next[0]][next[1]] == 0) {
								update[next[0]][next[1]] = land;
								q.add(next);
							}
						}
					}
					land++;
				}
			}
		}
		dist = new int[land][land];
		parent = new int[land]; l = land;
		for(int i=1;i<land;i++) {
			for(int j=1;j<land;j++) {
				if(i==j) {
					dist[i][j] = 0;
				}else {
					dist[i][j] = 9999;
				}
			}
			parent[i] = i;
		}
		return update;
	}
	public static void setBridge() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] != 0) {
					int island = map[i][j];
					int x = i; int y= j;
					for(int d=0;d<4;d++) {
						int nx = x;	int ny = y; int len = 0;
						while(true) {
							nx = nx + dx[d];
							ny = ny + dy[d];
							
							if(!inRange(nx, ny) || map[nx][ny] == island) {
								break;
							}
							else if(map[nx][ny] != 0 && map[nx][ny] != island) {
								if(len > 1) {
									dist[island][map[nx][ny]] = len < dist[island][map[nx][ny]] ?
											len : dist[island][map[nx][ny]];
									dist[map[nx][ny]][island] = dist[island][map[nx][ny]];
									break;
								}else {
									break;
								}
							}
							
							len++;
							
						}
					}
				}
			}
		}
	}
	public static int connect() {
		int ans = 0;
		PriorityQueue<edge> pq = new PriorityQueue<edge>(new comparatorPQ());
		int eCount = 0;
		for(int i=1;i<l;i++) {
			for(int j=1;j<l;j++) {
				if(dist[i][j] > 0 && dist[i][j] < 9999) {
					edge e = new edge(i, j, dist[i][j]);
					pq.add(e);
				}
			}
		}
		while(!pq.isEmpty()) {
			if(eCount == l-2) {
				return ans;
			}
			edge cur = pq.poll();
			if(union(cur.x, cur.y)) {
				ans += cur.dist;
				eCount++;
			}
		}
		return -1;
	}
	public static int find(int a) {
		if(a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}else {
			parent[aRoot] = bRoot;
			return true;
		}
	}
	
	static class edge{
		int x,y,dist;

		public edge(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
	}
	static class comparatorPQ implements Comparator<edge>{

		@Override
		public int compare(edge o1, edge o2) {
			// TODO Auto-generated method stub
			if(o1.dist < o2.dist) {
				return -1;
			} else {
				return 1;
			}
		}
		
	}
}
