package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1987 {
	public static int r,c;
	public static char[][] map;
	public static boolean[][] visited;
	public static boolean[] abc = new boolean[26];
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static int ans = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] RC = br.readLine().split(" ");
		r = Integer.parseInt(RC[0]);
		c = Integer.parseInt(RC[1]);
		map = new char[r][c];
		visited = new boolean[r][c];
		for(int i=0;i<r;i++) {
			String line = br.readLine().trim();
			for(int j=0;j<c;j++) {
				map[i][j] = line.charAt(j);
			}
		}
		visited[0][0] = true;
		abc[map[0][0] - 'A'] = true;
		dfs(0,0,1);
		System.out.println(ans);
	}
	public static void dfs(int x, int y, int cnt) {
		ans = ans < cnt ? cnt : ans;
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx>=0 && nx<r && ny>=0 && ny<c && !visited[nx][ny]
				&& !abc[map[nx][ny] - 'A']) {
				visited[nx][ny] = true;
				abc[map[nx][ny] - 'A'] = true;
				dfs(nx,ny,cnt+1);
				abc[map[nx][ny] - 'A'] = false;
				visited[nx][ny] = false;
			}
		}
	}
}
