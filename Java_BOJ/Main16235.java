package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main16235 {
	public static String[] line;
	public static int n,m,k;
	public static int[][] map, a;
	public static int[] dx = {0,1,1,1,0,-1,-1,-1};
	public static int[] dy = {1,1,0,-1,-1,-1,0,1};
	public static PriorityQueue<tree> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		k = Integer.parseInt(line[2]);
		map = new int[n][n];
		a = new int[n][n];
		for(int i=0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j=0;j<n;j++) {
				a[i][j] = Integer.parseInt(line[j]);
				map[i][j] = 5;
			}
		}
		for(int i=1;i<=m;i++) {
			line = br.readLine().trim().split(" ");
			int x = Integer.parseInt(line[0]) - 1;
			int y = Integer.parseInt(line[1]) - 1;
			int z = Integer.parseInt(line[2]);
			pq.add(new tree(x*n+y, z));
		}
		solve();
	}
	public static class tree implements Comparable<tree>{
		int xyPos; int age; boolean live;

		public tree(int xyPos, int age) {
			super();
			this.xyPos = xyPos;
			this.age = age;
			this.live = true;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("tree [xyPos=").append(xyPos).append(", age=").append(age).append("]");
			return builder.toString();
		}

		@Override
		public int compareTo(tree o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
		
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<n&&y>=0&&y<n) {
			return true;
		}
		else
			return false;
	}
	public static void solve() {
		int year = 0;
		Queue<tree> tq = new LinkedList<>();
		while(year<k) {
			//1.spring 
			int pqSize = pq.size();
			for(int i=0;i<pqSize;i++) {
				tree cur = pq.poll();
				int cx = cur.xyPos / n;
				int cy = cur.xyPos % n;
				if(map[cx][cy] < cur.age) {
					cur.live = false;
					tq.add(cur);
				}
				else {
					map[cx][cy] -= cur.age;
					cur.age++;
					tq.add(cur);
				}
			}
			//2.summer
			int tqSize = tq.size();
			for(int i=0;i<tqSize;i++) {
				tree cur = tq.poll();
				if(cur.live==false) {
					map[cur.xyPos / n][cur.xyPos % n] += cur.age/2;
				}
				else {
					tq.add(cur);
				}
			}
			//3.fall
			tqSize = tq.size();
			for(int i=0;i<tqSize;i++) {
				tree cur = tq.poll();
				if(cur.age % 5 == 0) {
					for(int d=0;d<8;d++) {
						int nx = cur.xyPos / n + dx[d];
						int ny = cur.xyPos % n + dy[d];
						if(inrange(nx,ny)) {
							pq.add(new tree(nx*n+ny,1));
						}
					}
					pq.add(cur);
				}
				else {
					pq.add(cur);
				}
			}
			//4.winter
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] += a[i][j];
				}
			}
			year++;
		}
		System.out.println(pq.size());
	}
}
