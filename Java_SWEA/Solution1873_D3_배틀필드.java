package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1873_D3_배틀필드 {
	public static String[] line;
	public static char[][] map;
	public static int h,w,n;
	public static int tx,ty,td;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			line = br.readLine().split(" ");
			h = Integer.parseInt(line[0]);
			w = Integer.parseInt(line[1]);
			map = new char[h][w];
			for(int i=0;i<h;i++) {
				String linez = br.readLine().trim();
				for(int j=0;j<w;j++) {
					map[i][j] = linez.charAt(j);
					if(map[i][j]=='^' ||map[i][j]=='<' ||map[i][j]=='>' ||map[i][j]=='v') {
						//tank-init
						tankInit(i,j,map[i][j]);
					}
				}
			}
			n = Integer.parseInt(br.readLine().trim());
			String comm = br.readLine().trim();
			for(int i=0;i<comm.length();i++) {
				operate(comm.charAt(i));
			}
			System.out.print("#"+t+" ");
			for(int i=0;i<h;i++) {
				System.out.println(map[i]);
			}
		}
	}
	public static void tankInit(int x, int y, char dir) {
		tx = x; ty = y;
		if(dir=='>') {
			td = 0;
		}
		else if(dir=='v') {
			td = 1;
		}
		else if(dir=='<') {
			td = 2;
		}
		else if(dir=='^') {
			td = 3;
		}
	}
	public static void operate(char comm) {
		if(comm=='U' ||comm=='D' ||comm=='L' ||comm=='R') {
			move(comm);
		}
		else {
			shoot(tx,ty,td);
		}
	}
	public static void move(char comm) {
		int nx = tx; int ny = ty;
		char nt = map[tx][ty];
		if(comm=='U') {//up
			nx = tx + dx[3];
			ny = ty + dy[3];
			nt = '^';
			if(inrangeMap(nx, ny) && inrangeMove(nx, ny)) {
				map[tx][ty] = '.';
				map[nx][ny] = nt;
				tx = nx; ty = ny; td = 3;
			}
			else {
				map[tx][ty] = nt;
				td = 3;
			}
		}
		else if(comm=='D') {//down
			nx = tx + dx[1];
			ny = ty + dy[1];
			nt = 'v';
			if(inrangeMap(nx, ny) && inrangeMove(nx, ny)) {
				map[tx][ty] = '.';
				map[nx][ny] = nt;
				tx = nx; ty = ny; td = 1;
			}
			else {
				map[tx][ty] = nt;
				td = 1;
			}
		}
		else if(comm=='L') {//left
			nx = tx + dx[2];
			ny = ty + dy[2];
			nt = '<';
			if(inrangeMap(nx, ny) && inrangeMove(nx, ny)) {
				map[tx][ty] = '.';
				map[nx][ny] = nt;
				tx = nx; ty = ny; td = 2;
			}
			else {
				map[tx][ty] = nt;
				td = 2;
			}
		}
		else if(comm=='R') {//right
			nx = tx + dx[0];
			ny = ty + dy[0];
			nt = '>';
			if(inrangeMap(nx, ny) && inrangeMove(nx, ny)) {
				map[tx][ty] = '.';
				map[nx][ny] = nt;
				tx = nx; ty = ny; td = 0;
			}
			else {
				map[tx][ty] = nt;
				td = 0;
			}
		}
	}
	public static void shoot(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		if(inrangeMap(nx, ny) == false || map[nx][ny] == '#') {
			return;
		}
		else if(map[nx][ny] == '*') {
			map[nx][ny] = '.';
		}
		else if(map[nx][ny] == '.' || map[nx][ny] == '-') {
			shoot(nx,ny,d);
		}
	}
	public static boolean inrangeMap(int x, int y) {
		if (x >= 0 && x < h && y >= 0 && y < w) {
			return true;
		}
		else
			return false;
	}
	public static boolean inrangeMove(int x, int y) {
		if (map[x][y] == '*' || map[x][y] == '#' || map[x][y] == '-') {
			return false;
		}
		else
			return true;
	}
}
