package com.ssafy.git.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JungOL1053_피보나치 {
	public static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			n = Integer.parseInt(br.readLine().trim());
			if(n==-1) {
				break;
			}
			if(n==0) {
				System.out.println(0);
			}
			else if(n==1 || n == 2) {
				System.out.println(1);
			}
			else {
				long[] arr = operate(n,1,1,1,0);
				System.out.println(arr[1]);
			}
			
		}
	}
	public static long[] operate(int nn,long a, long b, long c, long d) {
		if(nn==1) {
			return new long[] {a,b,c,d};
		}
		long ta = (a*a+b*c) % 10000;
		long tb = (a*b+b*d) % 10000;
		long tc = (a*c+d*c) % 10000;
		long td = (b*c+d*d) % 10000;
		if(nn%2==0) {
			return operate(nn/2,ta,tb,tc,td);
		}
		else {
			long[] T = operate(nn/2,ta,tb,tc,td);
			long tta = (T[0]*a+T[1]*c) % 10000;
			long ttb = (T[0]*b+T[1]*d) % 10000;
			long ttc = (T[2]*a+T[3]*c) % 10000;
			long ttd = (T[2]*b+T[3]*d) % 10000;
			return new long[] {tta,ttb,ttc,ttd};
		}
	}
}
