package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main8982 {
	static point[] arr;
	static int[] deep;
	static int n, k, maxwidth;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//1~5000
		arr = new point[n];
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[i] = new point(x, y);
			if(i==n-1) {
				maxwidth = x - 1;
			}
		}
		deep = new int[maxwidth+1];
		readPoint();
		k = sc.nextInt();//1~n/2
		for(int i=0;i<k;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			//b=d
			sink(a,deep[a]);
		}
		int ans = 0;
		for(int d : deep) {
			ans += d;
		}
		System.out.println(ans);
	}
	static class point{
		int x; int y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("point [x=").append(x).append(", y=").append(y).append("]");
			return builder.toString();
		}
	}
	public static void readPoint() {
		for(int i=1;i<n-1;i=i+2) {
			int ax = arr[i].x; int ay = arr[i].y;
			int bx = arr[i+1].x; int by = arr[i+1].y;
			for(int w = ax; w<bx; w++) {
				deep[w] = ay;
			}
		}
	}
	public static void sink(int w, int depth) {
		deep[w] = 0;
		int nw = w - 1;
		int curdepth = depth;
		while(true) {
			if(nw<0) {
				break;
			}
			if(deep[nw] < curdepth) {
				curdepth = deep[nw];
				deep[nw] = 0;
			}
			else {
				deep[nw] = deep[nw] - curdepth;
			}
			nw = nw - 1;
		}
		nw = w + 1;
		curdepth = depth;
		while(true) {
			if(nw>maxwidth) {
				break;
			}
			if(deep[nw] < curdepth) {
				curdepth = deep[nw];
				deep[nw] = 0;
			}
			else {
				deep[nw] = deep[nw] - curdepth;
			}
			nw = nw + 1;
		}
	}
}
