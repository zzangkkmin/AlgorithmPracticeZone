package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Main1260 {
	public static int n,m,start;
	public static Map<Integer, ArrayList<Integer>> map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		start = Integer.parseInt(line[2]);
		map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0;i<m;i++) {
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			if(map.containsKey(a)) {
				map.get(a).add(b);
			}
			else {
				map.put(a, new ArrayList<Integer>());
				map.get(a).add(b);
			}
			if(map.containsKey(b)) {
				map.get(b).add(a);
			}
			else {
				map.put(b, new ArrayList<Integer>());
				map.get(b).add(a);
			}
		}
		for(ArrayList<Integer> t : map.values()) {
			Collections.sort(t);
		}
		dfs();
		bfs();
	}
	public static void bfs() {
		boolean[] visit = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur+" ");
			for(int in : map.get(cur)) {
				if(!visit[in]) {
					q.add(in);
					visit[in] = true;
				}
				
			}
		}
		System.out.println();
	}
	public static void dfs() {
		boolean[] visit = new boolean[n+1];
		Stack<Integer> s = new Stack<Integer>();
		s.add(start);
		while(!s.isEmpty()) {
			int cur = s.pop();
			if(visit[cur] == true)
				continue;
			visit[cur] = true;
			System.out.print(cur+" ");
			
			for(int i = map.get(cur).size() - 1 ; i>=0;i--) {
				if(!visit[map.get(cur).get(i)]) {
					s.add(map.get(cur).get(i));
				}
			}
		}
		System.out.println();
	}
}
