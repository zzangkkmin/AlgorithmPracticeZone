package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution5432_D4_쇠막대기자르기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		Stack<Character> s = new Stack<Character>();
		for(int t=1;t<=tc;t++) {
			char[] str = br.readLine().toCharArray();
			int size = str.length;
			int mode = 0;
			long sum = 0;
			for(char c:str) {
				if(c=='(') {
					mode = 0;
					s.push(c);
				}
				else {
					if(mode==1) {
						sum+=1;
					}
					else {
						sum += s.size()-1;
						mode = 1;
					}
					s.pop();
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}

}
