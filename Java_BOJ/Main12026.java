package com.ssafy.git.Java_BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main12026 {
	static int n;
	static String s;
	static int[] d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.next();
		d = new int[n];
		Arrays.fill(d, -1);
		System.out.println(go(0));
	}
	public static char get_next(char cur){
		if(cur=='B') return 'O';
		if(cur=='O') return 'J';
		if(cur=='J') return 'B';
		return ' ';
	}
	public static int go(int idx){
		//d[idx] = min(j-idx)^2 + go(j)
		if(idx == n-1){
			return 0;
		}
		if(d[idx] != -1){
			return d[idx];
		}
		char next_char = get_next(s.charAt(idx));
		int ans = -1;
		for(int j=idx+1;j<n;j++){
			if(s.charAt(j)==next_char){
				int temp = go(j);
				if(temp != -1){
					int val = (j-idx) * (j-idx) + temp;
					if(ans==-1 || ans > val){
						ans = val;
					}
				}
			}
		}
		d[idx] = ans;
		return ans;
	}
}
