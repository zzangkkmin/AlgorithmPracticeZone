package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Solution3000_D4_중간값 {
	public static int n;//1~200,000
	public static long a, sum;//1~1,000,000,000
	public static String[] line;
	public static TreeSet<Long> arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			sum = 0;
			line = br.readLine().trim().split(" ");
			n = Integer.parseInt(line[0]);
			a = Long.parseLong(line[1]);
			arr = new TreeSet<>();
			arr.add(a);
			for(int i=0;i<n;i++) {
				line = br.readLine().trim().split(" ");
				long b1 = Long.parseLong(line[0]);
				long b2 = Long.parseLong(line[1]);
				arr.add(b1); arr.add(b2);
				sum += (long) arr.toArray()[i+1];
			}
			System.out.println("#"+t+" "+sum);
		}
	}

}
