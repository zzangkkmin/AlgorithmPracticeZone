package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution3124_D4_MST {
	static int[] parent;
	static long result;
	static class Node implements Comparable<Node>{
		//a to b = weight c;
		int a;
		int b;
		int c;
		public Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.c - o.c > 0 ? 1 : -1;
		}
		
	}
	public static void makeSet(int x) {
		parent[x] = x;
	}
	public static int findSet(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = findSet(parent[x]);
	}
	public static void union(Node node) {
		int root1 = findSet(node.a);
		int root2 = findSet(node.b);
		if(root1 == root2) {
			return;
		}
		parent[root1] = root2;
		result += node.c;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			result = 0;
			String[] line = br.readLine().split(" ");
			int v = Integer.parseInt(line[0]);
			int e = Integer.parseInt(line[1]);
			//treeSet - comparable 구현 객체만 저장, 정렬해주는 자료구조
			TreeSet<Node> ts = new TreeSet<>();
			parent = new int[v+1];
			for(int i=0;i<=v;i++) {
				makeSet(i);
			}
			for(int i=0;i<e;i++) {
				line = br.readLine().split(" ");
				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				int c = Integer.parseInt(line[2]);
				ts.add(new Node(a,b,c));
			}
			for(Node node : ts) {
				union(node);
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
