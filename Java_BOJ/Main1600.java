package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1600 {
	public static int k, w, h;
	public static String[] line;
	public static int[][] map; 
	public static int[][][] visit;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static int[] kx = {1,2,2,1,-1,-2,-2,-1};
	public static int[] ky = {2,1,-1,-2,-2,-1,1,2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine().trim());
		line = br.readLine().trim().split(" ");
		w = Integer.parseInt(line[0]);
		h = Integer.parseInt(line[1]);
		map = new int[h][w];
		visit = new int[k+1][h][w];
		for(int i=0;i<h;i++) {
			line = br.readLine().trim().split(" ");
			for(int j=0;j<w;j++) {
				map[i][j] = Integer.parseInt(line[j]);
				for(int kk=0;kk<=k;kk++) {
					visit[kk][i][j] = -1;
				}
			}
		}
		System.out.println(find());
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<h&&y>=0&&y<w) {
			return true;
		}
		else
			return false;
	}
	public static int find() {
		Queue<Integer> q = new LinkedList<>();
		//Queue<Integer> kq = new LinkedList<>();
		visit[0][0][0] = 0;
		q.add(0);// kq.add(0);
		while(!q.isEmpty()) {
			int cur = q.poll();
			int ck = cur / (w*h);
			cur = cur % (w*h);
			int cx = cur / w;
			int cy = cur % w;
			if(cx==h-1 && cy==w-1) {
				return visit[ck][cx][cy];
			}
			for(int d=0;d<4;d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if(inrange(nx,ny) && map[nx][ny] == 0 && visit[ck][nx][ny] == -1) {
					visit[ck][nx][ny] = visit[ck][cx][cy]+1;
					q.add(ck*(w*h)+nx*w+ny);
				}
			}
			if(ck!=k) {
				for(int d=0;d<8;d++) {
					int nx = cx + kx[d];
					int ny = cy + ky[d];
					int nk = ck + 1;
					if(inrange(nx,ny) && map[nx][ny] == 0 && visit[ck][nx][ny] == -1) {
						visit[nk][nx][ny] = visit[ck][cx][cy]+1;
						q.add(nk*(w*h)+nx*w+ny); 
					}
				}
			}
		}
		return -1;
	}
}
