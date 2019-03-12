package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution7250_D4_탈출 {
	public static int n,m,k, ex, ey;
	public static String[] line;
	public static String mapline;
	public static char[][] map;
	public static int[][] scotVisit;
	public static int[][] vilVisit;
	public static Queue<Integer[]> scotQ;
	public static Queue<Integer> vilQ;
	public static Queue<Integer> fireQ;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			line = br.readLine().trim().split(" ");
			n = Integer.parseInt(line[0]);
			m = Integer.parseInt(line[1]);
			k = Integer.parseInt(line[2]);
			
			map = new char[n][m];
			scotVisit = new int[n][m];
			vilVisit = new int[n][m];
			scotQ = new LinkedList<>();
			vilQ = new LinkedList<>();
			fireQ = new LinkedList<>();
			
			for(int i=0;i<n;i++) {
				Arrays.fill(scotVisit[i], -1);
				Arrays.fill(vilVisit[i], -1);
				mapline = br.readLine().trim();
				for(int j=0;j<m;j++) {
					map[i][j] = mapline.charAt(j);
					if(map[i][j] == 'S') {
						scotQ.add(new Integer[] { i*m+j, 0 });
						scotVisit[i][j] = 0;
					}
					else if(map[i][j] == 'V') {
						vilQ.add(i*m+j);
						vilVisit[i][j] = 0;
					}
					else if(map[i][j] == 'F') {
						fireQ.add(i*m+j);
					}
					else if(map[i][j] == 'E') {
						ex = i; ey = j;
					}
				}
			}
			System.out.println("#"+t+" "+move());
		}
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<n&&y>=0&&y<m) {
			return true;
		}
		else
			return false;
	}
	public static int move() {
		while(true) {
			//1.fire
			int fireQsize = fireQ.size();
			for(int f = 0; f < fireQsize; f++) {
				int curFire = fireQ.poll();
				int cx = curFire / m;
				int cy = curFire % m;
				for(int d=0;d<4;d++) {
					int nx = cx + dx[d];
					int ny = cy + dy[d];
					if(inrange(nx,ny) && map[nx][ny] != 'E' && map[nx][ny] != 'W' && map[nx][ny] != 'X' && map[nx][ny] != 'F') {
						map[nx][ny] = 'F';
						fireQ.add(nx*m+ny);
					}
				}
			}
			//2.villian
			int vilQsize = vilQ.size();
			for(int v = 0; v < vilQsize; v++) {
				int curVil = vilQ.poll();
				int cx = curVil / m;
				int cy = curVil % m;
				if(cx == ex && cy == ey) {
					return -1;
				}
				for(int d=0;d<4;d++) {
					int nx = cx + dx[d];
					int ny = cy + dy[d];
					if(inrange(nx,ny) && map[nx][ny] != 'W' && map[nx][ny] != 'X' && vilVisit[nx][ny] == -1) {
						vilQ.add(nx*m+ny);
						vilVisit[nx][ny] = vilVisit[cx][cy] + 1;
					}
				}
			}
			//3.scot
			int scotQsize = scotQ.size();
			if(scotQsize==0) {
				return -1;
			}
			for(int s = 0; s < scotQsize; s++) {
				Integer[] curScot = scotQ.poll();
				int cx = curScot[0] / m;
				int cy = curScot[0] % m;
				if(cx == ex && cy == ey) {
					return scotVisit[cx][cy];
				}
				int ck = curScot[1];
				for(int d=0;d<4;d++) {
					int nx = cx + dx[d];
					int ny = cy + dy[d];
					if(inrange(nx,ny) && scotVisit[nx][ny] == -1) {
						if(map[nx][ny] == 'A' || (nx == ex && ny == ey)) {
							//if(ck != 0) {
								//문제가 되는 부분
							//	scotQ.add(new Integer[] {nx*m+ny, 0 });
							//	scotVisit[nx][ny] = scotVisit[cx][cy] + 1;
							//	scotVisit[cx][cy] = -1;
							//}
							//else {
								scotQ.add(new Integer[] {nx*m+ny, 0 });
								scotVisit[nx][ny] = scotVisit[cx][cy] + 1;
							//}
						}
						else if(map[nx][ny] == 'W') {
							//문제가 되는 부분
							if(ck==k) {
								continue;
							}
							//scotQ.add(new Integer[] {nx*m+ny, ck+1 });
							scotVisit[nx][ny] = scotVisit[cx][cy] + 1;
							scotQ.add(new Integer[] {nx*m+ny, ck+1 });
							scotVisit[nx][ny] = -1;
						}
					}
				}
			}
		}
	}
	
}
