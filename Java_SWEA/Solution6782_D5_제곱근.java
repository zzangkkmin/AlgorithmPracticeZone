package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.LoggingMXBean;

public class Solution6782_D5_제곱근 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int tc = sc.nextInt();
//		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		
		for(int t=1;t<=tc;t++){//10000
			long n;
//			n = sc.nextLong();//1~10^12
			n = Long.parseLong(br.readLine().trim());
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
