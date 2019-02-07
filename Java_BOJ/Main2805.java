package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2805 {
	public static long n;//1~1,000,000
	public static long m;//1~2,000,000,000
	public static long[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		arr = new long[(int)n];
		line = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(arr);
		long mini = 1;
		long maxi = arr[arr.length - 1];
		while(mini <= maxi){
			long mid = (mini + maxi) / 2;
			long temp = 0;
			for(int i=0;i<n;i++){
				temp += (arr[i] - mid < 0 ? 0 : arr[i] - mid);
			}
			if(temp>=m){
				mini = mid + 1;
			}
			else{
				maxi = mid - 1;
			}
		}
		System.out.println(maxi);
	}

}
