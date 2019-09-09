package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main2075 {
	public static int n;
	public static int[][] map;
	public static int[] mapIdx;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
	}

}
