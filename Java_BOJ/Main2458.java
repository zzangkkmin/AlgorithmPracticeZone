package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2458 {
	public static int n,m, ans;
	public static int INF = 9999999;
	public static String[] line;
	public static int[][] map;
	public static int[] connected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new int[n+1][n+1];
		connected = new int[n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j] = INF;
			}
		}
		for(int i=0;i<m;i++) {
			line = br.readLine().trim().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			map[a][b] = 1;
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i==j) continue;
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j] != INF) {
					connected[i]++;
					connected[j]++;
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			if(connected[i] == n-1) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
