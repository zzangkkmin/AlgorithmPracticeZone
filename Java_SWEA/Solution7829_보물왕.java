package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution7829_보물왕 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			//mergeSort(arr);
			int first = findFirst(arr);
			int last = findLast(arr);
			System.out.println("#"+t+" "+(first*last));
		}
	}
	public static int findFirst(int[] arr) {
		int first = arr[0];
		for(int a : arr) {
			if(a < first) {
				first = a;
			}
		}
		return first;
	}
	public static int findLast(int[] arr) {
		int last = arr[0];
		for(int a : arr) {
			if(a > last) {
				last = a;
			}
		}
		return last;
	}
	//mergeSort route (실패)
	public static void mergeSort(int[] arr) {
		sort(arr,0,arr.length);
	}
	public static void sort(int[] arr, int low, int high) {
		if(high - low < 2) {
			return;
		}
		int mid = (low + high) / 2;
		sort(arr,0,mid);
		sort(arr,mid,high);
		merge(arr,low,mid,high);
	}
	public static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low];
		int t = 0; int l = low; int h = mid;
		while(l<mid && h<high) {
			if(arr[l] < arr[h]) {
				temp[t++] = arr[l++];
			}else {
				temp[t++] = arr[h++];
			}
		}
		while(l < mid) {
			temp[t++] = arr[l++];
		}
		while(h < high) {
			temp[t++] = arr[h++];
		}
		for(int i = low; i < high; i++) {
			arr[i] = temp[i-low];
		}
	}
}
