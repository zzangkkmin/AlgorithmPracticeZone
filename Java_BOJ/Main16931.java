package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16931 {
	public static int[][] map;
	public static String[] line;
	public static int n,m, ans;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new int[n+2][m+2];
		for(int i=1;i<=n;i++){
			line = br.readLine().split(" ");
			for(int j=1;j<=m;j++){
				map[i][j] = Integer.parseInt(line[j-1]);
			}
		}
		ans = 2 * n * m;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				int ch = map[i][j];
				for(int d=0;d<4;d++){
					int nh = map[i+dx[d]][j+dy[d]];
					if(ch<=nh){
						continue;
					}
					else{
						ans += (ch - nh);
					}
				}
			}
		}
		System.out.println(ans);
	}

}
