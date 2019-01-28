package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1228_D4_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<Character>();
		for(int t=1;t<=10;t++) {
			int n = Integer.parseInt(br.readLine().trim());
			char[] str = br.readLine().toCharArray();
			int ans = 1;
			for(char c:str) {
				if(ans==0) {
					break;
				}
				if(c=='{' || c=='[' || c=='(' || c=='<') {
					s.push(c);
				}
				else {
					if(s.empty()) {
						ans = 0;
						break;
					}
					else if(s.peek()=='<') {
						if(c=='>') {
							s.pop();
						}
						else {
							ans=0;
							break;
						}
					}
					else if(s.peek()=='(') {
						if(c==')') {
							s.pop();
						}
						else {
							ans=0;
							break;
						}
					}
					else if(s.peek()=='[') {
						if(c==']') {
							s.pop();
						}
						else {
							ans=0;
							break;
						}
					}
					else if(s.peek()=='{') {
						if(c=='}') {
							s.pop();
						}
						else {
							ans=0;
							break;
						}
					}
				}
			}
			if(!s.empty()) {
				ans = 0;
			}
			System.out.println("#"+t+" "+ans);
			s.clear();
		}
	}

}
