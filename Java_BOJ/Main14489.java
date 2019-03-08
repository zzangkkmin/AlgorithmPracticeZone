package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14489 {
	public static long a,b,c;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		a = Long.parseLong(line[0]);
		b = Long.parseLong(line[1]);
		c = Long.parseLong(br.readLine().trim());
		if(a+b < 2*c) {
			System.out.println(a+b);
		}
		else {
			System.out.println(a+b - 2*c);
		}
	}	

}
