package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17143
{
	public static int R,C,M,ans;
	public static int[] dx = {0,-1,1,0,0};
	public static int[] dy = {0,0,0,1,-1};
	public static int people = 0;
	public static int[][] map, temp;
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();
		map = new int[R+2][C+2];
		temp = new int[R+2][C+2];
		shark[] sharkList = new shark[M+1];
		for(int i=1;i<=M;i++) {
			int r,c,s,d,z;
			r = sc.nextInt();
			c = sc.nextInt();
			s = sc.nextInt();
			d = sc.nextInt();
			z = sc.nextInt();
			sharkList[i] = new shark(r, c, s, d, z);
			map[r][c] = i;
		}
		
		while(true) {
			//1. 낚시꾼 이동
			people++;
			if(people > C) {
				break;
			}
			//2. 낚시꾼이 있는 열에 있는 상어 중 땅과 가까운 상어 제거
			for(int i=1;i<=R;i++) {
				if(map[i][people] != 0) {
					ans += sharkList[map[i][people]].z;
					sharkList[map[i][people]].death = 1;
					map[i][people] = 0;
					break;
				}
			}
			//3. 상어 이동
			for(int i=1;i<=M;i++) {
				if(sharkList[i].death == 1) {
					continue;
				}
				shark S = sharkList[i];
				int cx = S.r; int cy = S.c;
				int len = S.s; int dir = S.d;
				int nx,ny;
				while(true) {
					nx = cx + dx[dir] * len;
					ny = cy + dy[dir] * len;
					if(nx >= 1 && nx <= R && ny >= 1 && ny <= C) {
						break;
					}
					else if(dir == 1 && nx < 1) {
						len -= (cx - 1);
						cx = 1; dir = 2;
					}
					else if(dir == 2 && nx > R) {
						len -= (R - cx);
						cx = R; dir = 1;
					}
					else if(dir == 3 && ny > C) {
						len -= (C - cy);
						cy = C; dir = 4;
					}
					else if(dir == 4 && ny < 1) {
						len -= (cy - 1);
						cy = 1; dir = 3;
					}
				}
				sharkList[i].r = nx;
				sharkList[i].c = ny;
				sharkList[i].d = dir;
			}
			//4. 잡아 먹기
			for(int i=1;i<=M;i++) {
				if(sharkList[i].death == 1) {
					continue;
				}
				shark S = sharkList[i];
				if(temp[S.r][S.c] != 0) {
					shark VS = sharkList[temp[S.r][S.c]];
					if(VS.z < S.z) {
						sharkList[temp[S.r][S.c]].death = 1;
						temp[S.r][S.c] = i;
					}else {
						sharkList[i].death = 1;
					}
				}else {
					temp[S.r][S.c] = i;
				}
			}
			for(int i=1;i<=R;i++) {
				for(int j=1;j<=C;j++) {
					map[i][j] = temp[i][j];
					temp[i][j] = 0;
				}
			}
			
		}
		System.out.println(ans);
		sc.close();
	}
	public static class shark{
		int r; int c;
		int s; int d;
		int z; int death;
		public shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.death = 0;
		}		
	}
	
}