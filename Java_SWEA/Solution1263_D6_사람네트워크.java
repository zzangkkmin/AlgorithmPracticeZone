package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution1263_D6_사람네트워크 {
	public static String[] line;
	public static int n;
	public static int[][] map , d;
	public static int[] cc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			line = br.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			map = new int[n+1][n+1];
			d = new int[n+1][n+1];
			cc = new int[n+1];
			int idx = 1;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					map[i][j] = Integer.parseInt(line[idx]);
					d[i][j] = map[i][j];
					if(i==j) {
						d[i][j] = 0;
					}
					else if(d[i][j] == 0) {
						d[i][j] = 999999999;
					}
					idx++;
				}
			}
			for(int k=1;k<=n;k++) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
					}
				}
			}
			int minimum = Integer.MAX_VALUE;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					cc[i] += d[i][j];
				}
				if(minimum > cc[i]) {
					minimum = cc[i];
				}
			}
			System.out.println("#"+t+" "+minimum);
		}
	}	

}




/*
2
3 0 1 0 1 0 1 0 1 0
4 0 0 1 0 0 0 1 0 1 1 0 1 0 0 1 0
*/
