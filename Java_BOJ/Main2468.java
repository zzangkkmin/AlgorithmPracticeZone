package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2468 {
	public static int[][] map;
	public static int min = 0;
	public static int max = -1;
	public static int ans = 0;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0; i < n ; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if(max<map[i][j]) {
					max = map[i][j];
				}
			}
		}
		min = 0;
		for(int len = min; len<=max;len++) {
			for(int i = 0; i < n ; i++) {
				for(int j = 0; j < n;j++) {
					if(map[i][j] < len) {
						map[i][j] = -1;
					}
				}
			}
			bfs(n,len);
		}
		System.out.println(ans);
	}
	public static void bfs(int n, int len) {
		boolean[][] visited = new boolean[n][n];
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j] == false && map[i][j] != -1) {
					Queue<Integer[]> q = new LinkedList<>();
					Integer[] input = {i,j};
					q.add(input);
					visited[i][j] = true;
					while(!q.isEmpty()) {
						Integer[] cur = q.poll();
						int cx = cur[0];
						int cy = cur[1];
						for(int d=0;d<4;d++) {
							int nx = cx + dx[d];
							int ny = cy + dy[d];
							if(nx>=0&&nx<n&&ny>=0&&ny<n&&
								visited[nx][ny]==false&&map[nx][ny]!= -1) {
								Integer[] temp = {nx,ny};
								q.add(temp);
								visited[nx][ny] = true;
							}
						}
					}
					cnt++;
				}
			}
		}
		ans = ans < cnt ? cnt : ans;
	}

}
