package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1992 {
	public static int filled(int[][] map, int n, int x, int y) {
		int zero = 0, one = 0;
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(zero==1&&one==1) {
					return -1;
				}
				if(map[i][j]==1) {
					one = 1;
				}
				else {
					zero = 1;
				}
			}
		}
		if(zero == 1 && one == 0) {
			return 0;
		}
		else if(one == 1 && zero == 0){
			return 1;
		}
		return -1;
	}
	public static void confirm(int[][] map, int n, int x, int y) {
		int ret = filled(map,n,x,y);
		if(ret==-1) {
			System.out.print("(");
			confirm(map,n/2,x,y);
			confirm(map,n/2,x,y+n/2);
			confirm(map,n/2,x+n/2,y);
			confirm(map,n/2,x+n/2,y+n/2);
			System.out.print(")");
		}
		else
			System.out.print(ret);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++) {
			char[] line = br.readLine().trim().toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j] = line[j] - '0';
			}
		}
		confirm(map,n,0,0);
	}

}
