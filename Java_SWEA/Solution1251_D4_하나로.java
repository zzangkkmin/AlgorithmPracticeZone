package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution1251_D4_하나로 {
	public static TreeSet<Node> ts;
	public static int[] parent;
	public static long result;
	public static String[] line;
	public static long[] posX;//0~1,000,000
	public static long[] posY;//0~1,000,000
	public static int n;//1~1,000
	public static int edge_select;
	static class Node implements Comparable<Node>{
		
		int a; int b; long dist;
		public Node(int a, int b ,long dist) {
			this.a = a;
			this.b = b;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist > 0 ? 1: -1;
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
		result += node.dist;
		edge_select++;
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		
		for(int t=1;t<=tc;t++) {
			n = Integer.parseInt(br.readLine().trim());
			result = 0; edge_select = 0;
			parent = new int[n]; ts = new TreeSet<>();
			posX = new long[n]; posY = new long[n];
			line = br.readLine().split(" ");
			for(int i=0;i<n;i++) {
				posX[i] = Long.parseLong(line[i]);
			}
			line = br.readLine().split(" ");
			for(int i=0;i<n;i++) {
				posY[i] = Long.parseLong(line[i]);
			}
			for(int i=0;i<n;i++) {
				makeSet(i);
			}
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					if(i==j) {
						continue;
					}
					else {
						//a = (x[i], y[i])
						//b = (x[j], y[j])
						long dist = (posX[i] - posX[j]) * (posX[i] - posX[j]) +
								(posY[i] - posY[j]) * (posY[i] - posY[j]);
						ts.add(new Node(i,j,dist));
						ts.add(new Node(j,i,dist));
					}
				}
			}
			
			for(Node node: ts) {
				union(node);
				if(edge_select == n-1) {
					break;
				}
			}
			double p = Double.parseDouble(br.readLine().trim());
			long ans = Math.round(result*p);
			System.out.println("#"+t+" "+ans);
		}
	}
	
}
