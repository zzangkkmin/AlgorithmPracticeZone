package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main16958 {
	public static int n,t,m;
	public static int[][] vertax;
	public static int[][] map;
	public static String[] lines;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		lines =  br.readLine().trim().split(" ");
		n = Integer.parseInt(lines[0]);
		t = Integer.parseInt(lines[1]);
		
		map = new int[n+1][n+1];
		vertax = new int[n+1][3];
		
		for(int i=1;i<=n;i++) {
			lines =  br.readLine().trim().split(" ");
			vertax[i][0] = Integer.parseInt(lines[0]);//special
			vertax[i][1] = Integer.parseInt(lines[1]);//X
			vertax[i][2] = Integer.parseInt(lines[2]);//Y
		}
		//dist
		findDist();
		//
		m = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<m;i++) {
			lines =  br.readLine().trim().split(" ");
			int a = Integer.parseInt(lines[0]);
			int b = Integer.parseInt(lines[1]);
			System.out.println(map[a][b]);
		}
	}
	public static int distance(int a, int b) {
		if(vertax[a][0] == 1 && vertax[b][0] == 1) {
			int d = Math.abs(vertax[a][1] - vertax[b][1]) + Math.abs(vertax[a][2] - vertax[b][2]);
			d = d > t ? t : d;
			return d;
		}
		else {
			int d = Math.abs(vertax[a][1] - vertax[b][1]) + Math.abs(vertax[a][2] - vertax[b][2]);
			return d;
		}
	}

	public static void findDist() {
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=n;j++) {
				map[i][j] = distance(i,j);
				map[j][i] = map[i][j];
			}
		}
		for(int k=1;k<=n;k++) {
			for(int i=1;i<n;i++) {
				for(int j=i+1;j<=n;j++) {
					if(i!=k && j!=k && i!=j) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
						map[j][i] = map[i][j];
					}
				}
			}
		}
	}
}
