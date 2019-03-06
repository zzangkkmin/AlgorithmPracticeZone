package com.ssafy.git.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_보물지도 {
	public static int n,x,y,p, dn;
	public static String[] line;
	public static int[][] map;
	public static int[] dx = {0,-1,-1,0,1,1,1,0,-1};//1~8 idx
	public static int[] dy = {0,0,1,1,1,0,-1,-1,-1};//1~8 idx
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			line = br.readLine().trim().split(" ");
			n = Integer.parseInt(line[0]);
			x = Integer.parseInt(line[1]);
			y = Integer.parseInt(line[2]);
			p = Integer.parseInt(line[3]);
			map = new int[n+1][n+1];
			line = br.readLine().trim().split(" ");
			for(int i=0;i<p;i++) {
				map[Integer.parseInt(line[i*2])][Integer.parseInt(line[i*2+1])] = -1;
			}
			dn = Integer.parseInt(br.readLine().trim());
			line = br.readLine().trim().split(" ");
			for(int i=0;i<dn;i++) {
				int dir = Integer.parseInt(line[i*2]);
				int dlen = Integer.parseInt(line[i*2+1]);
				x = x + dx[dir]*dlen;
				y = y + dy[dir]*dlen;
				if(x<1||x>n||y<1||y>n||map[x][y]==-1) {
					x = 0; y = 0;
					break;
				}
			}
			System.out.println("#"+t+" "+x+" "+y);
		}
	}	

}
