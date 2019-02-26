package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main15685 {
	public static int map[][] = new int[101][101];
	public static String[] line;
	public static int x,y,d,g;
	public static ArrayList<Integer> dir = new ArrayList<>();
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,-1,0,1};
	public static void dirGenerate() {
		dir.add(0);
		for(int gg = 1; gg <= 10; gg++) {
			int dirSize = dir.size();
			for(int i = dirSize-1; i>=0; i--) {
				int dirD = dir.get(i);
				dir.add((dirD+1)%4);
			}
		}
	}
	public static void move(int xx, int yy, int dd, int gg) {
		map[yy][xx] = 1;
		for(int i=0;i<Math.pow(2, gg);i++) {
			xx = xx + dx[(dir.get(i) + dd) % 4];
			yy = yy + dy[(dir.get(i) + dd) % 4];
			map[yy][xx] = 1;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		dirGenerate();
		for(int i=0;i<n;i++) {
			line = br.readLine().split(" ");
			x = Integer.parseInt(line[0]);
			y = Integer.parseInt(line[1]);
			d = Integer.parseInt(line[2]);
			g = Integer.parseInt(line[3]);
			move(x,y,d,g);
		}
		int ans = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j] == 1 && map[i+1][j] == 1 &&
					map[i][j+1] == 1 && map[i+1][j+1] == 1) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}
