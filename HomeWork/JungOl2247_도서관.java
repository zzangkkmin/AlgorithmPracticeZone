package com.ssafy.git.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JungOl2247_도서관 {
	public static int n, ss, ee;
	public static int emptys = 1;
	public static int continues = 0;
	public static String[] line;
	public static student[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		list = new student[n];
		for(int i=0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			int s = Integer.parseInt(line[0]);
			int e = Integer.parseInt(line[1]);
			list[i] = new student(s,e);
		}
		Arrays.sort(list);
		find();
		System.out.print(continues+" ");
		System.out.println(emptys);
	}
	static class student implements Comparable<student>{
		int s;
		int e;
		public student(int s, int e) {
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(student o) {
			// TODO Auto-generated method stub
			return this.s - o.s;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("student [s=").append(s).append(", e=").append(e).append("]");
			return builder.toString();
		}
		
	}
	public static void find() {
		for(int i=0;i<n;i++) {
			if(i==0) {
				ss = list[i].s;
				ee = list[i].e;
				continues = continues < ee - ss ? ee - ss : continues;
			}
			else {
				if(list[i].s <= ee) {
					ss = ss > list[i].s ? list[i].s : ss;
					ee = ee < list[i].e ? list[i].e : ee;
				}
				else {
					continues = continues < ee - ss ? ee - ss : continues;
					emptys = emptys < list[i].s - ee ? list[i].s - ee : emptys;
					ss = list[i].s;
					ee = list[i].e;
				}
			}
		}
		continues = continues < ee - ss ? ee - ss : continues;
	}

}
