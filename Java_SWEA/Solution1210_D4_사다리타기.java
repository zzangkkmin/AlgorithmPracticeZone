package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution1210_D4_사다리타기 {
	static int size = 100;
	static int[][] map = new int[size][size];
	static int[] dx = {0,0,-1};
	static int[] dy = {-1,1,0};
	static int ans = -1;
	
//	recursive way
	
//	static void go(int x, int y) {
//		map[x][y] = -1;
//		if(x==0) {
//			ans = y;
//			return;
//		}
//		for(int d=0;d<3;d++) {
//			int nx = x + dx[d];
//			int ny = y + dy[d];
//			if(nx>=0 && nx<size && ny>=0 && ny<size && map[nx][ny] == 1) {
//				go(nx,ny);
//				break;
//			}
//		}
//	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//bufferedreader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			ans = -1;
			//int tt = sc.nextInt();
			br.readLine();
			int X = -1, Y = -1;
			for(int i=0;i<size;i++) {
				String[] line = br.readLine().split(" ");
				for(int j=0;j<size;j++) {
					map[i][j] = Integer.parseInt(line[j]);
					if(map[i][j]==2) {
						X = i; Y = j;
					}
				}
			}
//			go(X,Y);
			
//			loop way
			
			while(true) {
				if(X==0) {
					ans = Y;
					break;
				}
				map[X][Y] = -1;
				for(int d=0;d<3;d++) {
					int nx = X + dx[d];
					int ny = Y + dy[d];
					if(nx>=0 && nx<size && ny>=0 && ny<size && map[nx][ny] == 1) {
						X = nx; Y = ny;
						break;
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}

}
