package com.ssafy.algo;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.LoggingMXBean;

public class Solution6782 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1;t<=tc;t++){//10000
			long n;
			n = sc.nextLong();//1~10^12
			long Ans = 0;
			while(true){
				if(n==1){
					Ans = 1;
					break;
				}
				if(n==2){
					break;
				}
				long k = (long) Math.sqrt(n);
				if(k*k==n){
					n = k;
					Ans++;
				}
				else{
					long next = (k+1)*(k+1);
					Ans = Ans + next - n;
					n = next;
				}
			}
			System.out.println("#"+t+" "+Ans);
		}
	}

}
