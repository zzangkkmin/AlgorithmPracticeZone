package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main10216 {
	public static int n;//3000
	public static node[] nodes;
	public static ArrayList<Integer>[] map;
	public static boolean[] visited;
	public static String[] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++){
			int ans = 0;
			n = Integer.parseInt(br.readLine().trim());
			nodes = new node[n];
			visited = new boolean[n];
			map = new ArrayList[n];
			for(int i=0;i<n;i++){
				map[i] = new ArrayList<>();
				line = br.readLine().split(" ");
				int x = Integer.parseInt(line[0]);
				int y = Integer.parseInt(line[1]);
				int r = Integer.parseInt(line[2]);
				nodes[i] = new node(x,y,r);
			}
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					int dx = Math.abs(nodes[i].x - nodes[j].x);
					int dy = Math.abs(nodes[i].y - nodes[j].y);
					if(Math.sqrt(dx*dx+dy*dy) <= (nodes[i].r + nodes[j].r)){
						map[i].add(j);
						map[j].add(i);
					}
				}
			}
			for(int i=0;i<n;i++){
				if(visited[i]==false){
					find(i);
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
	public static void find(int start){
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()){
			int cur = q.poll();
			for(int i = 0 ; i < map[cur].size(); i++){
				int next = map[cur].get(i);
				if(visited[next]==false){
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
	static class node{
		int x; int y; int r;
		public node(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

}
