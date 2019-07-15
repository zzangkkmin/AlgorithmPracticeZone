package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main17142 {
	static int n,m;
	static String[] readLine;
	static int[][] map;
	static node[] virus;
	static int vIdx = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		readLine = br.readLine().trim().split(" ");
		n = Integer.parseInt(readLine[0]);
		m = Integer.parseInt(readLine[1]);
		map = new int[n][n];
		virus = new node[10];
		for(int i=0;i<n;i++) {
			readLine = br.readLine().trim().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(readLine[j]);
				if(map[i][j] == 2) {
					virus[vIdx++] = new node(i,j);
				}
			}
		}
		
	}
	static public void select(int idx, int selectCnt) {
		if(selectCnt == m) {
			spread();
		}
		else if(idx == vIdx) {
			return;
		}
		else {
			virus[idx].selected = true;
			select(idx + 1, selectCnt + 1);
			virus[idx].selected = false;
			select(idx + 1, selectCnt);
		}
	}
	static public void spread() {
		Queue<node> q = new LinkedList<node>();
		
		for(node v : virus) {
			if(v.selected == true) {
				
			}
		}
	}
	static public class node{
		int x;
		int y;
		boolean selected;
		public node() {
			super();
			// TODO Auto-generated constructor stub
		}
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.selected = false;
		}
		@Override
		public String toString() {
			return "node [x=" + x + ", y=" + y + "]";
		}
	}
}
