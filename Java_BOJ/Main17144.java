package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17144 {
	static int R,C,T;
	static int ridx = 0;
	static int[] rx = new int[2];
	static int[] ry = new int[2];
	static int[][][] map;
	static int[][] windmap;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<R&&y>=0&&y<C) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		map  = new int[2][R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[0][i][j] = sc.nextInt();
				if(map[0][i][j] == -1) {
					map[1][i][j] = -1;
					rx[ridx] = i;
					ry[ridx] = j;
					ridx++;
				}
			}
		}
		while(true) {
			if(T==0) {
				break;
			}
			int expandValue = 0;
			int expandNum = 0;
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(map[0][i][j] > 0) {
						expandValue = map[0][i][j] / 5;
						expandNum = 0;
						for(int d=0;d<4;d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if(inrange(nx,ny) && map[1][nx][ny] != -1) {
								map[1][nx][ny] += expandValue;
								expandNum++;
							}
						}
						map[1][i][j] += map[0][i][j] - expandValue * expandNum;
					}
				}
			}
			for(int ri = 0; ri<2; ri ++) {
				int rOriginX = rx[ri];
				int rOriginY = ry[ri];
				int rCurX = rOriginX;
				int rCurY = rOriginY + 1;
				int wind = 0;
				int d = 0;
				//시계방향 (ridx=1)
				//0,1,2,3
				//반시계방향(ridx=0)
				//0,3,2,1
				if(ri==0) {
					while(!(rCurX == rOriginX && rCurY == rOriginY)) {
						int temp = map[1][rCurX][rCurY];
						map[1][rCurX][rCurY] = wind;
						wind = temp;
						if(!inrange(rCurX + dx[d],rCurY + dy[d])) {
							d = d - 1 < 0 ? 3 : d - 1;
						}
						rCurX = rCurX + dx[d];
						rCurY = rCurY + dy[d];
					}
				}
				else {
					while(!(rCurX == rOriginX && rCurY == rOriginY)) {
						int temp = map[1][rCurX][rCurY];
						map[1][rCurX][rCurY] = wind;
						wind = temp;
						if(!inrange(rCurX + dx[d],rCurY + dy[d])) {
							d++;
						}
						rCurX = rCurX + dx[d];
						rCurY = rCurY + dy[d];
					}
				}
			}
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					map[0][i][j] = map[1][i][j];
					if(map[0][i][j] == -1) {
						continue;
					}
					map[1][i][j] = 0;
				}
			}
			T--;
		}
		
//		System.out.println();
//		for(int i=0;i<R;i++) {
//			for(int j=0;j<C;j++) {
//				System.out.print(map[0][i][j]+" ");
//			}
//			System.out.println();
//		}
		int ans = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				ans += map[0][i][j];
			}
		}
		System.out.println(ans+2);
		
		sc.close();
	}

}
