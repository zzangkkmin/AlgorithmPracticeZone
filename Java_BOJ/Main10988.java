package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10988 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int len  = str.length;
		for(int i = 0; i < len/2; i++){
			if(str[i] != str[len-1 - i]){
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}

}
