package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1256_D5_kthPost {
	public static String input;
	public static int k;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			k = Integer.parseInt(br.readLine().trim());
			input = br.readLine().trim();
			int size = input.length();
			String[] postpone = new String[size];
			for(int i=0;i<size;i++) {
				postpone[i] = input.substring(i, size);
			}
			Arrays.sort(postpone);
			System.out.println("#"+t+" "+postpone[k-1]);
		}
	}

}
