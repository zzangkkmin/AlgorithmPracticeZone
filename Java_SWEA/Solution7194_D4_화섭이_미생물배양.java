package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution7194_D4_화섭이_미생물배양 {
	public static String[] line;
	public static int s,t,a,b;
	public static boolean find;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int T=1;T<=tc;T++) {
			line = br.readLine().trim().split(" ");
			s = Integer.parseInt(line[0]);
			t = Integer.parseInt(line[1]);
			a = Integer.parseInt(line[2]);
			b = Integer.parseInt(line[3]);
			System.out.println("#"+T+" "+back(t));
		}
	}
	public static int back(int ct) {
		int cnt = 0;
		if(b==1) {
			if(s>ct) {
				return -1;
			}else {
				if((ct-s)%a==0) {
					return (ct-s)/a;
				}else {
					return -1;
				}
			}
		}
		while(true) {
			if(ct==s) {
				break;
			}
			if(ct % b == 0 && ct / b >= s) {
				ct = ct / b;
				cnt++;
			}
			else if(ct - a >= s) {
				ct = ct - a;
				cnt++;
			}
			else {
				return -1;
			}
		}
		return cnt;
	}
}
