package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1032 {
	public static char[][] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		list = new char[n][];
		int len = 0;
		for(int i=0;i<n;i++){
			list[i] = br.readLine().toCharArray();
			len = list[i].length;
		}
		boolean flag = true;
		for(int i=0;i<len;i++){
			flag = true;
			for(int j=1;j<n;j++){
				if(list[0][i] != list[j][i]){
					flag = false;
					break;
				}
			}
			if(flag){
				System.out.print(list[0][i]);
			}
			else{
				System.out.print("?");
			}
		}
		System.out.println();
	}

}
