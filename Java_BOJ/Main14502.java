package com.ssafy.git.Java_BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main14502 {
	public static int ans = -1;
	public static int n;
	public static int m;
	public static int[][] map;
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static ArrayList<Node> zone = new ArrayList<>();
	public static class Node {
		public int x;
		public int y;
		Node(){}
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) {
					zone.add(new Node(i,j));
				}
			}
		}
		for(int i=0;i<zone.size()-2;i++) {
			map[zone.get(i).x][zone.get(i).y] = 1;
			for(int j=i+1;j<zone.size()-1;j++) {
				map[zone.get(j).x][zone.get(j).y] = 1;
				for(int k=j+1;k<zone.size();k++) {
					map[zone.get(k).x][zone.get(k).y] = 1;
					bfs();
					map[zone.get(k).x][zone.get(k).y] = 0;
				}
				map[zone.get(j).x][zone.get(j).y] = 0;
			}
			map[zone.get(i).x][zone.get(i).y] = 0;
		}
		System.out.println(ans);
	}
	public static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		int[][] tmap = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tmap[i][j] = map[i][j];
				if(tmap[i][j] == 2) {
					q.add(new Node(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			for(int d=0;d<4;d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if(nx>=0&&nx<n&&ny>=0&&ny<m&&tmap[nx][ny]==0) {
					tmap[nx][ny] = 2;
					q.add(new Node(nx,ny));
				}
			}
		}
		int sum = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(tmap[i][j] == 0) {
					sum++;
				}
			}
		}
		ans = ans < sum ? sum : ans;
	}
	
}
