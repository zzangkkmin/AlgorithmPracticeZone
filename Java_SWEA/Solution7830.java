package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution7830 {
	public static int[][] map;
	public static int n,m,ans;
	public static int[] dx = {1,1,-1,-1};
	public static int[] dy = {1,-1,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][m];
			for(int i=0;i<n;i++) {
				String input = sc.next();
				for(int j=0;j<m;j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			ans = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] == 1) {
						ans = ans < 1 ? 1 : ans;
						rhombusOne(i,j,0);
					}
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	public static boolean valid(int x, int y) {
		if(x<0 || x>=n || y<0 || y>=m) {
			return false;
		} else if(map[x][y] == 0) {
			return false;
		} else {
			return true;
		}
	}
	public static void rhombusOne(int x, int y, int size) {
		//just one max-length
		int nx = x + dx[0];
		int ny = y + dy[0];
		size++;
		if(valid(nx,ny)) {
			rhombusOne(nx,ny,size);
			if(size >= ans && nx + size < n && ny - 2*size >= 0) {
				rhombusRest(nx,ny,size);
			}
		}
		
	}
	public static void rhombusRest(int x, int y, int size) {
		int nx = x; int ny = y;
		for(int d=1;d<4;d++) {
			for(int l = 0; l<size;l++) {
				nx = nx + dx[d];
				ny = ny + dy[d];
				if(!valid(nx,ny)) {
					return;
				}
			}
		}
		if(ans <= size) {
			ans = size+1;
		}
	}
}
