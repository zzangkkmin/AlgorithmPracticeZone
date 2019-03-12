package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main15970 {
	public static int n;
	public static ArrayList<Integer>[] colorList;
	public static String[] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		colorList = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			colorList[i] = new ArrayList<>();
		}
		for(int i=0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			int point = Integer.parseInt(line[0]);
			int color = Integer.parseInt(line[1]);
			colorList[color].add(point);
		}
		for(int i=1;i<=n;i++) {
			Collections.sort(colorList[i]);
		}
		System.out.println(Check());
	}
	public static int Check() {
		int dist = 0;
		for(int i=1;i<=n;i++) {
			int size = colorList[i].size();
			for(int idx = 0;idx<size;idx++) {
				if(idx==0) {
					dist += colorList[i].get(idx+1) - colorList[i].get(idx);
				}
				else if(idx==size-1) {
					dist += colorList[i].get(idx) - colorList[i].get(idx-1);
				}
				else {
					dist += Math.min(colorList[i].get(idx+1) - colorList[i].get(idx), 
							colorList[i].get(idx) - colorList[i].get(idx-1));
				}
			}
		}
		return dist;
	}
}
