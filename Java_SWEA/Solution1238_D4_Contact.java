package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1238_D4_Contact {
	public static int n, start;
	public static String[] line;
	public static int[][] map;
	public static int[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			line = br.readLine().trim().split(" ");
			n = Integer.parseInt(line[0]);
			start = Integer.parseInt(line[1]);
			line = br.readLine().trim().split(" ");
			map = new int[101][101];
			visited = new int[101];
			for(int i=0;i<n/2;i++) {
				int a = Integer.parseInt(line[2*i]);
				int b = Integer.parseInt(line[2*i+1]);
				map[a][b] = 1;
			}
			System.out.println("#"+t+" "+find());
		}
	}
	public static int find() {
		Queue<Integer[]> q = new LinkedList<>();
		int timer = 0; int ans = 0;
		visited[start] = 1;
		q.add(new Integer[] {start , 1});
		while(!q.isEmpty()) {
			Integer[] cur = q.poll();
			for(int i=1;i<=100;i++) {
				if(map[cur[0]][i] == 1 && visited[i] == 0) {
					visited[i] = cur[1] + 1;
					q.add(new Integer[] {i,cur[1] + 1});
				}
			}
		}
		for(int i=1;i<=100;i++) {
			if(timer <= visited[i]) {
				timer = visited[i];
				ans = (ans < i ? i : ans);
			}
		}
		return ans;
	}
}
