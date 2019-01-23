package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main1914 {

	public static void hanoi(int size, int start, int mid, int end){
		if(size==1){
			System.out.println(start+" "+end);
			return;
		}
		hanoi(size-1,start,end,mid);
		System.out.println(start+" "+end);
		hanoi(size-1,mid,start,end);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		BigInteger b = new BigInteger("2");
		BigInteger ans = b.pow(n).subtract(new BigInteger("1"));
		System.out.println(ans);
		if(n<=20)
			hanoi(n,1,2,3);
	}

}
