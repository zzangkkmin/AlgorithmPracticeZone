package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16953 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int a = Integer.parseInt(line[0]);
		int b = Integer.parseInt(line[1]);
		System.out.println(find(a,b,0));
	}	
	public static int find(int a, int b, int step) {
		while(true) {
			if(b==a) {
				return step + 1;
			}
			if(b<a || (b%2==1 && b%10 >=3 && b%10 <= 9)) {
				return -1;
			}
			if(b%10==1) {
				b = b / 10;
				step++;
			}
			else if(b%2==0) {
				b = b / 2;
				step++;
			}
		}
	}
}
