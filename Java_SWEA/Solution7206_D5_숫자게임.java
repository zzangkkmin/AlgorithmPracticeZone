package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution7206_D5_숫자게임 {
	public static int ans;
	public static int[] dist = new int[100000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		find();
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			int number = Integer.parseInt(br.readLine().trim());
			System.out.println("#"+t+" "+dist[number]);
		}
	}
	public static void find5(String number) {
		int origin = Integer.parseInt(number);
		String A = "" + number.charAt(0); int a = Integer.parseInt(A);
		String B = "" + number.charAt(1); int b = Integer.parseInt(B);
		String C = "" + number.charAt(2); int c = Integer.parseInt(C);
		String D = "" + number.charAt(3); int d = Integer.parseInt(D);
		String E = "" + number.charAt(4); int e = Integer.parseInt(E);
		String AB = A + B; int ab = Integer.parseInt(AB);
		String BC = B + C; int bc = Integer.parseInt(BC);
		String CD = C + D; int cd = Integer.parseInt(CD);
		String DE = D + E; int de = Integer.parseInt(DE);
		String ABC = AB + C; int abc = Integer.parseInt(ABC);
		String BCD = BC + D; int bcd = Integer.parseInt(BCD);
		String CDE = CD + E; int cde = Integer.parseInt(CDE);
		String ABCD = ABC + D; int abcd = Integer.parseInt(ABCD);
		String BCDE = BCD + E; int bcde = Integer.parseInt(BCDE);
		int max = Math.max(dist[a*b*c*d*e], dist[ab*c*d*e] );
		max = Math.max(max, dist[a*bc*d*e]);
		max = Math.max(max, dist[a*b*cd*e]);
		max = Math.max(max, dist[a*b*c*de]);
		max = Math.max(max, dist[ab*c*de]);
		max = Math.max(max, dist[ab*cd*e]);
		max = Math.max(max, dist[abc*d*e]);
		max = Math.max(max, dist[a*b*cde]);
		max = Math.max(max, dist[a*bc*de]);
		max = Math.max(max, dist[a*bcd*e]);
		max = Math.max(max, dist[a*bcde]);
		max = Math.max(max, dist[ab*cde]);
		max = Math.max(max, dist[abc*de]);
		max = Math.max(max, dist[abcd*e]);
		
		dist[origin] = max + 1;
	}
	public static void find4(String number) {
		int origin = Integer.parseInt(number);
		String A = "" + number.charAt(0); int a = Integer.parseInt(A);
		String B = "" + number.charAt(1); int b = Integer.parseInt(B);
		String C = "" + number.charAt(2); int c = Integer.parseInt(C);
		String D = "" + number.charAt(3); int d = Integer.parseInt(D);
		String AB = A + B; int ab = Integer.parseInt(AB);
		String BC = B + C; int bc = Integer.parseInt(BC);
		String CD = C + D; int cd = Integer.parseInt(CD);
		String ABC = AB + C; int abc = Integer.parseInt(ABC);
		String BCD = BC + D; int bcd = Integer.parseInt(BCD);
		int max = Math.max(dist[a*b*c*d], dist[ab*c*d]);
		max = Math.max(max, dist[a*bc*d]);
		max = Math.max(max, dist[a*b*cd]);
		max = Math.max(max, dist[a*bcd]);
		max = Math.max(max, dist[ab*cd]);
		max = Math.max(max, dist[abc*d]);
		
		dist[origin] = max + 1;
	}
	public static void find3(String number) {
		int origin = Integer.parseInt(number);
		String A = "" + number.charAt(0); int a = Integer.parseInt(A);
		String B = "" + number.charAt(1); int b = Integer.parseInt(B);
		String C = "" + number.charAt(2); int c = Integer.parseInt(C);
		String AB = A + B; int ab = Integer.parseInt(AB);
		String BC = B + C; int bc = Integer.parseInt(BC);
		int max = Math.max(dist[a*b*c], dist[a*bc]);
		max = Math.max(max, dist[ab*c]);
		
		dist[origin] = max + 1;
	}
	public static void find2(String number) {
		int origin = Integer.parseInt(number);
		String A = "" + number.charAt(0); int a = Integer.parseInt(A);
		String B = "" + number.charAt(1); int b = Integer.parseInt(B);
		dist[origin] = dist[a*b] + 1;
	}
	public static void find() {
		for(int n = 10; n<=99999; n++) {
			String nn = ""+n;
			if(n>=10000) {
				find5(nn);
			}
			else if(n>=1000){
				find4(nn);
			}
			else if(n>=100) {
				find3(nn);
			}
			else if(n>=10) {
				find2(nn);
			}
		}
	}
}
