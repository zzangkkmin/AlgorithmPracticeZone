package com.ssafy.git.TestExam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class NHN01 {
	static int n;
	static HashMap<String, Integer> map = new HashMap<>();
	static int[] numarray;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String card = sc.next();
			if(map.containsKey(card)) {
				map.replace(card, map.get(card)+1);
			}else {
				map.put(card, 1);
			}
		}
		boolean yn = true;
		int size = map.size(); numarray = new int[size];
		c[] namer = new c[size]; int ci = 0; int vall = 0;
		for(String key : map.keySet()) {
			vall += map.get(key);
			numarray[ci] = map.get(key);
			namer[ci++] = new c(key, map.get(key));
		}
		Arrays.sort(numarray);
		int k = numarray[size - 1]; int diff = 0;
		for(int i=size-2;i>=0;i--) {
			if(k > numarray[i]) {
				diff += k - numarray[i];
				if(diff >= 2) {
					yn = false;
					break;
				}
			}
		}
		if(yn) {
			System.out.println("Y");
			if(diff==0) System.out.println(vall);
			else System.out.println(vall+1);
			System.out.println(size);
		}else {
			System.out.println("N");
			System.out.println(vall);
			System.out.println(size);
		}
		
	}
	static class c{
		String name; int val;

		public c(String name, int val) {
			super();
			this.name = name;
			this.val = val;
		}
		
	}
}
