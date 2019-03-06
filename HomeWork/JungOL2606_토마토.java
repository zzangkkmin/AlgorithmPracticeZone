package com.ssafy.git.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JungOL2606_토마토 {
	public static String[] line;
	public static int m,n,h;
	public static int[][][] box;
	public static int[][][] visited;
	public static int[] dx = {0,1,0,-1,0,0};
	public static int[] dy = {1,0,-1,0,0,0};
	public static int[] dz = {0,0,0,0,1,-1};
	public static Queue<tomato> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//line = br.readLine().trim().split(" ");
		//m = Integer.parseInt(line[0]);
		//n = Integer.parseInt(line[1]);
		//h = Integer.parseInt(line[2]);
		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
				
		
		box = new int[h][n][m];
		visited = new int[h][n][m];
		int size = m*n*h;
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				//line = br.readLine().trim().split(" ");
				for(int k=0;k<m;k++) {
					//box[i][j][k] = Integer.parseInt(line[k]);
					box[i][j][k] = sc.nextInt();
					visited[i][j][k] = -1;
					if(box[i][j][k] == 1) {
						q.add(new tomato(j, k, i));
						visited[i][j][k] = 0;
					}
					else if(box[i][j][k] == -1) {
						size--;
					}
				}
			}
		}
		find(size);
	}
	public static boolean inrange(int hh, int xx, int yy) {
		if(hh>=0&&hh<h&&xx>=0&&xx<n&&yy>=0&&yy<m) {
			return true;
		}
		else
			return false;
	}
	public static void find(int size) {
		int cnt = 0; int ans = -1;
		while(!q.isEmpty()) {
			tomato cur = q.poll();
			cnt++;
			ans = ans < visited[cur.z][cur.x][cur.y] ? visited[cur.z][cur.x][cur.y] : ans;
			for(int d = 0; d< 6;d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				int nz = cur.z + dz[d];
				if(inrange(nz,nx,ny) && box[nz][nx][ny] != -1 && visited[nz][nx][ny] == -1) {
					q.add(new tomato(nx, ny, nz));
					visited[nz][nx][ny] = visited[cur.z][cur.x][cur.y] + 1;
				}
			}
		}
		if(cnt != size) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
	static class tomato{
		int x; int y; int z;
		public tomato(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
