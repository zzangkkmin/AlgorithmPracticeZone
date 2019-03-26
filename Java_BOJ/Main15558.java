package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main15558 {
	public static int n,k;
	public static String[] line;
	public static char[][] map;
	public static int[][] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		k = Integer.parseInt(line[1]);
		map = new char[2][n];
		visited = new int[2][n];
		map[0] = br.readLine().trim().toCharArray();
		map[1] = br.readLine().trim().toCharArray();
		for(int i=0;i<2;i++) {
			for(int j=0;j<n;j++) {
				visited[i][j] = -1;
			}
		}
		System.out.println(find());
	}
	public static int find() {
		Queue<Integer> q = new LinkedList<>();
		int pos = 0*n+0;
		q.add(pos);
		visited[0][0] = 0;
		int time = 0;
		while(!q.isEmpty()) {
			int qsize = q.size();
			for(int i=0;i<qsize;i++) {
				int curPos = q.poll();
				int cx = curPos / n;
				int cy = curPos % n;
                if(cy<time){
                    continue;
                }
				if(cy - 1 >= time && cy - 1 < n && map[cx][cy - 1] == '1' && visited[cx][cy - 1] == -1) {
					int npos = cx * n + (cy - 1);
					q.add(npos);
					visited[cx][cy-1] = visited[cx][cy] + 1;
				}
                if(cy + 1 >= n) {
					return 1;
				}
				else if(cy + 1 < n && map[cx][cy + 1] == '1' && visited[cx][cy + 1] == -1) {
					int npos = cx * n + (cy + 1);
					q.add(npos);
					visited[cx][cy+1] = visited[cx][cy] + 1;
				}
								
				int nx = (cx == 1 ? 0 : 1);
				if(cy + k >= n) {
                    return 1;
				}
				else if(map[nx][cy + k] == '1' && visited[nx][cy + k] == -1) {
					int npos = nx * n + (cy + k);
					q.add(npos);
					visited[nx][cy + k] = visited[cx][cy] + 1;
				}
			}
			time++;
		}
		return 0;
	}
	
}
