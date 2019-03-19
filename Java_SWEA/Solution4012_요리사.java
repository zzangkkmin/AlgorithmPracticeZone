package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4012_요리사 {
	public static int n, ans;
	public static int[][] map;
	public static String[] linez;
	public static boolean[] selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine().trim());
			map = new int[n][n];
			selected = new boolean[n];
			for(int i=0;i<n;i++) {
				linez = br.readLine().trim().split(" ");
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(linez[j]);
				}
			}
			selectCook(0, 0);
			System.out.println("#"+t+" "+ans);
		}
	}
	public static void combiCook() {
		int[][] list = new int[2][n/2];
		int Atrue = 0; int Bfalse = 0;
		int Asum = 0; int Bsum = 0;
		for(int i=0;i<n;i++) {
			if(selected[i]) {
				list[0][Atrue] = i;
				Atrue++;
			}
			else {
				list[1][Bfalse] = i;
				Bfalse++;
			}
		}
		for(int i=0;i<n/2;i++) {
			for(int j=i+1;j<n/2;j++) {
				Asum += map[list[0][i]][list[0][j]] + map[list[0][j]][list[0][i]];
				Bsum += map[list[1][i]][list[1][j]] + map[list[1][j]][list[1][i]];
			}
		}
		int res = Math.abs(Asum-Bsum);
		ans = ans > res ? res : ans;
	}
	public static void selectCook(int idx, int len) {
		if(len == n/2) {
			combiCook();
		}
		else {
			for(int i = idx; i < n; i++) {
				if(!selected[i]) {
					selected[i] = true;
					selectCook(i,len+1);
				}
			}
		}
		selected[idx] = false;
	}
}
