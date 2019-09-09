package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main2916 {
	public static int N,K;
	public static int[] knownAngle, angleList;
	public static int[][] d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); knownAngle = new int[N];
		K = sc.nextInt();
		for(int i=0;i<N;i++) {
			knownAngle[i] = sc.nextInt();
		}
		angleList = new int[361];
		d = new int[N+1][361];
		
		setting(0,0);
		
		for(int i=0;i<K;i++) {
			int req = sc.nextInt();
			if(angleList[req] == 1) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	public static void setting(int idx, int angle) {
		if(idx >= N || d[idx][angle] == 1) {
			return;
		}
		d[idx][angle] = 1;
		angleList[angle] = 1;
		
		setting(idx, (angle - knownAngle[idx] + 360) % 360);
		setting(idx, (angle + knownAngle[idx] + 360) % 360);
		setting(idx + 1, angle);
	}
}
