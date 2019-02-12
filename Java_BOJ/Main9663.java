package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9663 {
	public static int[] line;//line[i] = j : map[i][j]에  queen
	public static int n,ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		ans = 0;
		line = new int[n+1];
		queen(0);
		System.out.println(ans);
	}
	public static void queen(int q) {
		if(isOK(q)) {
			if(q==n) {
				//print part
				int[][] map = new int[n+1][n+1];
				for(int i=1;i<=n;i++) {
					System.out.print("("+i+","+line[i]+") ");
					map[i][line[i]] = 1;
				}
				System.out.println();
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						System.out.print(map[i][j]==1?"X":map[i][j]);
					}
					System.out.println();
				}
				System.out.println();
				ans++;
			}
			else {
				for(int i=1;i<=n;i++) {
					line[q+1] = i;
					queen(q+1);
				}
			}
		}
	}
	public static boolean isOK(int q) {
		boolean ret = true;
		int k = 1;
		while(k<q&&ret) {
			if(line[k] == line[q] || (Math.abs(line[k]-line[q]))==Math.abs(k-q)) {
				ret = false;
			}
			k++;
		}
		return ret;
	}
}
