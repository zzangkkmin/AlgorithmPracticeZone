package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution5356 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[][] arr = new char[5][15];
			
			for(int i = 0; i<5;i++){
				Arrays.fill(arr[i], '#');
				char[] input = sc.next().toCharArray();
				for(int j=0;j<input.length;j++){
					arr[i][j] = input[j];
				}
			}
			System.out.print("#" + test_case + " ");
			for(int j = 0; j < 15; j++){
				for(int i = 0;i < 5;i++){
					if(arr[i][j] != '#'){
						System.out.print(arr[i][j]);
					}
				}
			}
			System.out.println("");
		}
	}

}
