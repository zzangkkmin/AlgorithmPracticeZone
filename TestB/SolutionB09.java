package com.ssafy.git.TestB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//SWEA 4007. [Professional] 간담회 참석
public class SolutionB09 {
	static final int INF = 999999999;
	static int n,m,x;
	static int ans;
	static class node{
		int cost;
		int dest;
		public node(int cost, int dest) {
			super();
			this.cost = cost;
			this.dest = dest;
		}
		@Override
		public String toString() {
			return "node [cost=" + cost + ", dest=" + dest + "]";
		}
		
	}
	static ArrayList<node>[] edge = new ArrayList[50000+1];
	static int[] distGo = new int[50000+1];
	static int[] distBack = new int[50000+1];
	static PriorityQueue<node> pq = new PriorityQueue<>(new comparatorPQ());
	static class comparatorPQ implements Comparator<node>{

		@Override
		public int compare(node o1, node o2) {
			// TODO Auto-generated method stub
			if(o1.cost < o2.cost) {
				return -1;
			}else {
				return 1;
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			ans = 0;
			String[] str = br.readLine().trim().split(" ");
			n = Integer.parseInt(str[0]);//~ 50,000
			m = Integer.parseInt(str[1]);//~ 500,000
			x = Integer.parseInt(str[2]);
			
			for(int i=0;i<=n;i++) {
				edge[i] = new ArrayList<node>();
			}
			
			for(int i=0;i<m;i++) {
				str = br.readLine().trim().split(" ");
				int s = Integer.parseInt(str[0]);
				int e = Integer.parseInt(str[1]);
				int t = Integer.parseInt(str[2]);
				edge[s].add(new node(t, e));
			}
			
			dijkstra(x);
			for(int i=1;i<=n;i++) {
				if(i==x) continue;
				dijkstra(i);
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	static void dijkstra(int num) {
		for(int i=0;i<=n;i++) {
			distGo[i] = INF;
		}
		pq.clear();
		distGo[num] = 0;
		pq.add(new node(0, num));
		while(!pq.isEmpty()) {
			node cur = pq.poll();
			int curCost = cur.cost;
			int curVertex = cur.dest;
			if(distGo[curVertex] < curCost) {
				continue;
			}
			for(int i=0;i<edge[curVertex].size(); i++) {
				int nextVertax = edge[curVertex].get(i).dest;
				int originCost = distGo[nextVertax];
				int updateCost = curCost + edge[curVertex].get(i).cost;
				if(updateCost < originCost) {
					distGo[nextVertax] = updateCost;
					pq.add(new node(updateCost, nextVertax));
				}
			}
		}
		if(num == x) {
			for(int i=0;i<=n;i++) {
				distBack[i] = distGo[i];
			}
		}
		if(ans < distBack[num] + distGo[x]) {
			ans = distBack[num] + distGo[x];
		}
	}
}
