package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16987 {
	public static String[] line;
	public static int[][] egg;
	public static boolean[] broken;
	public static int ans, n;//1~8
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		egg = new int[n][2];
		broken = new boolean[n];
		for(int i=0;i<n;i++) {
			line = br.readLine().split(" ");
			egg[i][0] = Integer.parseInt(line[0]);//내구도 = 체력
			egg[i][1] = Integer.parseInt(line[1]);//무게 = 공격력
		}
		crunch(0);
		System.out.println(ans);
	}
	public static void crunch(int idx) {
		if(idx==n) {
			int temp = 0;
			for(int i=0;i<n;i++) {
				if(broken[i])
					temp++;
			}
			ans = ans < temp ? temp : ans;
			return;
		}
		else {
			int bb = 0;
			if(broken[idx]==true) {
				crunch(idx+1);
			}
			else {
			for(int i=0;i<n;i++) {
				if(i==idx)
					continue;
				if(broken[i]==false) {
					int OriginCurHP = egg[idx][0];
					int OriginCurAP = egg[idx][1];
					int OriginTarHP = egg[i][0];
					int OriginTarAP = egg[i][1];
					
					int CrackCurHP = egg[idx][0] - OriginTarAP;
					int CrackTarHP = egg[i][0] - OriginCurAP;
					
					if(CrackCurHP <= 0) {
						egg[idx][0] = 0;
						broken[idx] = true;
					}
					else {
						egg[idx][0] = CrackCurHP;
					}
					if(CrackTarHP <= 0) {
						egg[i][0] = 0;
						broken[i] = true;
					}
					else {
						egg[i][0] = CrackTarHP;
					}
					crunch(idx+1);
					
					if(broken[idx]==true) {
						egg[idx][0] = OriginCurHP;
						broken[idx] = false;
					}
					else {
						egg[idx][0] = OriginCurHP;
					}
					if(broken[i]==true) {
						egg[i][0] = OriginTarHP;
						broken[i] = false;
					}
					else {
						egg[i][0] = OriginTarHP;
					}
				}
				else {
					bb++;
				}
			}
			}
			if(bb == n - 1) {
				crunch(idx+1);
			}
		}
	}
}
