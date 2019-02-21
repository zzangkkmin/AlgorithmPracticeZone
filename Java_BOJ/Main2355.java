package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2355 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] line = br.readLine().split(" ");
		long a = Long.parseLong(line[0]);
		long b = Long.parseLong(line[1]);
		
		long n = a<b?b-a+1:a-b+1;
		long ans = (a+b)*n/2;
		System.out.println(ans);
		
	}

}
