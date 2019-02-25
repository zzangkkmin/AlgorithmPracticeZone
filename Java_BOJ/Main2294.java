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
		int min; int size = coins.length;
		for(int change=1;change<=k;change++) {
			min = Integer.MAX_VALUE;
			for(int i=0;i<size;i++) {
				if(change >= coins[i]) {
					if(d[change-coins[i]]<min) {
						min = (int) d[change-coins[i]];
					}
				}
			}
			d[change] = min + 1;
		}
		System.out.println(d[k]);
	}
}
