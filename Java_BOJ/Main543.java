package com.ssafy.algo;
import java.util.Scanner;
public class Main543 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int x = 1; x<=num; x++){
			if(x%2==0) System.out.print(x+" ");
		}
	}

}
