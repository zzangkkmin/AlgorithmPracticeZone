package com.ssafy.git.Java_BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main11508 {
	public static int n;
	public static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		merge_sort(arr);
		long ans = 0;
		for(int i=0;i<n;i++) {
			if(i%3==2) {
				continue;
			}
			ans += arr[i];
		}
		System.out.println(ans);
	}
	public static void merge (int[] arrA, int[] arrB, int[] arrC) {
        int iA = 0;
        int iB = 0;
        int iC = 0;
       
        while (iA < arrA.length) {
                if (iB < arrB.length) {
                        if ( arrA[iA] > arrB[iB]) {
                                arrC[iC] = arrA[iA];
                                iA++;
                        } else {
                                arrC[iC] = arrB[iB];
                                iB++;
                        }
                        iC++;
                } else {
                        while (iA < arrA.length) {
                                arrC[iC] = arrA[iA];
                                iA++;
                                iC++;
                        }
                }
        }
       
        while (iB < arrB.length) {
                arrC[iC] = arrB[iB];
                iB++;
                iC++;
        }
}

	public static void merge_sort (int[] arr) {
        int n = arr.length;
       
        if (n == 1) return;
       
        int[] arr_temp1 = new int[n/2];
        int[] arr_temp2 = new int[n - n/2];
       
        for (int i = 0; i< n/2; i++) {
            arr_temp1[i] = arr[i];
        }
        for (int i = 0; i< n - n/2; i++) {
            arr_temp2[i] = arr[i + n/2];
        }
       
        merge_sort(arr_temp1);
        merge_sort(arr_temp2);
       
        merge(arr_temp1, arr_temp2, arr);
        
	}


}
