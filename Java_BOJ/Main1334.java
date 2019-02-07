package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main1334 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		String pre = number.substring(0, 
				number.length()%2==1?number.length()/2+1:number.length()/2);
		String post = number.substring(0, number.length()/2);
		String rev = new StringBuilder(post).reverse().toString();
		String output = pre + rev;
		System.out.println("C_pre: "+pre);
		System.out.println("C_post: "+post);
		System.out.println("C_rev: "+rev);
		if(number.compareTo(output) < 0) {
			//output이 더 클때
			System.out.println(pre + rev);
		}
		else {
			//number가 더 크거나 같을때
			BigInteger bigPre = new BigInteger(pre);
			bigPre = bigPre.add(new BigInteger("1"));
			String nextpre = bigPre.toString();
			System.out.println("N_pre: "+ nextpre);
			String nextpost = "";
			if(number.length()%2==1) {
				nextpost = bigPre.toString().substring(0,bigPre.toString().length()-1);
				System.out.println("N_post: "+nextpost);
			}else {
				nextpost = bigPre.toString();
				System.out.println("N_post: "+nextpost);
			}
			if(nextpost.length()!=post.length()) {
				
			}
			String nextrev = new StringBuilder(nextpost).reverse().toString();
			System.out.println("N_rev: "+nextrev);
			System.out.println(nextpre + nextrev);
		}
	}

}
