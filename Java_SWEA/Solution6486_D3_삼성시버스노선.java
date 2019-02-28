package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6486_D3_삼성시버스노선 {
	public static int n, p, q;
	public static String[] line;
	public static int[] busStop;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			busStop = new int[5001];
			n = Integer.parseInt(br.readLine().trim());
			for(int i=0;i<n;i++) {
				line = br.readLine().split(" ");
				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				for(int j=a;j<=b;j++) {
					busStop[j]++;
				}
			}
			System.out.print("#"+t+" ");
			p = Integer.parseInt(br.readLine().trim());
			for(int i=0;i<p;i++) {
				q = Integer.parseInt(br.readLine().trim());
				System.out.print(busStop[q]+" ");
			}
			System.out.println();
		}
	}

}
