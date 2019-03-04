package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main16938 {
	public static String[] line;
	public static int[] arr;
	public static boolean[] select;
	public static int n,l,r,x, ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		l = Integer.parseInt(line[1]);
		r = Integer.parseInt(line[2]);
		x = Integer.parseInt(line[3]);
		arr = new int[n];
		select = new boolean[n];
		
		line = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		find(0,0);
		System.out.println(ans);
	}
	public static void find(int idx, int cnt) {
		if(idx==n) {
			if(cnt>=2) {
				int sum = 0; 
				int maxx = -1;
				int minn = 1000000001;
				for(int i=0;i<n;i++) {
					if(select[i]) {
						sum += arr[i];
						maxx = maxx < arr[i] ? arr[i] : maxx;
						minn = minn > arr[i] ? arr[i] : minn;
					}
				}
				if(sum >= l && sum <= r && maxx - minn >= x) {
					ans++;
				}
				return;
			}
			else {
				return;
			}
		}
		else {
			select[idx] = true;
			find(idx+1,cnt+1);
			select[idx] = false;
			find(idx+1,cnt);
		}
	}
}
