package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution7234_D3_안전기지 {
	public static String[] line;
	public static int n,b;
	public static int[][] map;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<tc;t++) {
			line = br.readLine().trim().split(" ");
			n = Integer.parseInt(line[0]);
			b = Integer.parseInt(line[1]);
			map = new int[n+1][n+1];
			for(int i=0;i<b;i++) {
				line = br.readLine().trim().split(" ");
				int x = Integer.parseInt(line[0]);
				int y = Integer.parseInt(line[1]);
				setup(x,y);
			}
			int maxx = 0;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					maxx = maxx < map[i][j] ? map[i][j] : maxx;
				}
			}
			System.out.println("#"+t+" "+maxx);
		}
	}
	public static void setup(int x, int y) {
		map[x][y]++;
		for(int l=1;l<=2;l++) {
			for(int d=0;d<4;d++) {
				int nx = x + dx[d]*l;
				int ny = y + dy[d]*l;
				if(nx>=1&&nx<=n&&ny>=1&&ny<=n) {
					map[nx][ny]++;
				}
			}
		}
	}
}
