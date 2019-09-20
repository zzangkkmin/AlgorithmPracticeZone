package com.ssafy.git.TestB;

import java.util.Scanner;

//SWEA 3998. [Professional] Inversion Counting
public class SolutionB07 {
	static int n;
	static long ans;
	static int[] arr = new int[100000];
	static int[] temp = new int[100000];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			ans = 0;
			n = sc.nextInt();
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			mergeSort(0, n - 1);
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
	static void mergeSort(int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			
			int left = start, right = mid + 1;
			int idx = start;
			while(left <= mid || right <= end) {
				if(right > end || (left <= mid && arr[left] < arr[right])) {
					temp[idx++] = arr[left++];
				}else {
					ans += (mid - left + 1);
					temp[idx++] = arr[right++];
				}
			}
			
			for(int i=start;i<=end;i++) {
				arr[i] = temp[i];
			}
		}
	}
	static void indexTree() {
		
	}
}
