package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main2651 {
	public static int t,n;
	public static String[] line;
	public static int[] dist, tArr, d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine().trim());
		n = Integer.parseInt(br.readLine().trim());
		dist = new int[n+2];
		tArr = new int[n+2];
		d = new int[n+2];
		
		line = br.readLine().trim().split(" ");
		for(int i=1;i<=n+1;i++) {
			dist[i] = dist[i-1] + Integer.parseInt(line[i-1]);
		}

		line = br.readLine().trim().split(" ");
		for(int i=1;i<=n;i++) {
			tArr[i] = Integer.parseInt(line[i-1]);
		}
		
		Arrays.fill(d, 999999999);
		go();
	}
	public static void go() {
		d[0] = 0;
		for(int i=1;i<=n+1;i++) {
			for(int j=i-1;j>=0;j--) {
				if(dist[i] - dist[j] <= t) {
					if(d[i] > d[j] + tArr[i]) {
						d[i] = d[j] + tArr[i];
					}
				}
			}
		}
		System.out.println(d[n+1]);
		
		Stack<Integer> s = new Stack<>();
		int pointer = n; int val = d[n+1];
		while(true) {
			if(pointer == 0) {
				break;
			}
			if(d[pointer] == val) {
				s.add(pointer);
				val = val - tArr[pointer];
				pointer--;
			}
			else {
				pointer--;
			}
		}
		System.out.println(s.size());
		while(!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}
		System.out.println();
	}
}
