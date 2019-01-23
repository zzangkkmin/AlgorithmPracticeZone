package com.ssafy.algo;

import java.util.Scanner;

public class Solution1209 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++){
			int tt = sc.nextInt();
			int n = 100;
			int[][] map = new int[n][n];
			int[] col = new int[n];
			int[] row = new int[n];
			int l1 = 0;//i==j
			int l2 = 0;//i+j==n-1
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					map[i][j] = sc.nextInt();
					col[i] += map[i][j];
					row[j] += map[i][j];
					if(i==j){
						l1 += map[i][j];
					}
					if(i+j==n-1){
						l2 += map[i][j];
					}
				}
			}
			
			int Ans = l1 < l2 ? l2 : l1;
			for(int i=0;i<n;i++){
				Ans = Ans < col[i] ? col[i] : Ans;
				Ans = Ans < row[i] ? row[i] : Ans;
			}
			System.out.println("#" + t + " " + Ans);
		}
	}

}
