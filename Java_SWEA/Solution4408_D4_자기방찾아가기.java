package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4408_D4_자기방찾아가기 {
	public static int n, ans;
	public static int[] arr;
	public static String[] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = 0;
			n = Integer.parseInt(br.readLine().trim());
			arr = new int[201];
			for(int i=0;i<n;i++) {
				line = br.readLine().split(" ");
				int a = Integer.parseInt(line[0]);
				a = (a%2 == 1 ? a/2+1 : a/2);
				int b = Integer.parseInt(line[1]);
				b = (b%2 == 1 ? b/2+1 : b/2);
				if(a>b) {
					int temp = b;
					b = a;
					a = temp;
				}
				for(int j=a;j<=b;j++) {
					arr[j]++;
					ans = arr[j] > ans ? arr[j] : ans;
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}

}
