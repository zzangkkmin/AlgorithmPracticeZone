package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution6719_D4_프로그래밍시청 {
	public static double ans;
	public static int n,k;
	public static int[] arr;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = 0;
			String[] line = br.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			k = Integer.parseInt(line[1]);
			arr = new int[n];
			line = br.readLine().split(" ");
			for(int i = 0; i <n;i++) {
				arr[i] = Integer.parseInt(line[i]);
			}
			Arrays.sort(arr);
			for(int i = n-k;i<n;i++) {
				ans = (ans + arr[i]) / 2;
			}
			System.out.print("#"+t+" ");
			System.out.printf("%.6f\n",ans);
		}
	}

}
