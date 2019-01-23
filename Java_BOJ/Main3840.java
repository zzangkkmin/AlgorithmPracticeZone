package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main3840 {
	public static int n,m;
	public static Map<Integer, ArrayList<Edge>> Tree;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			//String[] nm = br.readLine().split(" ");
			//n = Integer.parseInt(nm[0]);
			//m = Integer.parseInt(nm[1]);
			n = sc.nextInt();
			m = sc.nextInt();
			Tree = new HashMap<>();
			if(n==0&&m==0) {
				break;
			}
			for(int i=0;i<m;i++) {
				//String[] quest = br.readLine().split(" ");
				char[] qqq = sc.next().toCharArray();
				if(qqq[0]=='!'/*quest[0].equals("!")*/) {
					//int start = Integer.parseInt(quest[1]);
					//int end = Integer.parseInt(quest[2]);
					//long val = Integer.parseInt(quest[3]);
					int start = sc.nextInt();
					int end = sc.nextInt();
					long val = sc.nextLong();
					Edge e1 = new Edge(end,val);
					if(Tree.containsKey(start)) {
						Tree.get(start).add(e1);
					}
					else {
						Tree.put(start, new ArrayList<Edge>());
						Tree.get(start).add(e1);
					}
					
					Edge e2 = new Edge(start,-val);
					if(Tree.containsKey(end)) {
						Tree.get(end).add(e2);
					}
					else {
						Tree.put(end, new ArrayList<Edge>());
						Tree.get(end).add(e2);
					}
					//System.out.println("OK");
				}
				else {
					//int start = Integer.parseInt(quest[1]);
					//int end = Integer.parseInt(quest[2]);
					int start = sc.nextInt();
					int end = sc.nextInt();
					search(start,end);
				}
			}
		}
	}
	public static void search(int start, int end) {
		Queue<Edge> q = new LinkedList();
		boolean[] visited = new boolean[2*n];
		visited[start] = true;
		for(Edge e : Tree.get(start)) {
			q.add(e);
		}
		boolean find = false;
		long ret = 0;
		while(!q.isEmpty()) {
			Edge cur = q.poll();
			long cVal = cur.val;
			int cEnd = cur.to;
			visited[cEnd] = true;
			if(cEnd==end) {
				find = true;
				ret = cVal;
				break;
			}
			for(Edge e: Tree.get(cEnd)) {
				if(!visited[e.to]) {
					Edge input = new Edge(e.to, e.val + cVal);
					q.add(input);
				}
			}
		}
		if(find) {
			System.out.println(ret);
		}
		else {
			System.out.println("UNKNOWN");
		}
	}
	public static class Edge{
		int to;
		long val;
		Edge(){}
		Edge(int to, long val){
			this.val = val;
			this.to = to;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Edge [to=").append(to).append("(val=").append(val).append(")");
			return builder.toString();
		}
		
	}
}
