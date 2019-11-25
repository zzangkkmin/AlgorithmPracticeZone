package com.ssafy.git.Java_BOJ;

import java.util.HashSet;
import java.util.Scanner;

public class Main16637 {
	static int n, arIdx, numIdx;
	static int ans = -2147483648;
	static String input;
	static char[] arithmetic;
	static int[] numbers;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> m = new HashSet<Integer>();
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arithmetic = new char[n/2 + 1];
		numbers = new int[n/2+1];
		input = sc.next();
		for(int i=0;i<input.length();i++) {
			if(i%2==0) {
				numbers[numIdx++] = input.charAt(i) - '0';
			}else {
				arithmetic[arIdx++] = input.charAt(i);
			}
		}
		if(n==1) {
			ans = numbers[0];
		}else if(n==3) {
			ans = bracketCal(arithmetic[0], 0);
		} else {
			solve(0,'?',0);
		}
		System.out.println(ans);
		sc.close();
	}
	public static void solve(int x, char mode, int idx) {
		if(mode == '?') {
			solve(numbers[idx],arithmetic[idx],idx+1);
			solve(bracketCal(arithmetic[idx], idx), arithmetic[idx+1], idx+2);
		}
		else if(idx == numIdx - 1) {
			int ret = 0;
			if(mode == '+') {
				ret = x + numbers[idx];				
			} else if(mode == '-') {
				ret = x - numbers[idx];
			} else if(mode == '*') {
				ret = x * numbers[idx];				
			} else if(mode == '/') {
				ret = x / numbers[idx];			
			}
			ans = ans < ret ? ret : ans;
			return;
		}
		else if(idx == numIdx) {
			int ret = x;
			ans = ans < ret ? ret : ans;
			return;
		}
		else if(idx > numIdx) {
			return;
		}
		else {
			if(mode == '+') {
				solve(x + numbers[idx], arithmetic[idx], idx + 1);
				solve(x + bracketCal(arithmetic[idx], idx), arithmetic[idx+1], idx+2);
			} else if(mode == '-') {
				solve(x - numbers[idx], arithmetic[idx], idx + 1);
				solve(x - bracketCal(arithmetic[idx], idx), arithmetic[idx+1], idx+2);
			} else if(mode == '*') {
				solve(x * numbers[idx], arithmetic[idx], idx + 1);
				solve(x * bracketCal(arithmetic[idx], idx), arithmetic[idx+1], idx+2);
			} else if(mode == '/') {
				solve(x / numbers[idx], arithmetic[idx], idx + 1);
				solve(x / bracketCal(arithmetic[idx], idx), arithmetic[idx+1], idx+2);
			}
		}
	}
	public static int bracketCal(char mode, int idx) {
		int ret = 0;
		if(mode == '+') {
			ret = numbers[idx] + numbers[idx+1];
		} else if(mode == '-') {
			ret = numbers[idx] - numbers[idx+1];
		} else if(mode == '*') {
			ret = numbers[idx] * numbers[idx+1];
		} else if(mode == '/') {
			ret = numbers[idx] / numbers[idx+1];
		}
		return ret;
	}
}
