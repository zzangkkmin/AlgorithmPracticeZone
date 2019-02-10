package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6026_D4_비밀번호공격 {
	public static int m,n;//1~100
	public static long mod = 1000000007;
	public static long[] fact = new long[101];
	public static long[] inv = new long[101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		setInit();
		for(int t=1;t<=tc;t++){
			String[] line = br.readLine().split(" ");
			m = Integer.parseInt(line[0]);
			n = Integer.parseInt(line[1]);
			//n to m 전사함수
			System.out.println("#"+t+" "+ontoFunc(n, m));
		}
	}
	/**
	 * 전사함수
	 * val = 0;
	 * for(int i=0;i<=m;i++){
	 * 		temp = (-1)^i = (i%2==0?1:-1)
	 * 		temp *= m!/((m-i)!*i!)
	 * 		temp *= (m-i)^n
	 * 		val += temp
	 * }
	 *  */
	public static long ontoFunc(int n, int m){
		long ret = 0;
		for(int i=0;i<=m;i++){
            long temp = 1;
            if(i%2==1)
				temp = -1;
			temp = (temp * fact[m]) % mod;
            temp = (temp * inv[m-i]) % mod;
            temp = (temp * inv[i]) % mod;
            temp = (temp * power(m-i,n)) % mod;
            ret = (ret + temp) % mod;
		}
		return ret;
	}
	public static long power(long x, long y){
		long ret = 1;
		while(y>0){
			if(y%2==1){
				ret *= x;
				ret %= mod;
			}
			x *= x;
			x %= mod;
			y /= 2;
		}
		return ret;
	}
	public static void setInit(){
		fact[0] = fact[1] = 1;
		for(int i = 2; i <= 100;i++){
			fact[i] = (fact[i-1] * i) % mod;
		}
		inv[100] = power(fact[100], mod-2);
		for(int i = 99; i>=0;i--){
			inv[i] = (inv[i+1] * (i+1)) % mod;
		}
	}
}
