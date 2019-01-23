package com.ssafy.swe;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2063_D1_중간값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//9~199, odd
		int[] arr = new int[N];
		for(int i = 0; i < N ; i++){
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		//if using BubbleSort, i = ~ n/2;
		System.out.println(arr[N/2]);
	}

}
