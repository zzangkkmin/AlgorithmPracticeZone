package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2643 {
	public static int n;
	public static String[] ab;
	public static paper[] arr;
	public static int[] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		arr = new paper[n];
		d = new int[n];
		for(int i=0;i<n;i++) {
			ab = br.readLine().trim().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			if(b>a) {
				arr[i] = new paper(b, a);
			}else {
				arr[i] = new paper(a, b);
			}
		}
		Arrays.sort(arr);
		//System.out.println("pause");
		int result = 0;
		for(int i=0;i<n;i++) {
			int cx = arr[i].x; int cy = arr[i].y;
			for(int j=i+1;j<n;j++) {
				int nx = arr[j].x; int ny = arr[j].y;
				if(cx >= nx && cy >= ny && d[i]+1 > d[j]) {
					d[j] = d[i] + 1;
				}
			}
		}
		for(int i=0;i<n;i++) {
			result = result < d[i] ? d[i] : result;
		}
		System.out.println(result+1);
	}
	public static class paper implements Comparable<paper>{
		int x; int y; int size;

		public paper(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.size = x*y;
		}

		@Override
		public int compareTo(paper o) {
			// TODO Auto-generated method stub
			if(this.size < o.size) {
				return 1;
			}
			else if(this.size == o.size) {
				if(this.x < o.x) {
					return 1;
				}
				else if(this.x == o.x) {
					if(this.y < o.y) {
						return 1;
					}
					else if(this.y == o.y) {
						return 0;
					}
					else {
						return -1;
					}
				}
				else {
					return -1;
				}
			}
			else {
				return -1;
			}
		}
		
	}
}
