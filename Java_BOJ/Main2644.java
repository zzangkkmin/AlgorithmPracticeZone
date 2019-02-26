package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main2644 {
	public static int n,x,y,m;
	public static String[] line;
	public static ArrayList<Integer>[] relation;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		line = br.readLine().split(" ");
		x = Integer.parseInt(line[0]);
		y = Integer.parseInt(line[1]);
		m = Integer.parseInt(br.readLine().trim());
		relation = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			relation[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			line = br.readLine().split(" ");
			int par = Integer.parseInt(line[0]);
			int son = Integer.parseInt(line[1]);
			relation[par].add(son);
			relation[son].add(par);
		}
		find();
	}	
	public static void find() {
		int[] visit = new int[n+1];
		Arrays.fill(visit, -1);
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visit[x] = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int xx : relation[cur]) {
				if(visit[xx]==-1) {
					q.add(xx);
					visit[xx] = visit[cur] + 1;
				}
			}
		}
		System.out.println(visit[y]);
	}

}
