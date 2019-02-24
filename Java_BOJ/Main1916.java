package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main1916 {
	public static String[] line;
	public static ArrayList<node>[] map;
	public static int n,m, start, end;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine().trim());
		m = Integer.parseInt(br.readLine().trim());
		map = new ArrayList[n+1];
		for(int i=1;i<=n;i++){
			map[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++){
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int c = Integer.parseInt(line[2]);
			map[a].add(new node(c,b));
		}
		line = br.readLine().split(" ");
		start = Integer.parseInt(line[0]);
		end = Integer.parseInt(line[1]);
		bw.write(dijkstra()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	public static String dijkstra(){
		int[] distance = new int[n+1];
		Arrays.fill(distance, 99999999);
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(0,start));
		distance[start] = 0;
		
		while(!pq.isEmpty()){
			node cur = pq.poll();
			if(distance[cur.dest] < cur.cost){
				continue;
			}
			for(int i=0;i<map[cur.dest].size();i++){
				int updateCost = distance[cur.dest] + map[cur.dest].get(i).cost;
				int originCost = distance[map[cur.dest].get(i).dest];
				if(originCost > updateCost){
					distance[map[cur.dest].get(i).dest] = updateCost;
					pq.add(new node(updateCost, map[cur.dest].get(i).dest));
				}
			}
		}
		return Integer.toString(distance[end]);
	}
 	static class node implements Comparable<node>{
		int cost;
		int dest;
		public node(int cost, int dest) {
			this.cost = cost;
			this.dest = dest;
		}
		@Override
		public int compareTo(node other) {
			// TODO Auto-generated method stub
			return other.cost - cost;
		}
	}
	
}
