package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5557 {
	public static int n;
	public static int[] arr;
	public static long[][] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		arr = new int[n+1];
		//d[i=1~n][j=1~20]: i개의 수를 이용, j를 만드는 방법
		d = new long[n+1][21];
		
		String[] line = br.readLine().split(" ");
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(line[i-1]);
		}
		d[0][arr[0]] = 1;
		for(int i=1;i<n;i++) {
			for(int j=0;j<=20;j++) {
				
			}
		}
	}

}
