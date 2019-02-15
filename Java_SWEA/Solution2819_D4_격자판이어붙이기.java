package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2819_D4_격자판이어붙이기 {
	public static int[][] map;
	public static int[] dx = {0,-1,0,1};
	public static int[] dy = {1,0,-1,0};
	public static boolean[] visit;
	public static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = 0;
			map = new int[4][4];
			visit = new boolean[10000000];
			for(int i=0;i<4;i++) {
				String[] line = br.readLine().split(" ");
				for(int j=0;j<4;j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					find(i,j,0,0);
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	public static void find(int x, int y, int step, int res) {
		if(step==7) {
			if(!visit[res]) {
				ans++;
				visit[res] = true;
			}
			return;
		}
		int temp = res*10;
		temp += map[x][y];
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx>=0&&nx<4&&ny>=0&&ny<4) {
				find(nx,ny,step+1,temp);
			}
		}
		temp -= map[x][y];
		temp /= 10;
	}

}
