package com.ssafy.git.Java_BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main17069 {
	public static int n;
	public static long ans;
	public static int[][] map;
	public static long[][][] d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n+1][n+1];
		d = new long[3][n+1][n+1];
		Arrays.fill(map[0], 1);
		for(int i=1;i<=n;i++) {
			Arrays.fill(map[i], 1);	
			for(int j=1;j<=n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		d[0][1][2] = 1;
		for(int i=1;i<=n;i++) {
			for(int j=2;j<=n;j++) {
				if(i==1&&j==2) continue;
				if(map[i][j]==0){
					//case 0: 가로
					if(map[i][j-1] == 0){
						d[0][i][j] = d[0][i][j-1] + d[1][i][j-1];
					}
					//case 1: 대각선
					if(map[i][j-1] == 0 && map[i-1][j-1] == 0 && map[i-1][j] == 0){
						d[1][i][j] = d[0][i-1][j-1] + d[1][i-1][j-1] + d[2][i-1][j-1];
					}
					//case 2: 세로
					if(map[i-1][j] == 0){
						d[2][i][j] = d[1][i-1][j] + d[2][i-1][j];
					}
				}
			}
		}
		
		ans = d[0][n][n] + d[1][n][n] + d[2][n][n];
		System.out.println(ans);
	}
	
}
