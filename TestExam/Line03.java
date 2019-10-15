package com.ssafy.git.TestExam;

import java.util.Arrays;
import java.util.Scanner;

public class Line03 {
	static int n;
	static toilet[] tt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		tt = new toilet[n];
		for(int i=0;i<n;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			tt[i] = new toilet(s, e); 
		}
		Arrays.sort(tt);
		for(toilet ttt : tt) {
			System.out.println(ttt.start + "~" + ttt.end);
		}
	}
	static class toilet implements Comparable<toilet>{
		int start;
		int end;
		public toilet(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(toilet o) {
			// TODO Auto-generated method stub
			if(this.end == o.end) {
				if(this.start < o.start) {
					return -1;
				} else {
					return 1;
				}
			}else {
				return this.end < o.end ? -1 : 1;
			}
		}
		
	}
}
