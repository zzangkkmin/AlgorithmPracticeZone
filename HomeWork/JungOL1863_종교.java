package com.ssafy.git.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JungOL1863_종교 {
	public static int[] parent;
	public static String[] line;
	public static int n,m, ans;//n~50000, m~100000
	public static int[] religion;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		parent = new int[n+1];
		religion = new int[n+1];
		for(int i=0;i<=n;i++) {
			parent[i] = i;
		}
		for(int i=0;i<m;i++) {
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			unionSet(a,b);
		}
		for(int i=1;i<=n;i++) {
			religion[findSet(i)]++;
		}
		for(int i=1;i<=n;i++) {
			if(religion[i] != 0) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	public static void unionSet(int u, int v) {
		if(u<v) {
			int temp  = u;
			u = v;
			v = temp;
		}
		parent[findSet(u)] = findSet(v);
	}
	public static int findSet(int v) {
		if(parent[v] == v) {
			return v;
		}
		parent[v] = findSet(parent[v]);
		return parent[v];
	}
}
