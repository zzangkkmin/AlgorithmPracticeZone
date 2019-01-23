package com.ssafy.algo;
import java.util.Scanner;

public class Main633 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1. Korea");
			System.out.println("2. USA");
			System.out.println("3. Japan");
			System.out.println("4. China");
			System.out.println("number? ");
			int num = sc.nextInt();
			
			if(num==1){
				System.out.println("Seoul");
				System.out.println("");
			}else if(num == 2){
				System.out.println("Washington");
				System.out.println("");
			}else if(num == 3){
				System.out.println("Tokyo");
				System.out.println("");
			}else if(num == 4){
				System.out.println("Beijing");
				System.out.println("");
			}else{
				System.out.println("none");
				break;
			}
		}
	}

}
