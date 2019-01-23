package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main1967 {
	public static ArrayList<Integer[]>[] al;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		al = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			al[i] = new ArrayList<Integer[]>();
		}
		for(int i=1;i<n;i++) {
			String[] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int val = Integer.parseInt(line[2]);
			Integer[] atob = {b,val};
			Integer[] btoa = {a,val};
			al[a].add(atob);
			al[b].add(btoa);
		}
		//System.out.println("pause");
		Integer[] ret = find(1,n);
		ret = find(ret[0],n);
		System.out.println(ret[1]);
	}
	public static Integer[] find(int start, int n) {
		Queue<Integer[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		Integer[] ret = {0,0};
		visited[start] = true;
		for(Integer[] qi : al[start]) {
			q.add(qi);
		}
		while(!q.isEmpty()) {
			Integer[] cur = q.poll();
			int curN = cur[0];
			int curVal = cur[1];
			if(ret[1]<curVal) {
				ret[0] = curN;
				ret[1] = curVal;
			}
			visited[curN] = true;
			for(Integer[] qi : al[curN]) {
				if(visited[qi[0]] == false) {
					Integer[] temp = {qi[0], qi[1] + curVal};
					q.add(temp);
				}
			}
		}
		return ret;
	}
}
