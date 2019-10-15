package com.ssafy.git.TestExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Line02 {
	static int[] arr;
	static String[] permutaion = new String[6];
	static boolean[] select = new boolean[3];
	static int n,k;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		n = line.length;
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		k = Integer.parseInt(br.readLine().trim());
		
		select(0,"");
	}
	public static void select(int cnt, String number) {
		if(cnt == n) {
			System.out.println(number);
			return;
		}
		for(int i=0;i<n;i++) {
			if(select[i] == false) {
				select[i] = true;
				String temp = number + arr[i];
				select(cnt+1,temp);
				select[i] = false;
			}
		}
	}
}
