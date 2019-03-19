package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.Messaging.SyncScopeHelper;

public class Solution1865_D4_동철이_일분배 {
	public static int n;
	public static boolean find = false;
	public static double ans;
	public static String[] line;
	public static double[][] map;
	public static boolean[] selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = 0; find = false;
			n = Integer.parseInt(br.readLine().trim());
			map = new double[n][n];
			selected = new boolean[n];
			for(int i=0;i<n;i++) {
				line = br.readLine().trim().split(" ");
				for(int j=0;j<n;j++) {
					map[i][j] = (double) Integer.parseInt(line[j]) / 100.0;
				}
			}
			for(int i=0;i<n;i++) {
				selected[i] = true;
				select(1, map[0][i]);
				selected[i] = false;
			}
			System.out.print("#"+t+" ");
			System.out.printf("%.6f\n",ans);
		}
	}
	public static void select(int idx, double status) {
		if(idx==n) {
			ans = ans < status*100 ? status*100 : ans;
			find = true;
			return;
		}
		else {
			for(int i = 0; i < n; i++) {
				if(selected[i]==false && status*map[idx][i]*100 > ans) {
					selected[i] = true;
					select(idx+1, status*map[idx][i]);
					selected[i] = false;
				}
			}
		}
	}
}
