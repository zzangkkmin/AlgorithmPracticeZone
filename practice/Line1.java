package com.ssafy.git.practice;

import java.util.Scanner;

public class Line1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sqrtNH = (long) Math.sqrt(n);
        
        while(true){
        	if(sqrtNH == 1){
        		System.out.println(n - sqrtNH);
        		break;
        	}
        	if(n % sqrtNH == 0){
        		System.out.println(n / sqrtNH - sqrtNH);
        		break;
        	}
        	sqrtNH = sqrtNH - 1;
        }
	}

}
