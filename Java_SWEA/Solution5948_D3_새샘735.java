package com.ssafy.git.Java_SWEA;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution5948_D3_새샘735 {
	static int Ans = 0;
	static int arrIdx = 0;
	static void solve(int idx, int select, int[] arr, int sum, int[] sumA) {
		if(select == 3) {
			sumA[arrIdx] = sum;
			arrIdx++;
		}
		else if(idx == 7) {
			return;
		}
		else {
			solve(idx + 1, select + 1, arr, sum + arr[idx], sumA);
			solve(idx + 1, select, arr, sum, sumA);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			arrIdx = 0;
			Ans = 0;
			int[] arr = new int[7];
			int[] sumA = new int[35];
			for(int i=0;i<7;i++) {
				arr[i] = sc.nextInt();
			}
			solve(0,0,arr,0,sumA);
			Arrays.sort(sumA);
			int duplicated = -1; int bigger = 0;
			for(int i = 34; i>=0; i--) {
				if(duplicated == sumA[i]) {
					continue;
				}
				else {
					bigger++;
					if(bigger == 5) {
						Ans = sumA[i];
						break;
					}
					duplicated = sumA[i];
				}
			}
			System.out.println("#" + test_case + " " + Ans);
		}
	}

}
