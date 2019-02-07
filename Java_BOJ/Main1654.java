package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1654 {
	public static int k;//1~10,000
	public static int n;//1~1,000,000
	public static int[] arr;//1~2^31-1
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		k = Integer.parseInt(line[0]);
		n = Integer.parseInt(line[1]);
		arr = new int[k];
		for(int i=0;i<k;i++){
			arr[i] = Integer.parseInt(br.readLine().trim());
		}
		Arrays.sort(arr);
		long mini = 1;
		long maxi = arr[arr.length - 1];
		while(mini <= maxi){
			long mid = (mini + maxi) / 2;
			int temp = 0;
			for(int i=0;i<k;i++){
				temp += (arr[i] / mid);
			}
			if(temp < n){
				maxi = mid - 1;
			}
			else{
				mini = mid + 1;
			}
		}
		System.out.println(maxi);
	}

}
