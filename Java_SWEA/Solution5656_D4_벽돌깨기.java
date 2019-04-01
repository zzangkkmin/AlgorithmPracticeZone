package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution5656_D4_벽돌깨기 {
	public static int n,w,h, ans;
	public static int[][] map;
	public static int[][] tempMap;
	public static String[] line;
	public static int[] dropPos;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = Integer.MAX_VALUE;
			line = br.readLine().trim().split(" ");
			n = Integer.parseInt(line[0]);
			w = Integer.parseInt(line[1]);
			h = Integer.parseInt(line[2]);
			map = new int[h][w];
			dropPos = new int[n];
			tempMap = new int[h][w];
			//visit = new int[h][w];
			for(int i=0;i<h;i++) {
				line = br.readLine().trim().split(" ");
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}
			selectDrop(0);
			System.out.println("#"+t+" "+ans);
		}
	}
	public static boolean inrange(int x, int y) {
		if(x>=0&&x<h&&y>=0&&y<w) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void selectDrop(int idx) {
		if(idx==n) {
			if(ans == 0) {
				return;
			}
			int remain = 0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					tempMap[i][j] = map[i][j];
				}
			}
			for(int i=0;i<n;i++) {
				drop(dropPos[i]);
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(tempMap[i][j] != 0) {
						remain++;
					}
				}
			}
			if(remain==0) {
				ans = 0;
			}else {
				ans = ans > remain ? remain : ans;
			}
			return;
		}
		else {
			for(int i=0;i<w;i++) {
				dropPos[idx] = i;
				selectDrop(idx + 1);
			}
		}
	}
	public static void drop(int wIdx) {
		int dpx = 0;
		int dpy = wIdx;
		while(true) {
			if(!inrange(dpx,dpy)) {
				break;
			}
			if(tempMap[dpx][dpy] != 0) {
				crash(dpx,dpy);
				break;
			}
			dpx++;
		}
		//gravity
		for(int k=0;k<w;k++) {
			for(int i=h-1;i>=0;i--) {
				if(tempMap[i][k] == 0) {
					for(int j=i-1;j>=0;j--){
						if(tempMap[j][k] != 0) {
							tempMap[i][k] = tempMap[j][k];
							tempMap[j][k] = 0;
							break;
						}
					}
				}
			}
		}
	}
	public static void crash(int x, int y) {
		//BFS
		/*Queue<point> q = new LinkedList<>();
		q.add(new point(x, y));
		while(!q.isEmpty()) {
			point cur = q.poll();
			int mapRange = tempMap[cur.x][cur.y];
			visit[cur.x][cur.y] = 1;
			if(mapRange >= 2) {
				for(int d=0;d<4;d++) {
					for(int r=1;r<=mapRange-1;r++) {
						int nx = cur.x + dx[d] * r;
						int ny = cur.y + dy[d] * r;
						if(!inrange(nx,ny))
							break;
						if(visit[nx][ny] != 0) {
							continue;
						}
						if(tempMap[nx][ny]!=0) {
							q.add(new point(nx,ny));
						}
					}
				}
			}
		}
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(visit[i][j] == 1) {
					tempMap[i][j] = 0;
					visit[i][j] = 0;
				}
			}
		}*/
		//DFS
		int mapRange = tempMap[x][y];
		tempMap[x][y] = 0;
		for(int d=0;d<4;d++) {
			for(int r=1;r<=mapRange-1;r++) {
				int nx = x + dx[d] * r;
				int ny = y + dy[d] * r;
				if(!inrange(nx,ny))
					break;
				if(tempMap[nx][ny]!=0) {
					crash(nx,ny);
				}
			}
		}
	}
	static class point{
		int x; int y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("point [x=").append(x).append(", y=").append(y).append("]");
			return builder.toString();
		}
		
	}
}
/*
 * 5
3 10 10
0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 0 0 0 0
1 0 3 0 1 1 0 0 0 1
1 1 1 0 1 2 0 0 0 9
1 1 4 0 1 1 0 0 1 1
1 1 4 1 1 1 2 1 1 1
1 1 5 1 1 1 1 2 1 1
1 1 6 1 1 1 1 1 2 1
1 1 1 1 1 1 1 1 1 5
1 1 7 1 1 1 1 1 1 1
2 9 10
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
1 1 0 0 1 0 0 0 0
1 1 0 1 1 1 0 1 0
1 1 0 1 1 1 0 1 0
1 1 1 1 1 1 1 1 0
1 1 3 1 6 1 1 1 1
1 1 1 1 1 1 1 1 1
3 6 7
1 1 0 0 0 0
1 1 0 0 1 0
1 1 0 0 4 0
4 1 0 0 1 0
1 5 1 0 1 6
1 2 8 1 1 6
1 1 1 9 2 1
4 4 15
0 0 0 0 
0 0 0 0 
0 0 0 0 
1 0 0 0 
1 0 0 0 
1 0 0 0 
1 0 0 0 
1 0 5 0 
1 1 1 0 
1 1 1 9 
1 1 1 1 
1 6 1 2 
1 1 1 5 
1 1 1 1 
2 1 1 2 
4 12 15
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
 */







