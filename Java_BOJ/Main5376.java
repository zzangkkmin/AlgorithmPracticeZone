package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5376 {
	public static String input, son, mother, anotherSon;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++){
			input = br.readLine().trim();
			son = ""; anotherSon ="";
			mother = "";
			int idx = 0; boolean recursive = false;
			int startIdx = -1; int endIdx = -1;
			for(int i=2;i<input.length();i++){
				char c = input.charAt(i);
				if(c>='0' && c<='9'){
					son += c;
					idx++;
				}
				else if(c=='('){
					anotherSon = son;
					recursive = true;
					startIdx = idx;
				}
				else if(c==')'){
					endIdx = idx - 1;
				}
			}
			//System.out.println(son);
			if(recursive){
				//System.out.println(startIdx + " " + endIdx);
				
				for(int i = endIdx; i>=0; i--){
					if(i>=startIdx){
						mother += '9';
					}
					else{
						mother += '0';
					}
				}
				long minusA = 0;
				if(!anotherSon.equals("")){
					minusA = Long.parseLong(anotherSon);
				}
				long a = Long.parseLong(son) - minusA;
				long b = Long.parseLong(mother);
				long gcdAB = gcd(a,b);
				a /= gcdAB; b /= gcdAB;
				System.out.println(a+"/"+b);
			}
			else{
				//System.out.println(son.length() + " " + (int)Math.pow(10, son.length()));
				long a = Long.parseLong(son);
				long b = (long) Math.pow(10, son.length());
				long gcdAB = gcd(a,b);
				a /= gcdAB; b /= gcdAB;
				System.out.println(a+"/"+b);
			}
		}
	}
	public static long gcd(long a, long b){
		if(b==0){
			return a;
		}
		return gcd(b,a%b);
	}
}
