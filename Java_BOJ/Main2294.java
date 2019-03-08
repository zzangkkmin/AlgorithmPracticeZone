package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2294 {
	public static int n,k;
	public static int[] coins;
	public static int[] d;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		coins = new int[n];
		for(int i=0;i<n;i++) {
			coins[i] = Integer.parseInt(br.readLine().trim());
		}
		Arrays.sort(coins);
		d = new int[k+1];
		Arrays.fill(d, -1);
		d[0] = 0;
		for(int i = 0; i<=k; i++) {
			if(d[i] < 0) {
				continue;
			}
			for(int j=0;j<n;j++) {
				if(i + coins[j] > k) {
					continue;
				}
				if(d[i+coins[j]] < 0 || d[i+coins[j]] > d[i] + 1) {
					d[i+coins[j]] = d[i] + 1;
				}
			}
		}
		
		System.out.println(d[k]);
	}
}
