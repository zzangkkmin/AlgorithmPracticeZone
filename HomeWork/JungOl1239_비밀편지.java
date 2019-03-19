package com.ssafy.git.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JungOl1239_비밀편지 {
	public static int n;
	public static String[] strs;
	public static String[] abc = {
		"000000","001111","010011","011100",
		"100110","101001","110101","111010"
	};
	public static String line, res;
	public static boolean error;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		line = br.readLine().trim();
		strs = new String[n];
		for(int i=0;i<n;i++) {
			strs[i] = line.substring(i*6, i*6+6);
		}
		res = "";
		for(int i=0;i<n;i++) {
			comp(strs[i]);
			if(error) {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println(res);
	}
	public static void comp(String s) {
		int[] diff = new int[8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<6;j++) {
				if(abc[i].charAt(j) != s.charAt(j)) {
					diff[i]++;
				}
			}
		}
		int abcIdx = -1;
		for(int i=0;i<8;i++) {
			if(diff[i] < 2) {
				abcIdx = i;
				break;
			}
		}
		if(abcIdx==-1) {
			error = true;
			return;
		}
		else {
			char val = (char)('A' + abcIdx);
			res = res + val;
		}
	}
}
