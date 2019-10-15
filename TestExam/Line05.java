package com.ssafy.git.TestExam;

import java.util.Scanner;

public class Line05 {
	static int n,ans;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			if(arr[i] == 0) {
				int temp = sit(i);
				ans = ans < temp ? temp : ans;
			}
		}
		System.out.println(ans);
	}
	public static int sit(int idx) {
		int pos = idx;
		int l = 0; int r = 0;
		while(true) {
			if(pos - 1 < 0) {
				l = 0;
				break;
			}
			if(arr[pos - 1] == 1) {
				break;
			} else {
				pos = pos - 1;
				l++;
			}
		}
		pos = idx;
		while(true) {
			if(pos + 1 == n) {
				r = 0;
				break;
			}
			if(arr[pos + 1] == 1) {
				break;
			} else {
				pos = pos + 1;
				r++;
			}
		}
		System.out.print("idx: "+idx+ " L: "+l+" R: "+r);
		int ret = (l<r?l:r) + 1;
		System.out.println("// ret: " + ret);
		return ret;
	}
}
