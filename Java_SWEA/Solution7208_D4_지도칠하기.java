package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution7208_D4_지도칠하기 {
	public static int n, ans;
	public static ArrayList<Integer>[] link;
	public static String[] line;
	public static int[] color;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			n = Integer.parseInt(br.readLine().trim());
			ans = n+1;
			color = new int[n];
			link = new ArrayList[n];
			for(int i=0;i<n;i++) {
				link[i] = new ArrayList<>();
			}
			line = br.readLine().trim().split(" ");
			for(int i=0;i<n;i++) {
				color[i] = Integer.parseInt(line[i]);
			}
			for(int i=0;i<n;i++) {
				line = br.readLine().trim().split(" ");
				for(int j=0;j<n;j++) {
					int linked = Integer.parseInt(line[j]);
					if(linked == 1) {
						link[i].add(j);
					}
				}
			}
			int[] tempColor = new int[n];
			for(int i=1;i<=4;i++) {
				tempColor[0] = i;
				confirm(0, 1, tempColor);
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	public static void confirm(int idx, int colorized, int[] temp) {
		if(colorized == n) {
			int diff = 0;
			for(int i=0;i<n;i++) {
				if(temp[i] != color[i]) {
					diff++;
				}
			}
			ans = ans > diff ? diff : ans;
			return;
		}
		else {
			for(int next: link[idx]) {
				if(temp[next] == temp[idx]) {
					return;
				}
				if(temp[next] == 0) {
					for(int color = 1; color <= 4; color++) {
						if(temp[idx] != color) {
							temp[next] = color;
							confirm(next,colorized+1,temp);
							temp[next] = 0;
						}
					}
				}
			}
		}
	}
}
