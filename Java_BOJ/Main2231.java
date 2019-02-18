package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main2231 {
	public static int maxx = 20000*20000+20000*20000+1;
	public static int n, ans;
	public static node[] arr;
	public static String[] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		arr = new node[n];
		ans = maxx;
		for(int i=0;i<n;i++) {
			line = br.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			arr[i] = new node(x,y);
		}
		Arrays.sort(arr, compareX);
		System.out.println();
	}
	public static class node{
		int x;
		int y;
		node(int x, int y){
			this.x = x;
			this.y = y;
		}
		int getX() {
			return x;
		}
		int getY() {
			return y;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("node [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append("]");
			return builder.toString();
		}
		
	}
	static Comparator<node> compareX = new Comparator<node>() {
		@Override
		public int compare(node a, node b) {
			// TODO Auto-generated method stub
			return a.getX() - b.getX();
		}
	};
	static Comparator<node> compareY = new Comparator<node>() {
		@Override
		public int compare(node a, node b) {
			// TODO Auto-generated method stub
			return a.getY() - b.getY();
		}
	};
	public static int dist(node x, node y) {
		return (x.getX()-y.getX()) * (x.getX()-y.getX()) +
				(x.getY()-y.getY()) * (x.getY()-y.getY());
	}
	public static int solve(int start, int end) {
		int res = maxx;
		int size = end - start + 1;
		if(size <= 3) {
			for(int i=start; i<end; i++) {
				for(int j=i+1; j<=end; j++) {
					int d = dist(arr[i],arr[j]);
					res = res > d ? d : res;
				}
			}
			return res;
		}
		else {
			int mid = (start + end) / 2;
			int left = solve(start, mid-1);
			int right = solve(mid+1,end);
			int MinLR = left > right ? right : left;
			res = MinLR < res ? MinLR : res;
			
			return res;
		}
	}
}
