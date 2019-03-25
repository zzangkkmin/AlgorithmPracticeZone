package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1952_수영장_강민 {
	public static int d, m1, m3, y, ans;
	public static String[] linez;
	public static int[] plan, md, m3mode;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			ans = 0;
			plan = new int[12+1];	//월별 이용 계획 일자
			md = new int[15];		//월별 최소 이용 값
			m3mode = new int[15];	//3달이용 체크
			
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
			//(2)-1 : 3달이용 표시
			while(true) {
				int dv = -1;
				int m3Idx = 0;
				boolean find = false;
				for(int i=1;i<=12;i++) {
					if(md[i]+md[i+1]+md[i+2] > m3 && md[i]+md[i+1]+md[i+2] - m3 > dv &&
						m3mode[i]==0 && m3mode[i+1]==0 && m3mode[i+2] == 0) {
						m3Idx = i;
						dv = md[i]+md[i+1]+md[i+2] - m3;
						find = true;
					}
				}
				if(find==false) {
					break;
				}
				else {
					m3mode[m3Idx]=1;
					m3mode[m3Idx+1]=1;
					m3mode[m3Idx+2]=1;
				}
			}
			//(2)-2 : (1)과 3달이용 비교
			for(int i=1;i<=12;) {
				if(m3mode[i]==1) {
					ans += m3;
					i=i+3;
				}
				else {
					ans += md[i];
					i=i+1;
				}
			}
			//(3) : (2)와 연간이용 비교
			ans = Math.min(ans, y);
			//(4) : (3)과 4회 연속 3달이용 비교
			ans = Math.min(ans, m3 * 4);
			
			//답 도출...
			System.out.println("#"+t+" "+ans);
		}
	}

}
