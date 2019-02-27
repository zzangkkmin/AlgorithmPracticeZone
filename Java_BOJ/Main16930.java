package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main16930 {
	public static String[] line;
	public static char[][] map;
	public static int n,m,k,sx,sy,ex,ey;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		k = Integer.parseInt(line[2]);
		map = new char[n][m];
		for(int i=0;i<n;i++) {
			String linez = br.readLine().trim();
			for(int j=0;j<m;j++) {
				map[i][j] = linez.charAt(j);
			}
		}
		line = br.readLine().split(" ");
		sx = Integer.parseInt(line[0]);
		sy = Integer.parseInt(line[1]);
		ex = Integer.parseInt(line[2]);
		ey = Integer.parseInt(line[3]);
		find();
	}
	public static void find() {
		int[][] visit = new int[n][m];
		for(int i=0;i<n;i++) {
			Arrays.fill(visit[i], -1);
		}
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		Integer[] in = new Integer[2];
		in[0] = sx - 1; in[1] = sy - 1;
		q.add(in);
		visit[sx - 1][sy - 1] = 0;
		while(!q.isEmpty()) {
			Integer[] cur = q.poll();
			if(cur[0]==ex-1&&cur[1]==ey-1) {
				System.out.println(visit[ex-1][ey-1]);
				return;
			}
			for(int d=0;d<4;d++) {
				for(int kk=1;kk<=k;kk++) {
					int nx = cur[0] + dx[d] * kk;
					int ny = cur[1] + dy[d] * kk;
					if(nx<0 || nx >= n || ny < 0 || ny >= m || map[nx][ny]=='#')
						break;
					if(nx>=0 && nx<n && ny>=0 && ny<m &&
						map[nx][ny]=='.' && visit[nx][ny]==-1) {
						visit[nx][ny] = visit[cur[0]][cur[1]] + 1;
						Integer[] next = new Integer[2];
						next[0] = nx; next[1] = ny;
						q.add(next);
					}
				}
			}
		}
		System.out.println(visit[ex-1][ey-1]);
	}
}
