package com.ssafy.algo;
import java.util.Scanner;
public class Main554 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int n = 1; char c = 'A';
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size + 1; j++){
				if(i >= size-j){
					System.out.print(c + " ");
					c++;
				}
				else{
					System.out.print(n + " ");
					n++;
				}
			}
			System.out.println("");
		}
	}

}
