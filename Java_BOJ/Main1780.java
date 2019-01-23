package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1780 {
	public static int minus = 0;
	public static int zero = 0;
	public static int one = 0;
	public static int confirm(int[][] map, int x, int y, int n) {
		boolean z = false, m = false, o = false;
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(map[i][j] == -1) {
					m = true;
				}
				else if(map[i][j] == 0) {
					z = true;
				}
				else if(map[i][j] == 1) {
					o = true;
				}
				if((z&&m) || (z&&o) || (m&&o) ) {
					return -2;
				}
			}
		}
		if(m)
			return -1;
		else if(z)
			return 0;
		else if(o)
			return 1;
		return -2;
	}
	public static void solve(int[][] map, int x, int y, int n) {
		int ret = confirm(map, x, y, n);
		if(ret == -1) {
			minus++;
		}
		else if(ret == 0) {
			zero++;
		}
		else if(ret == 1) {
			one++;
		}
		else {
			solve(map,x,y,n/3);
			solve(map,x,y+n/3,n/3);
			solve(map,x,y+n/3+n/3,n/3);
			solve(map,x+n/3,y,n/3);
			solve(map,x+n/3,y+n/3,n/3);
			solve(map,x+n/3,y+n/3+n/3,n/3);
			solve(map,x+n/3+n/3,y,n/3);
			solve(map,x+n/3+n/3,y+n/3,n/3);
			solve(map,x+n/3+n/3,y+n/3+n/3,n/3);
		}
	}
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		solve(map, 0, 0, n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
		
	}

}
