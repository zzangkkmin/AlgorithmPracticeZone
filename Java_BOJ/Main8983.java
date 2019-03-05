package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main8983 {
	public static String[] line;
	public static int m,n,l,ans;
	public static int[] gunz;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().split(" ");
		m = Integer.parseInt(line[0]);
		n = Integer.parseInt(line[1]);
		l = Integer.parseInt(line[2]);
		gunz = new int[m];
		line = br.readLine().split(" ");
		for(int i=0;i<m;i++) {
			gunz[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(gunz);
		for(int i=0;i<n;i++) {
			line = br.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			find(x,y);
		}
		System.out.println(ans);
	}
	public static void find(int x, int y) {
		int LIdx = 0;
		int RIdx = gunz.length - 1;
		if(x > gunz[RIdx]) {
			if(y+x-gunz[RIdx]<=l) {
				ans++;
			}
			return;
		}
		else if(x < gunz[LIdx]) {
			if(y+gunz[LIdx]-x<=l) {
				ans++;
			}
			return;
		}
		while(LIdx <= RIdx) {
			int midIdx = (LIdx + RIdx) / 2;
			if(gunz[midIdx] > x) {
				RIdx = midIdx - 1;
			}
			else if(gunz[midIdx] == x) {
				if(y<=l) {
					ans++;
				}
				return;
			}
			else {
				LIdx = midIdx + 1;
			}
		}
		int l1 = Math.abs(gunz[LIdx] - x);
		int l2 = Math.abs(gunz[RIdx] - x);
		int minX = (l1 < l2 ? l1 : l2);
		if(minX+y<=l) {
			ans++;
		}
		
	}
}
