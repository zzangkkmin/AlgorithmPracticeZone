package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution3074_D4_입국심사 {
	public static long n,m, minT;
	public static long[] arr;
	public static String[] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			minT = Long.MAX_VALUE;
			line = br.readLine().trim().split(" ");
			n = Long.parseLong(line[0]);
			m = Long.parseLong(line[1]);
			arr = new long[(int)n];
			for(int i=0;i<n;i++) {
				arr[i] = Long.parseLong(br.readLine().trim());
				minT = Math.max(arr[i], minT);
			}
			long s = 1;
			long e = minT * m;
			while(s<=e) {
				long mid = (s+e)/2;
				long tempM = 0;
				for(long dt : arr) {
					tempM += (mid / dt);
				}
				if(tempM < m) {
					s = mid + 1;
				}
				else {
					e = mid - 1;
				}
			}
			System.out.println("#"+t+" "+s);
		}
	}

}
