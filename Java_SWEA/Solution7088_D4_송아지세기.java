package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution7088_D4_송아지세기 {
	public static String[] line;
	public static int n,q;
	public static int[][] numSet;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			line = br.readLine().trim().split(" ");
			n = Integer.parseInt(line[0]);
			q = Integer.parseInt(line[1]);
			numSet = new int[n+1][4];
			for(int i=1;i<=n;i++) {
				int number = Integer.parseInt(br.readLine().trim());
				numSet[i][1] = numSet[i-1][1];
				numSet[i][2] = numSet[i-1][2];
				numSet[i][3] = numSet[i-1][3];
				numSet[i][number]++;
			}
			bw.write("#"+t+" "+"\n");
			for(int i=0;i<q;i++) {
				line = br.readLine().trim().split(" ");
				int l = Integer.parseInt(line[0]);
				int r = Integer.parseInt(line[1]);
				bw.write((numSet[r][1] - numSet[l-1][1]) + " " + 
					(numSet[r][2] - numSet[l-1][2]) + " " + (numSet[r][3] - numSet[l-1][3])+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
