package com.ssafy.swe;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1208_D3_Flatten {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++){
			int N = sc.nextInt();
			int[] arr = new int[100];
			for(int i=0;i<100;i++) {
				arr[i] = sc.nextInt();
			}
			while(true) {
				Arrays.sort(arr);
                if(N==0)
					break;
				arr[0]++;
				arr[99]--;
				N--;
			}
			//Arrays.sort(arr);
			System.out.println("#" + test_case + " " + (arr[99] - arr[0]));
		}
	}

}
