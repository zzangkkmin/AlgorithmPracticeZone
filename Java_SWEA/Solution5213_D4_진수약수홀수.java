package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution5213_D4_진수약수홀수 {
	public static String[] line;
	public static ArrayList<Integer> plist = new ArrayList<>();
	public static long[] sumz = new long[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine().trim());
		//
		init();
		for(int t=1;t<=tc;t++) {
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			bw.write("#"+t+" "+(sumz[b] - sumz[a-1])+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void init() {
		long[] arr = new long[1000001];
//		for(int i=1;i<=1000000;i=i+2) {
//			for(int j=1;j<=1000000/i;j++) {
//				arr[i*j]+=i;
//			}
//		}
		//another way
		Arrays.fill(arr, 1);
		for(int i=3;i<=1000000;i=i+2) {
			for(int j=i;j<=1000000;j=j+i) {
				arr[j]+=i;
			}
		}
		for(int i=1;i<=1000000;i++) {
			sumz[i] = sumz[i-1] + arr[i];
		}
	}
}



