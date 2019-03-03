package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main2589 {
	public static int h,w, ans;
	public static char[][] map;
	public static int[][] visit;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		h = Integer.parseInt(line[0]);
		w = Integer.parseInt(line[1]);
		map = new char[h][w];
		visit = new int[h][w];
		for(int i=0;i<h;i++){
			String input = br.readLine().trim();
			for(int j=0;j<w;j++){
				map[i][j] = input.charAt(j);
			}
		}
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				if(map[i][j] == 'L'){
					int temp = find(i,j);
					ans = ans < temp ? temp : ans;
				}
			}
		}
		System.out.println(ans);
	}
	public static int find(int x, int y){
		for(int i=0;i<h;i++){
			Arrays.fill(visit[i], -1);
		}
		Queue<Integer[]> q = new LinkedList<>();
		Integer[] start = new Integer[2];
		start[0] = x; start[1] = y;
		q.add(start);
		visit[x][y] = 0;
		int res = 0;
		while(!q.isEmpty()){
			Integer[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			res = res < visit[cx][cy] ? visit[cx][cy] : res;
			for(int d = 0; d<4;d++){
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if(nx >=0 && nx < h && ny >= 0 && ny < w &&
					map[nx][ny] == 'L' && visit[nx][ny] == -1){
					Integer[] next = new Integer[2];
					next[0] = nx; next[1] = ny;
					q.add(next);
					visit[nx][ny] = visit[cx][cy] + 1;
				}
			}
		}
		return res;
	}

}
