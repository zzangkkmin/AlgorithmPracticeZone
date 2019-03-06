package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution1258_D4_행렬찾기 {
	public static int n,ans;
	public static String[] line;
	public static int[][] map;
	public static int[][] visited;
	public static ArrayList<matrix> arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
//		ArrayList<matrix> arr = new ArrayList<>();
//		arr.add(new matrix(5, 3));
//		arr.add(new matrix(1, 7));
//		arr.add(new matrix(1, 9));
//		arr.add(new matrix(4, 3));
//		arr.add(new matrix(2, 1));
//		Collections.sort(arr);
//		System.out.println("pause");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = 0;
			n = Integer.parseInt(br.readLine().trim());
			arr = new ArrayList<>();
			map = new int[n][n];
			visited = new int[n][n];
			for(int i=0;i<n;i++) {
				line = br.readLine().trim().split(" ");
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] != 0 && visited[i][j] == 0) {
						confirm(i,j);
						ans++;
					}
				}
			}
			Collections.sort(arr);
			System.out.print("#"+t+" "+ans+" ");
			for(matrix X : arr) {
				System.out.print(X.xx + " " + X.yy + " ");
			}
			System.out.println();
		}
	}
	public static boolean outRange(int x, int y) {
		if(x<0||x>=n||y<0||y>=n)
			return true;
		else
			return false;
	}
	public static void confirm(int x, int y) {
		//세로
		int xx = 1;
		int nx = x + 1;
		while(true) {
			if(map[nx][y] == 0 || outRange(nx,y)) {
				break;
			}
			else {
				xx++;
				nx++;
			}
		}
		//가로
		int yy = 1;
		int ny = y + 1;
		while(true) {
			if(map[x][ny] == 0 || outRange(x,ny)) {
				break;
			}
			else {
				yy++;
				ny++;
			}
		}
		for(int i = x; i<x+xx;i++) {
			for(int j=y;j<y+yy;j++) {
				visited[i][j] = 1;
			}
		}
		arr.add(new matrix(xx, yy));
	}
	static class matrix implements Comparable<matrix>{
		int xx;
		int yy;
		int size;
		public matrix(int xx, int yy) {
			this.xx = xx;
			this.yy = yy;
			this.size = xx*yy;
		}
		@Override
		public int compareTo(matrix other) {
			// TODO Auto-generated method stub
			if(this.size < other.size) {
				return -1;
			}
			else if(this.size == other.size) {
				if(this.xx < other.xx) {
					return -1;
				}
				else
					return 1;
			}
			else
				return 1;
		}
		
	}
}
