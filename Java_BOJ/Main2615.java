package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main2615 {
	public static int[][] map = new int[21][21];
	public static int[] dx = {-1,-1,0,1,1,1,0,-1};
	public static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=19;i++) {
			for(int j=1;j<=19;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=1;i<=19;i++) {
			for(int j=1;j<=19;j++) {
				if(map[j][i] == 1 || map[j][i] == 2) {
					int len = omok(j,i,map[j][i],1,-1);
					if(len==5) {
						System.out.println(map[j][i]);
						System.out.println(j+" "+i);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
	public static boolean inrange(int x, int y) {
		if(x>=1&&x<=19&&y>=1&&y<=19)
			return true;
		else
			return false;
	}
	public static int omok(int x, int y, int stone, int len, int dir) {
		if(dir == -1) {
			int ret = len;
			for(int d=1;d<=4;d++) {
				int nx = x + dx[d]; int px = x + dx[(d + 4) % 8]; 
				int ny = y + dy[d]; int py = y + dy[(d + 4) % 8];
				//System.out.println("x="+x+", y="+y);
				//System.out.println(nx+","+ny+" / "+px+","+py);
				if(!inrange(nx,ny))
					continue;
				if(map[nx][ny] == stone && map[px][py] != stone) {
					int temp = omok(nx,ny,stone,len+1,d);
					if(temp==5) {
						return 5;
					}
					ret = ret < temp ? temp : ret;
				}
			}
			return ret;
		}
		else {
			int nx = x + dx[dir]; int ny = y + dy[dir];
			if(inrange(nx,ny) && map[nx][ny] == stone) {
				return omok(nx,ny,stone,len+1,dir);
			}
			else {
				return len;
			}
		}
	}
}
