package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1325 {
	public static String[] line;
	public static ArrayList<Integer>[] map = (ArrayList<Integer>[]) new ArrayList[10001];
	public static int[] list = new int[10001];
	public static int n,m, max;
	public static boolean[] visited = new boolean[10001];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		
		for(int i=1;i<=n;i++) {
			map[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++) {
			line = br.readLine().split(" ");
			map[Integer.parseInt(line[1])].add(Integer.parseInt(line[0]));
		}
		for(int i=1;i<=n;i++) {
			visited = new boolean[10001];
			dfs(i);
		}
		for(int i=1;i<=n;i++) {
			if(max < list[i]) {
				max = list[i];
			}
		}
		for(int i=1;i<=n;i++) {
			if(list[i]==max) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb.toString().trim());
	}
	public static void dfs(int v) {
		//visited[v] = true;
		for(int nv : map[v]) {
			if(!visited[nv]) {
				list[nv]++;
				visited[nv] = true;
				dfs(nv);
			}
		}
	}
}
