package com.ssafy.git.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_총잡이 {
	public static int n,m, ans;
	public static String[] line;
	public static char[][] map;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = 0;
			line = br.readLine().trim().split(" ");
			n = Integer.parseInt(line[0]);
			m = Integer.parseInt(line[1]);
			map = new char[n][m];
			for(int i=0;i<n;i++) {
				line = br.readLine().trim().split(" ");
				for(int j=0;j<m;j++) {
					map[i][j] = line[j].charAt(0);
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] == 'G') {
						aim(i,j);
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	public static boolean inrange(int x,int y) {
		if(x>=0&&x<n&&y>=0&&y<m) {
			return true;
		}
		else
			return false;
	}
	public static void aim(int x, int y) {
		
		for(int d=0;d<4;d++) {
			int nx = x;
			int ny = y;
			while(true) {
				nx = nx + dx[d];
				ny = ny + dy[d];
				if(!inrange(nx,ny) || map[nx][ny] == 'W' || map[nx][ny] == 'G' || map[nx][ny] == 'Z') {
					break;
				}
				else if(map[nx][ny] == 'T') {
					ans++;
					map[nx][ny] = 'Z';
					break;
				}
			}
		}
	}
}
