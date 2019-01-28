package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution1225_D3_암호생성 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int tt = sc.nextInt();
			int[] arr = new int[8];
			for(int i=0;i<8;i++) {
				arr[i] = sc.nextInt();
			}
			int idx = 0; int minus = 1;
			while(true) {
				arr[idx] = arr[idx] - minus;
				if(arr[idx] <= 0) {
					idx = (idx + 1) % 8;
					System.out.print("#" + t);
					for(int i = idx, k = 0; k<8; i = (i + 1) % 8, k++) {
						System.out.print(" " + (arr[i]<0?0:arr[i]));
					}
					System.out.println();
					break;
				}
				idx = (idx + 1) % 8;
				minus = (minus + 1) % 5;
				if(minus==0)
					minus = 5;
			}
			
		}
	}

}
