package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution3503_D5_초보자점프대 {
	public static int n;//5 ~ 10,000
	public static int[] arr;
	public static int[] pan;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			pan = new int[n];
			String[] line = br.readLine().split(" ");
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(line[i]);
			}
			Arrays.sort(arr);
			int l = 0; int r = n-1;
			for(int i=0;i<n;i++) {
				if(i%2==0) {
					pan[l] = arr[i];
					l++;
				}
				else {
					pan[r] = arr[i];
					r--;
				}
			}
//			for(int i=0;i<n;i++) {
//				System.out.print(pan[i]+" ");
//			}
//			System.out.println();
			int diff = 0;
			for(int i=0;i<n;i++) {
				if(i==n-1) {
					diff = diff < Math.abs(pan[i] - pan[0]) ? Math.abs(pan[i] - pan[0]) : diff; 
				}
				else {
					diff = diff < Math.abs(pan[i] - pan[i+1]) ? Math.abs(pan[i] - pan[i+1]) : diff;
				}
			}
			System.out.println("#"+t+" "+diff);
		}
	}

}
