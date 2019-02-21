package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6236 {
	public static int n,m;
	public static int[] spend;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] Line = br.readLine().split(" ");
		n = Integer.parseInt(Line[0]);
		m = Integer.parseInt(Line[1]);
		spend = new int[n];
		long left = 0;
		long right = Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			spend[i] = Integer.parseInt(br.readLine().trim());
			left = left < spend[i] ? spend[i] : left;
		}
		
		while(left<=right){
			long mid = (long) (left + right) / 2;
			if(!injection(mid)){
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}
		}
		System.out.println(left);
	}
	public static boolean injection(long kk){
		int cnt = 1; long money = kk;
		for(int i=0;i<n;i++){
			if(money - spend[i] < 0){
				cnt++;
				money = kk - spend[i];
			}
			else{
				money -= spend[i];
			}
		}
		if(cnt > m){
			return false;
		}
		else{
			return true;
		}
	}

}
