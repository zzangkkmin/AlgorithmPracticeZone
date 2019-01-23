package com.ssafy.swe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution6742_D7_삼각형넓이 {
//	static class Node{
//		private int x;
//		private int y;
//		Node(int x, int y){
//			this.x = x;
//			this.y = y;
//		}
//		int getX() {
//			return x;
//		}
//		int getY() {
//			return y;
//		}
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int T = 1; T<= test_case; T++) {
			int Ans = 0;
			int N = sc.nextInt();
			int A = sc.nextInt();
			double start = A / 2.0;
			int B = sc.nextInt();
			double end = B / 2.0;
			
			//System.out.println("A:"+start+" B:"+end);
			//Node[] nn = new Node[N];
			long[] xx = new long[N];
			long[] yy = new long[N];
			for(int i=0;i<N;i++) {
				xx[i] = sc.nextLong();
				yy[i] = sc.nextLong();
			}
			
			for(int a=0;a<N-2;a++) {
				for(int b=a+1;b<N-1;b++) {
					for(int c=b+1;c<N;c++) {
						long sum = Math.abs(
							(xx[b] - xx[a]) * (yy[c] - yy[a]) -
							(xx[c] - xx[a]) * (yy[b] - yy[a])
						) / 2;
						//System.out.println("area" + sum);
						if(sum>=start && sum <= end) {
							Ans++;
						}
					}
				}
			}
			
			System.out.println("#"+T+" "+Ans);
		}
	}

}
