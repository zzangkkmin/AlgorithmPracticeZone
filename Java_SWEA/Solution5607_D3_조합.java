package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5607_D3_조합 {
	public static long p = 1234567891;
	public static long n, r;
	public static long[] fact = new long[1000001];
	public static long[] inv = new long[1000001];
	public static String[] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		setInit();
		for(int t=1;t<=tc;t++){
			line = br.readLine().split(" ");
			n = Long.parseLong(line[0]);//1 ~ 1,000,000
			r = Long.parseLong(line[1]);//0 ~ n
			if(n==r){
				System.out.println("#"+t+" "+1);
			}
			else{
				/** ans = n!/(r!*(n-r)!) = n!*(r!)^-1*((n-r)!)^-1  */
				long ans = fact[(int) n] % p;
				ans = (ans * inv[(int) (n - r)]) % p;
				ans = (ans * inv[(int) r]) % p;
				System.out.println("#"+t+" "+ans);
			}
		}
	}
	/** x^y (mod p) 구하는 함수
	 * 
	 * x * x^(y-1) {y=2k+1}
	 * 
	 * */
	public static long power(long x, long y){
		long ret = 1;
		while(y>0){
			if(y%2==1){
				ret *= x;
				ret %= p;
			}
			x *= x;
			x %= p;
			y /= 2;
		}
		return ret;
	}
	public static void setInit(){
		fact[0] = fact[1] = 1;
		for(int i = 2; i <= 1000000;i++){
			fact[i] = (fact[i-1] * i) % p;
		}
		inv[1000000] = power(fact[1000000], p-2);
		for(int i = 999999; i>=0;i--){
			inv[i] = (inv[i+1] * (i+1)) % p;
		}
	}
}
