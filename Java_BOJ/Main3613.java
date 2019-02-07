package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3613 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		boolean[] mode = new boolean[2];
		for(int i=0;i<str.length;i++) {
			if(str[i] == '_') {
				mode[0] = true;
				if(i==0 || str[str.length - 1] == '_' || str[i+1] == '_') {
					System.out.println("Error!");
					return;
				}
			}
			else if(str[i]>='A'&&str[i]<='Z') {
				mode[1] = true;
				if(i==0) {
					System.out.println("Error!");
					return;
				}
			}
		}
		if(mode[0]==true && mode[1]==false) {
			//cpp to java
			print(str,0);
		}
		else if(mode[0]==false&&mode[1]==true) {
			//java to cpp
			print(str,1);
		}
		else if(mode[0]==false&&mode[1]==false) {
			System.out.println(str);
		}
		else {
			System.out.println("Error!");
		}
	}
	public static void print(char[] str, int mode) {
		if(mode == 0) {
			for(int i=0;i<str.length;) {
				if(str[i] == '_') {
					i++;
					System.out.print((char)(str[i]-32));
					i++;
				}
				else {
					System.out.print(str[i]);
					i++;
				}
			}
		}
		else {
			for(int i=0;i<str.length;i++) {
				if(str[i]>='A'&&str[i]<='Z') {
					System.out.print("_"+(char)(str[i]+32));
				}
				else {
					System.out.print(str[i]);
				}
			}
		}
	}
}
