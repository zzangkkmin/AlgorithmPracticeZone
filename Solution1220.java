package com.ssafy.algo;

import java.util.Scanner;

public class Solution1220 {
	public static int magnatic(int[][] map, int x, int y, int n){
		//n to s
		if(map[x][y] == 1){
			for(int i=x+1;i<n;i++){
				if(map[i][y] == 1){
					return 0;
				}
				else if(map[i][y] == 2){
					return 1;
				}
			}
			return 0;
		}
		//s to n
		else{
			for(int i=x-1;i>=0;i--){
				if(map[i][y] == 2){
					return 0;
				}
				else if(map[i][y] == 1){
					return 1;
				}
			}
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++){
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					map[i][j] = sc.nextInt();
				}
			}
			
			int Ans = 0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(map[i][j] != 0){
						Ans += magnatic(map, i, j, n);
					}
				}
			}
			System.out.println("#" + t + " " + Ans);
		}
	}

}
