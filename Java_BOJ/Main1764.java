package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main1764 {
	static int n,m,size;
	static String[] list, ans;
	static final int modR = 2003;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		list = new String[n+m];
		ans = new String[n+m];
		for(int i=0;i<n+m;i++) {
			list[i] = sc.next();
		}
		QuickSort(0,n+m-1);
		for(int i=1;i<n+m;i++) {
			if(list[i].equals(list[i-1])) {
				ans[size++] = list[i];
				i++;
			}
		}
		System.out.println(size);
		for(int i=0;i<size;i++) {
			System.out.println(ans[i]);
		}	
	}
	
	public static void QuickSort(int l, int r) {
		if(l>=r) return;
		int mid = partition(l,r);
		QuickSort(l, mid - 1);
		QuickSort(mid, r);
	}
	public static int partition(int l, int r) {
		String pivot = list[(l+r)/2];
		while( l <= r ) {
			while( list[l].compareTo(pivot) < 0 ) l++;
			while( list[r].compareTo(pivot) > 0 ) r--;
			if( l <= r ) {
				swap(l,r);
				l++; r--;
			}
		}
		return l;
	}
	public static void swap(int a, int b) {
		String temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
}
