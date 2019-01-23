package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2063 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//9~199, odd
		int[] arr = new int[N];
		for(int i = 0; i < N ; i++){
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr[N/2]);
	}

}
