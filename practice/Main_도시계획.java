package com.ssafy.git.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_도시계획 {
	public static int n, max;
	public static String[] line;
	public static char[][] map;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		map = new char[n][n];
		for(int i=0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = line[j].toCharArray()[0];
			}
		}
		for(int i=1;i<n-1;i++) {
			for(int j=1;j<n-1;j++) {
				if(map[i][j] == 'B') {
					int length = building(i,j);
					max = max < length ? length: max;
				}
			}
		}
		System.out.println(max);
	}
	public static int building(int x, int y) {
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(map[nx][ny]=='G') {
				return 1;
			}
		}
		int res = 1;
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			while(true) {
				if(nx == 0 || nx == n-1 || ny == 0 || ny == n-1) {
					break;
				}
				if(map[nx][ny] == 'B') {
					res++;
				}
				nx = nx + dx[d];
				ny = ny + dy[d];
			}
		}
		return res;
	}
}

/*
 * 
3
G G G
G B G
G G G

5
G G G G G
G B B G G
G B B B G
G B B B G
G G G G G

8
G G G G G G G G
G G G B G G G G
G G G B B B G G
G B B B B B B G
G G G B B B G G
G G G B G G G G
G G G G G B G G
G G G G G G G G

4
G G G G
G G B G
G B B G
G G G G

9
G G G G G G G G G
G G G B G G G B G
G G G B B B G G G
G B B B B B B B G
G G G B B B G G G
G G G B G G G B G
G G G G G B G G G
G B G B G G B B G
G G G G G G G G G
 */


