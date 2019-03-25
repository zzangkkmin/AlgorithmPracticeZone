package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main16957 {
	public static String[] line;
	public static int[][] map, parent, ans;
	public static int[] dx = {0,1,1,1,0,-1,-1,-1};
	public static int[] dy = {1,1,0,-1,-1,-1,0,1};
	public static int r,c;
	public static PriorityQueue<ball> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().trim().split(" ");
		r = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);
		
		map = new int[r][c];
		parent = new int[r][c];
		ans = new int[r][c];
		
		for(int i=0;i<r;i++) {
			line = br.readLine().trim().split(" ");
			for(int j=0;j<c;j++) {
				map[i][j] = Integer.parseInt(line[j]);
				pq.add(new ball(map[i][j], i*c+j));
				ans[i][j] = 1;
			}
		}
//		System.out.println("pause");
//		while(!pq.isEmpty()){
//			System.out.println(pq.poll().mapValue);
//		}
		move();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<r&&y>=0&&y<c) {
			return true;
		}
		else
			return false;
	}
	public static class ball implements Comparable<ball>{
		int mapValue;
		int pos;
		public ball(int mapValue, int pos) {
			super();
			this.mapValue = mapValue;
			this.pos = pos;
		}

		@Override
		public int compareTo(ball o) {
			// TODO Auto-generated method stub
			return o.mapValue - this.mapValue;
		}
	}
	public static void move(){
		while(!pq.isEmpty()){
			ball cur = pq.poll();
			int mini = cur.mapValue;
			int cx = cur.pos / c; int mx = -1;
			int cy = cur.pos % c; int my = -1;
			boolean find = false;
			for(int d = 0; d < 8;d++){
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if(inrange(nx,ny) && mini > map[nx][ny]){
					find = true;
					mini = map[nx][ny];
					mx = nx; my = ny;
				}
			}
			if(find){
				ans[mx][my] += ans[cx][cy];
				ans[cx][cy] = 0;
			}
		}
	}
}
