package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1868_D4_파핑파핑지뢰찾기 {
	public static int n,zone, restZone;
	public static String line;
	public static char[][] map;
	public static int[][] visit;
	public static int[] dx = {0,1,1,1,0,-1,-1,-1};
	public static int[] dy = {1,1,0,-1,-1,-1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			zone = 0; restZone = 0;
			n = Integer.parseInt(br.readLine().trim());
			map = new char[n][n];
			visit = new int[n][n];
			for(int i=0;i<n;i++) {
				line = br.readLine().trim();
				map[i] = line.toCharArray();
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] == '.') {
						mineCheck(i,j);
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] == '.' && visit[i][j] == 0) {
						EmpCheck(i, j, ++zone);
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] != '*' && visit[i][j] == 0) {
						restZone++;
					}
				}
			}
			
			System.out.println("#"+t+" "+(zone+restZone));
		}
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<n&&y>=0&&y<n) {
			return true;
		}
		else
			return false;
	}
	public static void mineCheck(int x, int y) {
		int chk = 0;
		for(int d=0;d<8;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(inrange(nx,ny) && map[nx][ny] == '*') {
				chk++;
			}
		}
		if(chk != 0) {
			map[x][y] = (char)('0' + chk);
		}
		
	}
	public static void EmpCheck(int x, int y, int zone) {
		Queue<Integer[]> empQ = new LinkedList<>();
		empQ.add(new Integer[] {x,y});
		visit[x][y] = zone;
		while(!empQ.isEmpty()) {
			Integer[] cur = empQ.poll();			
			if(map[cur[0]][cur[1]] >= '1' && map[cur[0]][cur[1]] <= '8') {
				continue;
			}
			for(int d = 0; d < 8;d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(inrange(nx,ny) && map[nx][ny] != '*' && visit[nx][ny] == 0) {
					empQ.add(new Integer[] {nx,ny});
					visit[nx][ny] = zone;
				}
			}
		}
	}
}
