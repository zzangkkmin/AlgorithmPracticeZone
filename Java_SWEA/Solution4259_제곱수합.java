package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution4259_제곱수합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++){
			BigInteger sum = new BigInteger("0");
			int n = Integer.parseInt(br.readLine().trim());
			String[] arr = br.readLine().split(" ");
			for(int i=0;i<n;i++){
				int len = arr[i].length();
				String a = arr[i].substring(0, len - 1);
				String b = arr[i].substring(len-1);
				int bb = Integer.parseInt(b);
				BigInteger big = new BigInteger("1");
				BigInteger aa = new BigInteger(a);
				for(int j=0;j<bb;j++){
					big = big.multiply(aa);
				}
				sum = sum.add(big);
			}
			System.out.println("#"+t+" "+sum.toString());
		}
	}

}
