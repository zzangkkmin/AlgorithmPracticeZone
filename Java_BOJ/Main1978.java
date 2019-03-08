package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1978 {
	public static boolean[] prime = new boolean[1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		Arrays.fill(prime, true);
		che();
		int ans = 0;
		String[] line = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			if(prime[Integer.parseInt(line[i])]) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	public static void che() {
		prime[0] = prime[1] = false;
		for(int i=2;i<=1000;i++) {
			if(prime[i] == true) {
				for(int j=i+i;j<=1000;j+=i) {
					prime[j] = false;
				}
			}
		}
	}
}
