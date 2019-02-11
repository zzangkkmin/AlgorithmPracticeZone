package com.ssafy.git.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestMap {
	public static int ans;
	public static int dxd = 0;
	//public static int[][] map;
	public static int[][] mot, pic;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = 0; dxd = 1;
			mot = new int[4][2];
			pic = new int[4][2];
			String[] line = br.readLine().split(" ");
			for(int i=0;i<4;i++) {
				mot[i][0] = Integer.parseInt(line[i*2]);
				mot[i][1] = Integer.parseInt(line[i*2+1]);
			}
			line = br.readLine().split(" ");
			for(int i=0;i<4;i++) {
				pic[i][0] = Integer.parseInt(line[i*2]);
				pic[i][1] = Integer.parseInt(line[i*2+1]);
			}
			int[] selected = {-1,-1,-1,-1};
			select1(selected,0);
			System.out.println("#"+t+" "+ans);
		}
	}
	public static void select1(int[] selected, int idx) {
		if(idx==4) {
			int[][] map = new int[100][100];
			int[] dir = {-1,-1,-1,-1};
			select2(selected,map,0,dir);
			return;
		}
		for(int i=0;i<4;i++) {
			if(selected[i] == -1) {
				selected[i] = idx;
				select1(selected, idx+1);
				selected[i] = -1;
			}
		}
	}
	public static void select2(int[] selected, int[][] mapp, int idx, int[] dir) {
		if(idx==4) {
			int sum = 0;
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					if(mapp[i][j] >= 1) {
						sum += 1;
					}
				}
			}
			System.out.print(dxd+": "+sum);
			dxd++;
			System.out.print(" { ");
			for(int s : selected)
				System.out.print(s + " ");
			System.out.print("},");
			
			System.out.print(" { ");
			for(int d : dir)
				System.out.print(d==0?"W ":"H ");
			System.out.println("}");
			
			
			ans = ans < sum ? sum : ans;
			return;
		}
		for(int i=0;i<2;i++) {
			int YY = mot[idx][0];
			int XX = mot[idx][1] - pic[selected[idx]][i]/2;
			for(int x = XX; x< XX + pic[selected[idx]][i]; x++) {
				for(int y = YY; y< YY + pic[selected[idx]][1-i]; y++) {
					mapp[x][y] += 1;
				}
			}
			dir[idx] = i;
			select2(selected,mapp,idx+1,dir);
			for(int x = XX; x< XX + pic[selected[idx]][i]; x++) {
				for(int y = YY; y< YY + pic[selected[idx]][1-i]; y++) {
					mapp[x][y] -= 1;
				}
			}
		}
	}
}

/*
3
0 10 4 15 6 17 10 22
10 12 8 16 8 14 20 12
0 30 20 50 30 30 60 20
30 6 6 6 6 6 6 6 
0 30 20 50 30 30 60 20 
30 30 26 40 20 30 36 30
*/
