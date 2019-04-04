package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution3289_D4_서로소집합 {
	static int n,m,mode,a,b;//n:~1,000,000 //m: ~100,000
	static int[] num;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			System.out.print("#"+t+" ");
			n = sc.nextInt();
			m = sc.nextInt();
			num = new int[n+1];
			setParent();
			for(int i=0;i<m;i++) {
				mode = sc.nextInt();
				a = sc.nextInt();
				b = sc.nextInt();
				if(mode==0) {
					unionParent(a, b);
				}
				else {
					if(findParent(a) == findParent(b)) {
						sb.append("1");
					}
					else {
						sb.append("0");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
		sb.setLength(0);
	}
	public static void setParent() {
		for(int i=0;i<=n;i++) {
			num[i] = i;
		}
	}
	public static int findParent(int a) {
		if(num[a] == a) {
			return a;
		}
		return num[a] = findParent(num[a]);
	}
	public static void unionParent(int a, int b) {
		num[findParent(a)] = findParent(b);
	}
}
