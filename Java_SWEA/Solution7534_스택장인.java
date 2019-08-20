package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution7534_스택장인 {
	public static int n;
	public static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			solve(test_case);
		}
	}
	public static void solve(int T) {
		StringBuilder sb = new StringBuilder();
		sb.append("#").append(T).append(" ");
		//String ret = "";
		int[] stack = new int[n+1];
		int nextTopPoint = 1; int CurrentTopPoint = 0;
		int acPoint = 0; 
		//first push
		int first = arr[0];
		for(int i=1;i<=first;i++) {
			stack[nextTopPoint] = i;
			nextTopPoint++; CurrentTopPoint++;
			acPoint++;
			//ret += "+";
			sb.append("+");
		}
		//first pop
		stack[CurrentTopPoint] = 0;
		nextTopPoint--; CurrentTopPoint--;
		//ret += "-";
		sb.append("-");
		
		//after push-pop
		for(int i=1;i<n;i++) {
			int after = arr[i];
			if(after == stack[CurrentTopPoint]) {
				stack[CurrentTopPoint] = 0;
				nextTopPoint--; CurrentTopPoint--;
				//ret += "-";
				sb.append("-");
			}
			else if(after > stack[CurrentTopPoint]) {
				for(int x = acPoint + 1; x<=after;x++) {
					stack[nextTopPoint] = x;
					nextTopPoint++; CurrentTopPoint++;
					acPoint++;
					//ret += "+";
					sb.append("+");
				}
				stack[CurrentTopPoint] = 0;
				nextTopPoint--; CurrentTopPoint--;
				//ret += "-";
				sb.append("-");
			}
			else {//after < stack[CurrentTopPoint]
				System.out.println("#"+T+" NO");
				return;
			}
		}
		System.out.println(sb.toString());
	}
	
}
