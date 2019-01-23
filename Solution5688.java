package com.ssafy.algo;

import java.util.Scanner;

public class Solution5688 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
//		long[] arr = new long[1000000];
//		for(long i=0;i<arr.length;i++){
//			arr[(int)i] = (long)((i+1)*(i+1)*(i+1));
//		}
//		System.out.println(arr[1000000-1]);
		for(int test_case = 1; test_case <= T; test_case++)	{
			long n = sc.nextLong();
//			for(int i=0;i<arr.length;i++){
//				if(n == arr[i]){
//					Ans = i+1;
//		            break;
//				}
//			}
			long temp = (long)Math.cbrt(n);
			if(temp*temp*temp == n)
				System.out.println("#" + test_case + " " + temp);
			else{
				System.out.println("#" + test_case + " " +  -1);
			}
		}
	}

}
