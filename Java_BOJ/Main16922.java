package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main16922 {
	public static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		find();
	}
	public static void find() {
		int[][] d = new int[n+1][4];
		d[1][0] = d[1][1] = d[1][2] = d[1][3] = 1;
		for(int i=2;i<=n;i++) {
			d[i][0] = d[i-1][0] + d[i-1][1] + d[i-1][2] + d[i-1][3];
			d[i][1] = d[i-1][1] + d[i-1][2] + d[i-1][3];
			d[i][2] = d[i-1][2] + d[i-1][3];
			d[i][3] = d[i-1][3];
		}
		System.out.println(d[n][0] + d[n][1] + d[n][2] + d[n][3]);
	}
}
