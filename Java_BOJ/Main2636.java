package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2636 {
	public static String[] line;
	public static int[][] map, origin, visit;
	public static int n,m,maxx,ans;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static Queue<Integer[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		//n = sc.nextInt();
		//m = sc.nextInt();
		map = new int[n][m];
		origin = new int[n][m];
		visit = new int[n][m];
		for(int i=0;i<n;i++) {
			line = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				origin[i][j] = Integer.parseInt(line[j]);
				//origin[i][j] = sc.nextInt();
				map[i][j] = origin[i][j];
				visit[i][j] = -1;
			}
		}
		//
		q.add(new Integer[] {0,0});
		visit[0][0] = 0;
		operate();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visit[i][j] == maxx && origin[i][j] == 1) {
					ans++;
				}
			}
		}
		System.out.println(maxx+"\n"+ans);
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<n&&y>=0&&y<m) {
			return true;
		}
		else
			return false;
	}
	public static void operate() {
		Queue<Integer[]> opQ = new LinkedList<>();
		while(!q.isEmpty()) {
			Integer[] cur = q.poll();
			int curDate = visit[cur[0]][cur[1]];
			maxx = maxx < curDate ? curDate : maxx;
			for(int d = 0;d<4;d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(inrange(nx,ny) && map[nx][ny] == 0 && visit[nx][ny] == -1) {
					q.add(new Integer[] {nx,ny});
					visit[nx][ny] = curDate;
				}
				else if(inrange(nx,ny) && map[nx][ny] == 1 && visit[nx][ny] == -1) {
					opQ.add(new Integer[] {nx,ny});
					visit[nx][ny] = curDate + 1;
				}
			}
		}
		while(!opQ.isEmpty()) {
			Integer[] cur = opQ.poll();
			map[cur[0]][cur[1]] = 0;
			q.add(cur);
		}
		if(q.isEmpty()) {
			return;
		}
		operate();
	}
}
