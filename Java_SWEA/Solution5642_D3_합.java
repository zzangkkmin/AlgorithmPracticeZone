package com.ssafy.git.Java_SWEA;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution5642_D3_합 {
	static int N;
//	static int space(int n) {
//		int nn = 1; int ret = 1;
//		while(true) {
//			if(n/2==0) {
//				break;
//			}
//			else {
//				nn++;
//				n /= 2;
//			}
//		}
//		for(int i=0;i<nn;i++) {
//			ret *= 2;
//		}
//		return ret;
//	}
	static int fastMaxSum(int[] arr) {
		int N = arr.length;
		int ret = 0;
		int psum = 0;
		for(int i=0;i<N;i++) {
			psum = Math.max(psum, 0) + arr[i];
			ret = Math.max(psum, ret);
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();//3~100,000
//			int Max = 0;
//			int n2 = space(N);
//			int[] arr = new int[n2*2 + 1];
//			for(int i = n2, size = 0; size < N; i++, size++) {
//				arr[i] = sc.nextInt();
//				Max = Max < arr[i] ? arr[i] : Max;
//			}
//			int leftIdx = n2;
//			int rightIdx = n2 * 2 - 1;
//			while(leftIdx != 1) {
//				for(int i = leftIdx; i<=rightIdx; i = i + 2) {
//					arr[i/2] = arr[i] + arr[i+1];
//					Max = Max < arr[i/2] ? arr[i/2] : Max;
//				}
//				rightIdx = leftIdx - 1;
//				leftIdx = leftIdx / 2;
//			}
			int[] arr = new int[N];
			int Max = 0;
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			Max = fastMaxSum(arr);
			System.out.println("#" + test_case + " " + Max);
		}
	}

}
