package com.ssafy.git.TestB;

import java.util.Scanner;

//SWEA 3813. [Professional] 그래도 수명이 절반이 되어서는...
public class SolutionB03 {
	static int n, k, kSum;
	static int[] arr, kArr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int low = 200001; int high = 0; int ans = 0;
			n = sc.nextInt();
			k = sc.nextInt();
			kSum = 0;
			arr = new int[n];
			kArr = new int[k];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
				low = low < arr[i] ? low : arr[i];
				high = high > arr[i] ? high : arr[i];
			}
			for(int i=0;i<k;i++) {
				kArr[i] = sc.nextInt();
			}
			while(low < high) {
				int mid = (low + high) / 2;
				boolean confirm = setting(arr,kArr,mid);
				if(confirm) {
					high = mid;
				}else {
					low = mid + 1;
					ans = low;
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}
	static boolean setting(int[] narr, int[] karr, int set) {
		int kIdx = 0;
		for(int i=0;i<n;) {
			if(kIdx == k) {
				return true;
			}
			if(narr[i] <= set) {
				int length = karr[kIdx];
				boolean setOK = true;
				for(int j=0;j<length;j++) {
					if(i+j >= n || narr[i+j] > set) {
						setOK = false;
						break;
					}
				}
				if(setOK) {
					i = i+length;
					kIdx++;
				}else {
					i = i+1;
				}
			} else {
				i++;
			}
		}
		if(kIdx == k) {
			return true;
		}else {
			return false;
		}
	}
}
