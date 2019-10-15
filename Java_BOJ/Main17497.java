package com.ssafy.git.Java_BOJ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main17497 {
	static long x; 
	static long upperLimit = 1;
	static int ansCnt = -1;
	static String ansStr = "";
	static boolean findAns;
	static HashSet<Long> visit = new HashSet<Long>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setLimit();
		Scanner sc = new Scanner(System.in);
		x = sc.nextLong();
		calculate("", 0, 0);
		if(ansCnt == -1) {
			System.out.println(ansCnt);
		} else {
			System.out.println(ansCnt);
			for(int i=0;i<ansStr.length();i++) {
				System.out.print("["+ansStr.charAt(i)+"] ");
			}
			System.out.println();
		}
		sc.close();
	}
	public static void setLimit() {
		for(int i=0;i<63;i++) {
			upperLimit *= 2;
		}
		upperLimit -= 1;
	}
	public static void calculate(String steps, int cnt, long target) {
		//System.out.println(steps);
		if(target == x) {
			findAns = true;
			ansCnt = cnt;
			ansStr = steps;
			return;
		}
		if(findAns || cnt>99 ||
		   target < 0 || target > upperLimit ||
		   visit.contains(target)) {
			return;
		} else {
			visit.add(target);
			if(target > x) {
				calculate(steps.concat("/"), cnt+1, target/2);
				calculate(steps.concat("-"), cnt+1, target-2);
			} else{
				calculate(steps.concat("*"), cnt+1, target*2);
				calculate(steps.concat("+"), cnt+1, target+2);
			
			}
		}
	}
}
