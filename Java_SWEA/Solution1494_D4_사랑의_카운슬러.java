package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1494_D4_사랑의_카운슬러 {
	public static int n;
	public static long ans;
	public static long[][] vertax;
	public static boolean[] selected;
	public static String[] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = Long.MAX_VALUE;
			n = Integer.parseInt(br.readLine().trim());
			vertax = new long[n][2];
			selected = new boolean[n];
			for(int i=0;i<n;i++) {
				line = br.readLine().split(" ");
				vertax[i][0] = Long.parseLong(line[0]);
				vertax[i][1] = Long.parseLong(line[1]);
			}
			find(0,0);
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void find(int cnt, int idx) {
		if(cnt == n/2) {
			long x = 0; long y = 0;
			long sum = 0;
			for(int i=0;i<n;i++) {
				if(selected[i] == true) {
					x += vertax[i][0];
					y += vertax[i][1];
				}
				else {
					x -= vertax[i][0];
					y -= vertax[i][1];
				}
			}
			sum = x*x + y*y;
			ans = ans > sum ? sum : ans;
			return;
		}
		else if(idx == n) {
			return;
		}
		else {
			selected[idx] = true;
			find(cnt+1,idx+1);
			selected[idx] = false;
			find(cnt,idx+1);
		}
	}
}
