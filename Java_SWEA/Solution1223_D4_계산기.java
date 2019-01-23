package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class Solution1223_D4_계산기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {		
			StringBuilder str = new StringBuilder();
			int size = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			int idx = 0; 
			Stack<Character> s = new Stack<Character>();
			while(true) {
				if(idx==size) {
					break;
				}
				else if(input[idx] == ' ') {
					idx++;
				}
				else if(input[idx] == '(') {
					s.add(input[idx]);
					idx++;
				}
				else if(input[idx] == '+' || input[idx] == '-' ||
						input[idx] == '*' || input[idx] == '/') {
					while(true) {
						if(s.empty()) {
							s.add(input[idx]);
							idx++;
							break;
						}
						if(s.peek() == '*' || s.peek() == '/') {
							str.append(s.pop());
						}
						else {
							s.add(input[idx]);
							idx++;
							break;
						}
					}
				}
				else if(input[idx] == ')') {
					while(true) {
						char topp = s.pop();
						if(topp == '(') {
							idx++;
							break;
						}
						else {
							str.append(topp);
						}
					}
				}
				else {
					str.append(input[idx]);
					idx++;
				}
			}
			while(!s.empty()) {
				if(s.peek()=='(')
					s.pop();
				else
					str.append(s.pop());
			}
			System.out.println(str);
//			char[] arrr = str.toString().toCharArray();
//			Stack<Integer> ret = new Stack<Integer>();
//			for(int i=0;i<arrr.length;i++) {
//				if(arrr[i] == '+' || arrr[i] == '-' ||
//					arrr[i] == '*' || arrr[i] == '/') {
//					int b = ret.pop();
//					int a = ret.pop();
//					switch(arrr[i]){
//					case '+':
//						ret.add(a+b);
//						break;
//					case '-':
//						ret.add(a-b);
//						break;
//					case '*':
//						ret.add(a*b);
//						break;
//					case '/':
//						ret.add(a/b);
//						break;
//					default:
//						break;
//					}
//				}
//				else {
//					ret.add(arrr[i] - '0');
//				}
//			}
//			System.out.println(ret.pop());
		}
		
	}

}
/*
2
11
(9+(5*2+1))
21
(6 + 5 * (2 - 8) / 2)
*/