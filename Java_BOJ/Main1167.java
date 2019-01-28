package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1167 {
	public static ArrayList<Integer[]>[] al;
	public static boolean[] visited;
	public static int[] sum;
	public static int sMax, sPos;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		al = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			al[i] = new ArrayList<Integer[]>();
		}
		for(int i=0;i<n;i++) {
			String[] line = br.readLine().split(" ");
			int fromA = Integer.parseInt(line[0]);
			for(int j = 1; j < line.length - 1; j = j + 2) {
				int toB = Integer.parseInt(line[j]);
				int val = Integer.parseInt(line[j + 1]);
				Integer[] atob = {toB,val};
				Integer[] btoa = {fromA,val};
				al[fromA].add(atob);
				al[toB].add(btoa);
			}
//			while(true) {
//				int toB = sc.nextInt();
//				if(toB == -1) {
//					break;
//				}
//				int val = sc.nextInt();
//				Integer[] atob = {toB,val};
//				Integer[] btoa = {fromA,val};
//				al[fromA].add(atob);
//				al[toB].add(btoa);
//			}
		}
		visited = new boolean[n+1];
		sum = new int[n+1];
		find(1,n);
		Arrays.fill(visited, false);
		Arrays.fill(sum, 0);
		sMax = 0;
		find(sPos,n);
		//ret = find(ret[0],n);
		System.out.println(sMax);
	}
	public static void find(int start, int n) {
		Queue<Integer> q = new LinkedList<>();
		//Integer[] ret = {0,0};
//		visited[start] = true;
//		for(Integer[] qi : al[start]) {
//			q.add(qi);
//		}
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(Integer[] qi : al[cur]) {
				if(visited[qi[0]] == false) {
					q.add(qi[0]);
					visited[qi[0]] = true;
					sum[qi[0]] += (sum[cur] + qi[1]);
					if(sum[qi[0]] > sMax) {
						sMax = sum[qi[0]];
						sPos = qi[0];
					}
				}
			}
		}
		//return ret;
	}

}
