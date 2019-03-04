package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1861_D4_정사각형방 {
	public static int n;//~1,000
	public static int[][] map;
	public static int[][] visited;
	public static int[][] numMap;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static String[] line;
	public static int ans, ansSize;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			n = Integer.parseInt(br.readLine().trim());
			map = new int[n][n];
			visited = new int[n][n];
			numMap = new int[n*n+1][2];
			ans = n*n + 1; ansSize = 0;
			
			for(int i=0;i<n;i++) {
				line = br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(line[j]);
					numMap[map[i][j]][0] = i;
					numMap[map[i][j]][1] = j;
				}
			}
			for(int i=1;i<=n*n;) {
				int length = find(numMap[i][0], numMap[i][1]);
				if(length > ansSize) {
					ansSize = length;
					ans = i;
				}
				i = i+length;
			}
			System.out.println("#"+t+" "+ans+" "+ansSize);
		}
	}
	public static int find(int x,int y) {
		Queue<Integer[]> q = new LinkedList<>();
		int roomNum = map[x][y]; int roomSize = 0;
		q.add(new Integer[] {x,y});
		visited[x][y] = roomNum;
		roomSize = 1;
		while(!q.isEmpty()) {
			Integer[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			for(int d = 0; d<4;d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if(nx<0||nx>=n||ny<0||ny>=n) {
					continue;
				}
				else if(map[nx][ny] - map[cx][cy] == 1) {
					q.add(new Integer[] {nx,ny});
					visited[nx][ny] = roomNum;
					roomSize++;
				}
			}
		}
		return roomSize;
	}
}
