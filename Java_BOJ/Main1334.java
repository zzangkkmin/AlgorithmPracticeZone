package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1334 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		String pre = number.substring(0, 
				number.length()%2==1?number.length()/2+1:number.length()/2);
		String post = number.substring(0, number.length()/2);
		System.out.println(pre + " " + post);
	}

}
