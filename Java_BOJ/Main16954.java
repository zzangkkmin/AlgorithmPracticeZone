package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main16954 {
	public static int ex,ey;
	public static int[] dx = {0,0,1,1,1,0,-1,-1,-1};
	public static int[] dy = {0,1,1,0,-1,-1,-1,0,1};
	public static char[][] map = new char[8][8];
	public static String line;
	public static Queue <Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ex = 0; ey = 7;
		q.add(7*8+0);
		int pcnt = 1; int wcnt = 0;
		for(int i=0;i<8;i++) {
			line = br.readLine().trim();
			for(int j=0;j<8;j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '#') {
					q.add(i*8+j);
					wcnt++;
				}
			}
		}
		System.out.println(find(pcnt,wcnt));
	}
	public static boolean inrange(int x, int y) {
		if(x>=0 && x<8 && y>=0 && y<8) {
			return true;
		}
		else
			return false;
	}
	public static int find(int pcnt, int wcnt) {

		while(!q.isEmpty()) {
			int playerSize = pcnt;
			if(playerSize == 0) {
				return 0;
			}
			pcnt = 0;
			for(int i=0;i<playerSize;i++) {
				int curPlayer = q.poll();
				if((curPlayer/8 == ex && curPlayer%8 >= 0 && curPlayer%8 < 8)) {
					return 1;
				}
				else if(map[curPlayer/8][curPlayer%8] == '#') {
					continue;
				}
				for(int d = 0; d<9; d++) {
					int nx = curPlayer/8 + dx[d];
					int ny = curPlayer%8 + dy[d];
					if(inrange(nx,ny) && map[nx][ny] == '.') {
						q.add(nx*8+ny);
						pcnt++;
					}
				}
			}
			Queue <Integer> wq = new LinkedList<>();
			int wallSize = wcnt;
			if(wallSize == 0) {
				return 1;
			}
			wcnt = 0;
			for(int i=0;i<wallSize;i++) {
				int curWall = q.poll();
				int nx = curWall/8 + 1;
				int ny = curWall%8;
				if(inrange(nx,ny)) {
					map[curWall/8][curWall%8] = '.';
					q.add(nx*8+ny);
					wq.add(nx*8+ny);
					wcnt++;
				}
				else {
					map[curWall/8][curWall%8] = '.';
				}
			}
			while(!wq.isEmpty()) {
				int nextWall = wq.poll();
				map[nextWall/8][nextWall%8] = '#';
			}
		}
		return 0;
	}
}
