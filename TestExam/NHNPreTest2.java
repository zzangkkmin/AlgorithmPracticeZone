package com.ssafy.git.TestExam;

import java.util.Scanner;

public class NHNPreTest2 {
	static int n;
	static String[][] input;
	static int[][] map, visit, origin;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		input = new String[n][n]; origin = new int[n][n];
		map = new int[n][n]; visit = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				input[i][j] = sc.next();
				if(isNum(input[i][j])) {
					map[i][j] = Integer.parseInt(input[i][j]);
					origin[i][j] = map[i][j];
				} else {
					map[i][j] = -(input[i][j].charAt(0) - 'A' + 1);
					origin[i][j] = map[i][j];
				}
			}
		}
		engage(0);
	}
	public static boolean isNum(String zone) {
		if(zone.contains("0") || zone.contains("1") || zone.contains("2") || zone.contains("3") ||
		   zone.contains("4") || zone.contains("5") || zone.contains("6") || zone.contains("7") ||
		   zone.contains("8") || zone.contains("9")) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<n&&y>=0&&y<n) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean ispasswall(int cx, int cy, int cd) {
		int wallInfo = origin[cx][cy];
		if(wallInfo <= 0) {
			return true;
		}else{
			if((wallInfo & (1 << cd)) != 0) {
				return false;
			}else {
				return true;
			}
		}
	}
	public static void engage(int turn) {
		boolean end = true;
		int[][] temp = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				temp[i][j] = map[i][j];
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j] == 0 && map[i][j] >= 0) {
					int[] abc = new int[26];
					boolean adjust = false;
					for(int d=0;d<4;d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						int rd = -1;
						if(d==0) rd = 1;
						else if(d==1) rd = 0;
						else if(d==2) rd = 3;
						else if(d==3) rd = 2;
						if(inrange(nx,ny) && map[nx][ny] < 0 && ispasswall(i,j,d) && ispasswall(nx, ny, rd)) {
							abc[-map[nx][ny]-1]++;
							adjust = true;
						}
					}
					if(adjust) {
						int King = 1; int KingCnt = 0;
						for(int k=0;k<26;k++) {
							if(abc[k] != 0) {
								if(KingCnt < abc[k]) {
									King = -k-1;
									KingCnt = abc[k];
								} else if(KingCnt == abc[k]) {
									King = 1;
								}
							}
						}
						if(King < 0) {
							visit[i][j] = 1;
							temp[i][j] = King;
							end = false;
						}
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = temp[i][j];
			}
		}
		if(end) {
			System.out.println(turn);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] < 0) {
						System.out.print((char) (-map[i][j] + 'A' - 1));
					}else {
						System.out.print(map[i][j]);
					}
					if(j!=n-1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			return;
		}else {
			engage(turn+1);
		}
	}
}
