package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main9237 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(arr);
		int ans = 0;
		for(int i = n-1;i>=0;i--) {
			ans = (ans < (arr[i] + n-i) ? (arr[i] + n-i) : ans);
		}
		System.out.println(ans + 1);
	}

}
