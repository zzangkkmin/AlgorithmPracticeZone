package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16971 {
	public static String[] line;
	public static int n,m, max;
	public static int[][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		//origin maxB
		max = -5000;
		confirm();
		select();
		System.out.println(max);
	}
	public static void confirm() {
		int sum = 0;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-1;j++) {
				int temp = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i][j+1];
				sum += temp;
			}
		}
		max = max < sum ? sum : max;
	}
	public static void select() {
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=0;k<m;k++) {
					int change = map[i][k];
					map[i][k] = map[j][k];
					map[j][k] = change;
				}
				confirm();
				for(int k=0;k<m;k++) {
					int back = map[i][k];
					map[i][k] = map[j][k];
					map[j][k] = back;
				}
			}
		}
		for(int i=0;i<m-1;i++) {
			for(int j=i+1;j<m;j++) {
				for(int k=0;k<n;k++) {
					int change = map[k][i];
					map[k][i] = map[k][j];
					map[k][j] = change;
				}
				confirm();
				for(int k=0;k<n;k++) {
					int back = map[k][i];
					map[k][i] = map[k][j];
					map[k][j] = back;
				}
			}
		}
	}
}
