package com.ssafy.git.TestB;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionB01 {
	static final int div = 1000000007;
	static int n;
	static long aa,bb;
	static axb[] ab;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			ab = new axb[n];
			for(int i=0;i<n;i++) {
				aa = sc.nextLong();
				bb = sc.nextLong();
				ab[i] = new axb(aa, bb);
			}
			//Arrays.sort(ab);
			//MergeSort(ab, 0, ab.length);
			Qsort(ab, 0, ab.length-1);
			long v = 1;
			for(int i=0;i<n;i++) {
				v = ab[i].a * v % div;
				v = v + ab[i].b % div;
			}
			System.out.println("#" + test_case + " " + v);
		}
	}
	static class axb implements Comparable<axb>{
		long a;
		long b;
		@Override
		public int compareTo(axb other) {
			if(other.b * (this.a - 1) < this.b * (other.a - 1)) {
				return 1;
			}
			return -1;
		}
		public axb() {
			super();
			// TODO Auto-generated constructor stub
		}
		public axb(long a, long b) {
			super();
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
			return "axb [a=" + a + ", b=" + b + "]";
		}
		
	}
	static void MergeSort(axb[] AXB, int low, int high) {
		if(high - low < 2) {
			return;
		}
		
		int mid = (low+high) / 2;
		MergeSort(AXB,0,mid);
		MergeSort(AXB,mid,high);
		merge(AXB,low,mid,high);
	}
	static void merge(axb[] AXB, int low, int mid, int high) {
		axb[] temp = new axb[high - low];
		int t = 0, l = low, h = mid;
		
		while(l < mid && h < high) {
			if(AXB[l].b * (AXB[h].a - 1) < AXB[h].b * (AXB[l].a - 1)) {
				temp[t++] = AXB[l++];
			}
			else {
				temp[t++] = AXB[h++];
			}
		}
		
		while(l<mid) {
			temp[t++] = AXB[l++];
		}
		while(h<high) {
			temp[t++] = AXB[h++];
		}
		
		for(int i = low; i < high; i++) {
			AXB[i] = temp[i - low];
		}
	}
	static void Qsort(axb[] AXB, int low, int high) {
		if(low >= high) {
			return;
		}
		int mid = partition(AXB,low,high);
		Qsort(AXB,low,mid-1);
		Qsort(AXB,mid,high);
	}
	static int partition(axb[] AXB, int low, int high) {
		axb pivot = AXB[(low+high)/2];
		while(low <= high) {
			while(AXB[low].b * (pivot.a - 1) < pivot.b * (AXB[low].a - 1)) {
				low++;
			}
			while(AXB[high].b * (pivot.a - 1) > pivot.b * (AXB[high].a - 1)) {
				high--;
			}
			if(low <= high) {
				swap(AXB,low,high);
				low++;
				high--;
			}
		}
		return low;
	}
	private static void swap(axb[] AXB, int i, int j) {
		axb tmp = AXB[i];
		AXB[i] = AXB[j];
		AXB[j] = tmp;
	}
}
