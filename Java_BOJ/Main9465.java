package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9465 {
	public static int n;
	public static int[][] sticker, d;
	public static String[] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			n = Integer.parseInt(br.readLine().trim());
			sticker = new int[n+1][2];
			d = new int[n+1][3];
			line = br.readLine().split(" ");
			for(int i=1;i<=n;i++) {
				sticker[i][0] = Integer.parseInt(line[i-1]);
			}
			line = br.readLine().split(" ");
			for(int i=1;i<=n;i++) {
				sticker[i][1] = Integer.parseInt(line[i-1]);
			}
			//
			for(int i=1;i<=n;i++) {
				d[i][0] = Math.max(d[i-1][1], d[i-1][2]) + sticker[i][0];
				d[i][1] = Math.max(d[i-1][0], d[i-1][2]) + sticker[i][1];
				d[i][2] = Math.max(Math.max(d[i-1][0], d[i-1][1]), d[i-1][2]);
			}
			int ans = Math.max(Math.max(d[n][0], d[n][1]), d[n][2]);
			System.out.println(ans);
		}
	}

}
