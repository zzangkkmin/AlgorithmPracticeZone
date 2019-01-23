package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1234_D3_비밀번호 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			String[] line = br.readLine().split(" ");
			int size = Integer.parseInt(line[0]);
			char[] var = line[1].toCharArray();
			Stack<Integer> s = new Stack<Integer>();
			for(int i = 0; i < size ; i++) {
				if(s.empty()) {
					s.add(var[i] - '0');
				}
				else if(s.peek() == (var[i] - '0')) {
					s.pop();
				}
				else {
					s.add(var[i] - '0');
				}
			}
			int[] output = new int[s.size()];
			int idx = s.size()-1;
			int Ssize = s.size();
			while(!s.empty()) {
				output[idx] = s.pop();
				idx--;
			}
			System.out.print("#"+t+" ");
			idx = 0;
			while(idx<Ssize) {
				System.out.print(output[idx]);
				idx++;
			}
			System.out.println();
		}
	}
}
