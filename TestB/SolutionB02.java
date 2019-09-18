package com.ssafy.git.TestB;

import java.util.Scanner;

//SWEA 3814. [Professional] 평등주의
public class SolutionB02 {
	static int n,k,ans;
	static int[] arr;
	static int[] tempArr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			ans = 0;
			n = sc.nextInt();
			k = sc.nextInt();
			arr = new int[n];
			tempArr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			int low = 0; int high = 1000000000;
			
			while(low < high) {
				int mid = (low + high) / 2;
				int tempK = k;
				boolean flag = true;
				for(int i=0;i<n;i++) {
					tempArr[i] = arr[i];
				}
				for(int i=0;i<n-1;i++) {
					if(tempArr[i+1] - tempArr[i] >= mid) {
						tempK -= ((tempArr[i+1] - tempArr[i]) - mid);
						tempArr[i+1] -= ((tempArr[i+1] - tempArr[i]) - mid);
						if(tempK < 0) {
							flag = false;
							break;
						}
					}
				}
				if(flag == true) {
					for(int i=n-1;i>0;i--) {
						if(tempArr[i-1] - tempArr[i] >= mid) {
							tempK -= ((tempArr[i-1] - tempArr[i]) - mid);
							tempArr[i-1] -= ((tempArr[i-1] - tempArr[i]) - mid);
							if(tempK < 0) {
								flag = false;
								break;
							}
						}
					}
				}
				if(flag == false) {
					low = mid + 1;
					ans = low;
				}else {
					high = mid;
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}

}
