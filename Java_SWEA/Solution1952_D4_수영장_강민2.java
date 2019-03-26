package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1952_D4_수영장_강민2 {
	public static int d, m1, m3, y, ans;
	public static String[] linez;
	public static int[] plan, md, m3mode;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = Integer.MAX_VALUE;
			plan = new int[12+1];	//월별 이용 계획 일자
			md = new int[15];		//월별 최소 이용 값
			
			linez = br.readLine().trim().split(" ");
			d = Integer.parseInt(linez[0]);		//일일 이용권
			m1 = Integer.parseInt(linez[1]);	//월별 이용권
			m3 = Integer.parseInt(linez[2]);	//3달 이용권
			y = Integer.parseInt(linez[3]);		//연간 이용권
			
			linez = br.readLine().trim().split(" ");
			for(int i=1;i<=12;i++) {
				plan[i] = Integer.parseInt(linez[i-1]);
			}
			//(1) : 일과 월 비교
			for(int i=1;i<=12;i++) {
				if(plan[i] * d <= m1) {
					md[i] = plan[i] * d;
				}
				else {
					md[i] = m1;
				}
			}
			
			go(1,0);
			ans = ans > y ? y : ans;
			//답 도출...
			System.out.println("#"+t+" "+ans);
		}
	}
	public static void go(int month, int cost) {
		if(month>=13) {
			ans = ans > cost ? cost : ans;
			return;
		}
		else {
			go(month+1,cost+md[month]);
			go(month+3,cost+m3);
		}
	}
}
