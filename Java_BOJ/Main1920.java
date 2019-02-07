package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1920 {
	public static int n,m;
	public static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		arr = new int[n];
		String[] line = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(arr);
		m = Integer.parseInt(br.readLine().trim());
		line = br.readLine().split(" ");
		for(int i=0;i<m;i++){
			int confirm = Integer.parseInt(line[i]);
			System.out.println(find(confirm));
		}
	}
	public static int find(int confirm){
		int l = 0; int r = arr.length - 1;
		while(l<=r){
			int mid = (l+r) / 2;
			if(arr[mid]==confirm){
				return 1;
			}
			if(confirm < arr[mid]){
				r = mid - 1;
			}
			else{
				l = mid + 1;
			}
		}
		return 0;
	}
}
