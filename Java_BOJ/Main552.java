package com.ssafy.git.Java_BOJ;
import java.util.Scanner;
public class Main552 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 2 * n - 1; j++){
				if(i<=j && i <= (2 * n - 1) - j - 1){
					System.out.print("*");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}

}
