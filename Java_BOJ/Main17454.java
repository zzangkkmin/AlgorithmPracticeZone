package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17454 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int bi = sc.nextInt();
			int ci = sc.nextInt();
			
			int aj = sc.nextInt();
			int cj = sc.nextInt();
			
			int ak = sc.nextInt();
			int bk = sc.nextInt();
			
			/*
			 * A = ak * k + aj * j
			 * B = bi * i + bk * k
			 * C = ci * i + cj * j
			 * 
			 * if
			 * 	(ak*k+aj*j) - (bi*i+bk*k) > 0 && (ak*k+aj*j) - (ci*i+cj*j) > 0
			 * 	(ak-bk)*k + (aj*j - bi*i) > 0 && (aj-cj)*j + (ak*k - ci*i) > 0
			 * 	
			 */
		}
	}

}
