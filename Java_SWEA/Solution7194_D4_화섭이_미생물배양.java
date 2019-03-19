package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution7194_D4_화섭이_미생물배양 {
	public static String[] line;
	public static int s,t,a,b,ans;
	public static boolean find;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int T=1;T<=tc;T++) {
			ans = Integer.MAX_VALUE;
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
		while(true) {
			if(ct==s) {
				break;
			}
			if(ct<s) {
				return -1;
			}
			if(ct % b == 0 && ct / b >= s) {
				ct = ct / b;
				cnt++;
			}
			else {
				int tModB = ct % b;
				int aModB = a % b;
				if(aModB == 0) {
					if(ct - a >= s) {
						ct = ct - a;
						cnt++;
					}
					else {
						return -1;
					}
				}
				else {
					if(tModB % aModB == 0) {
						int K = (tModB / aModB);
						ct = ct - K * a;
						cnt = cnt + K;
					}
					else {
						return -1;
					}
				}
			}
		}
		return cnt;
	}
}
