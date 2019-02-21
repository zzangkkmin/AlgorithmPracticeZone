package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main1837 {
	public static boolean[] prime;
	public static BigInteger P, temp;
	public static int k;
	public static int eratostenes(){
		for(int i=2;i<k;i++){
			if(prime[i]==true){
				temp = P.mod(new BigInteger(new Integer(i).toString()));
				if(temp.toString().equals("0")){
					return i;
				}
				for(int j=i+i;j<k;j=j+i){
					prime[j] = false;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		P = new BigInteger(line[0]);
		k = Integer.parseInt(line[1]);
		prime = new boolean[k+1];
		Arrays.fill(prime, true);
		int ans = eratostenes();
		if(ans==-1){
			System.out.println("GOOD");
		}
		else{
			System.out.println("BAD " + ans);
		}
	}

}
