package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution5986_D3_세셈이세소수 {
	public static int ans, n;//7<=n<=999
	public static boolean[] prime;
	public static int[] pnum = new int[1000];
	public static ArrayList<Integer> primeList = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		eratostenes();
		find();
		for(int t=1;t<=tc;t++) {
			ans = 0;
			n = Integer.parseInt(br.readLine().trim());
			ans = pnum[n];
			System.out.println("#"+t+" "+ans);
		}
		
	}
	public static void eratostenes() {
		prime = new boolean[1000];//1~999
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for(int i=2;i<=999;i++) {
			if(prime[i] == true) {
				for(int j=i+i;j<=999;j=j+i) {
					prime[j] = false;
				}
				primeList.add(i);
			}
		}
	}
	public static void find() {
		for(int i=0;i<primeList.size()-2;i++) {
			int x = primeList.get(i);
			for(int j=i;j<primeList.size()-1;j++) {
				int y = primeList.get(j);
				for(int k=j;k<primeList.size();k++) {
					int z = primeList.get(k);
					if(x+y+z<=999) {
							
					}
				}
			}
		}
	}
}
