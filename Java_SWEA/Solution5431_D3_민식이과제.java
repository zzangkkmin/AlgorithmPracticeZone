package com.ssafy.git.Java_SWEA;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution5431_D3_민식이과제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int K = sc.nextInt();
			boolean[] non = new boolean[N+1];
			for(int i=0;i<K;i++) {
				int hw = sc.nextInt();
				non[hw] = true;
			}
			System.out.print("#" + test_case + " ");
			for(int i=1;i<=N;i++) {
				if(non[i] == false) {
					System.out.print(i+" ");
				}
			}
			System.out.println("");
		}
	}

}
