package com.ssafy.swe;

import java.util.Scanner;

public class Solution4796_D4_우뚝산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int T = 1; T<=test_case ; T++) {
			int N = sc.nextInt();
			int[] data = new int[N];
			for(int i=0;i<N;i++) {
				data[i] = sc.nextInt();
			}
			int mode = 0;
			int left = 0;
			int right = 0;
			int sum = 0;
			for(int i=0;i<N-1;i++) {
				if(mode==0) {//init
					if(data[i] < data[i+1]) {
						mode = 1;
						left = 1;
					}
					else {
						mode = -1;
						right = 1;
					}
				}
				else if(mode==1) {//go-up
					if(data[i] < data[i+1]) {//to-up
						left++;
					}
					else {//to-down
						mode = -1;
						right = 1;
					}
					if(i+1==N-1) {
						sum+=left*right;
					}
				}
				else if(mode==-1) {//go-down
					if(data[i] > data[i+1]) {//to-down
						right++;
					}
					else {//to-up
						mode = 1;
						sum += right * left;
						left = 1;
						right = 0;
					}
					if(i+1==N-1) {
						sum+=left*right;
					}
				}
			}
			System.out.println("#" + T + " " + sum);
		}
	}

}
