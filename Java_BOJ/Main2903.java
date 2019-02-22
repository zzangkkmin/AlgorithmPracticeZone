package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2903 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[n+1];
		arr[1] = 3;
		for(int i=2;i<=n;i++) {
			arr[i] = arr[i-1] + arr[i-1] - 1;
		}
		System.out.println(arr[n]*arr[n]);
	}

}
