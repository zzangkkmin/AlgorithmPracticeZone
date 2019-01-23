package com.ssafy.algo;
import java.util.Scanner;

public class Main540 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
			int num = sc.nextInt();
			if(num==-1){
				break;
			}
			else if(num % 3 == 0){
				System.out.println(num/3);
			}
		}
	}

}
