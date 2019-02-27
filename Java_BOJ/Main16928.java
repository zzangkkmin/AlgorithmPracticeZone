package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main16928 {
	public static String[] line;
	public static int n,m;//1~15
	public static int start = 1;
	public static Map<Integer, Integer> ladderSnake = new HashMap<Integer, Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		for(int i=0;i<n;i++) {
			line = br.readLine().split(" ");
			int la = Integer.parseInt(line[0]);
			int lb = Integer.parseInt(line[1]);
			ladderSnake.put(la, lb);
		}
		for(int i=0;i<m;i++) {
			line = br.readLine().split(" ");
			int sa = Integer.parseInt(line[0]);
			int sb = Integer.parseInt(line[1]);
			ladderSnake.put(sa, sb);
		}
		find();
	}
	public static void find() {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] visit = new int[101];
		Arrays.fill(visit, -1);
		
		q.add(start);
		visit[start] = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int d=1;d<=6;d++) {
				int next = cur + d;
				if(next<=100 && visit[next] == -1) {
					visit[next] = visit[cur] + 1;
					if(ladderSnake.containsKey(next)) {
						int teleport = ladderSnake.get(next);
						if(visit[teleport] == -1) {
							visit[teleport] = visit[next];
							q.add(teleport);
						}
					}
					else {
						q.add(next);
					}
				}
			}
		}
		System.out.println(visit[100]);
	}
}
