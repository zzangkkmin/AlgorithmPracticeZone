package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main16957 {
	public static String[] line;
	public static int[][] map, parent, ans;
	public static int[] dx = {0,1,1,1,0,-1,-1,-1};
	public static int[] dy = {1,1,0,-1,-1,-1,0,1};
	public static ArrayList<Integer> root = new ArrayList<>();
	public static int r,c;
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
				parent[i][j] = i*c+j;
			}
		}
		setting();
		positioning();
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<r&&y>=0&&y<c) {
			return true;
		}
		else
			return false;
	}
	public static void setting() {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				boolean find = false;
				int mini = map[i][j];
				int mx = -1; int my = -1;
				for(int d=0;d<8;d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if(inrange(nx,ny) && mini > map[nx][ny]) {
						find = true;
						mini = map[nx][ny];
						mx = nx; my = ny;
					}
				}
				if(find==false) {
					root.add(i*c+j);
				}
				else {
					parent[i][j] = parent[mx][my];
				}
			}
		}
	}
	public static void positioning() {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				int ax = parent[i][j] / c;
				int ay = parent[i][j] % c;
				ans[ax][ay]++;
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}
