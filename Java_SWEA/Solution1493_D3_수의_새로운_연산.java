package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution1493_D3_수의_새로운_연산 {
	public static int[][] dots;//점 1~10000
	public static String[] line;
	public static Map<Integer, Integer> numDots = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		dots = new int[50001][2];
		init();
		for(int t = 1; t <= tc; t++) {
			line = br.readLine().trim().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			System.out.println("#"+t+" "+sum(a,b));
		}
	}
	public static void init() {
		int x = 1; int y = 1;
		for(int i=1;i<=50000;i++) {
			dots[i][0] = x;
			dots[i][1] = y;
			numDots.put(x*50000 + y, i);
			if(x==1) {
				x = y + 1;
				y = 1;
			}
			else {
				x = x - 1;
				y = y + 1;
			}
		}
	}
	public static int sum(int a, int b) {
		int ax = dots[a][0]; int ay = dots[a][1];
		int bx = dots[b][0]; int by = dots[b][1];
		return numDots.get((ax+bx)*50000 + (ay+by));
	}
}
