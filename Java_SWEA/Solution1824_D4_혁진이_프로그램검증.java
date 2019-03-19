package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1824_D4_혁진이_프로그램검증 {
	public static int r,c;//2~20
	public static String[] linez;
	public static String line;
	public static char[][] map;
	public static boolean[][][][] visit;
	public static Queue<cursor> q = new LinkedList<>();
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			q.clear();
			linez = br.readLine().trim().split(" ");
			r = Integer.parseInt(linez[0]);
			c = Integer.parseInt(linez[1]);
			map = new char[r][c];
			visit = new boolean[16][4][r][c];
			for(int i=0;i<r;i++) {
				line = br.readLine().trim();
				for(int j=0;j<c;j++) {
					map[i][j] = line.charAt(j);
				}
			}
			if(move()==true) {
				System.out.println("#"+t+" "+"YES");
			}
			else {
				System.out.println("#"+t+" "+"NO");
			}
		}
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<r&&y>=0&&y<c) {
			return true;
		}
		else return false;
	}
	public static void validCheck(int cx, int cy, int dir, int cm) {
		int nx = cx + dx[dir];
		int ny = cy + dy[dir];
		if(inrange(nx,ny) && visit[cm][dir][nx][ny] == false) {
			q.add(new cursor(nx, ny, dir, cm));
			visit[cm][dir][nx][ny] = true;
		}
		else if(inrange(nx,ny)==false) {
			if(dir == 0) {
				ny = 0;
			}
			else if(dir == 1){
				nx = 0;
			}
			else if(dir == 2){
				ny = c - 1;
			}
			else if(dir == 3){
				nx = r - 1;
			}
			if(visit[cm][dir][nx][ny] == false) {
				q.add(new cursor(nx, ny, dir, cm));
				visit[cm][dir][nx][ny] = true;
			}
		}
		
	}
	public static boolean move() {
		
		int cx = 0; int cy = 0;
		int cd = 0; int cn = 0;
		
		q.add(new cursor(cx,cy,cd,cn));
		visit[cn][cd][cx][cy] = true;
		while(!q.isEmpty()) {
			cursor cur = q.poll();
			if(map[cur.x][cur.y]== '@') {
				return true;
			}
			else if(map[cur.x][cur.y]== '<') {
				int nd = 2;
				validCheck(cur.x, cur.y, nd, cur.mem);
			}
			else if(map[cur.x][cur.y]== '>') {
				int nd = 0;
				validCheck(cur.x, cur.y, nd, cur.mem);
			}
			else if(map[cur.x][cur.y]== '^') {
				int nd = 3;
				validCheck(cur.x, cur.y, nd, cur.mem);
			}
			else if(map[cur.x][cur.y]== 'v') {
				int nd = 1;
				validCheck(cur.x, cur.y, nd, cur.mem);
			}
			else if(map[cur.x][cur.y]== '_') {
				int nd = cur.dir;
				if(cur.mem == 0) {
					nd = 0;
				}
				else {
					nd = 2;
				}
				validCheck(cur.x, cur.y, nd, cur.mem);
			}
			else if(map[cur.x][cur.y]== '|') {
				int nd = cur.dir;
				if(cur.mem == 0) {
					nd = 1;
				}
				else {
					nd = 3;
				}
				validCheck(cur.x, cur.y, nd, cur.mem);
			}
			else if(map[cur.x][cur.y]== '+') {
				int nm = cur.mem;
				if(cur.mem == 15) {
					nm = 0;
				}
				else {
					nm = cur.mem + 1;
				}
				validCheck(cur.x, cur.y, cur.dir, nm);
			}
			else if(map[cur.x][cur.y]== '-') {
				int nm = cur.mem;
				if(cur.mem == 0) {
					nm = 15;
				}
				else {
					nm = cur.mem - 1;
				}
				validCheck(cur.x, cur.y, cur.dir, nm);
			}
			else if(map[cur.x][cur.y]>= '0' && map[cur.x][cur.y]<= '9') {
				int nm = map[cur.x][cur.y] - '0';
				validCheck(cur.x, cur.y, cur.dir, nm);
			}
			else if(map[cur.x][cur.y]== '?') {
				for(int d=0;d<4;d++) {
					validCheck(cur.x, cur.y, d, cur.mem);
				}
				
			}
			else {
				validCheck(cur.x, cur.y, cur.dir, cur.mem);
			}
		}

		return false;
	}
	public static class cursor{
		int x; int y; int dir; int mem;

		public cursor(int x, int y, int dir, int mem) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.mem = mem;
		}
	}
}
