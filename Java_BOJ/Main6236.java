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
		int left = 0;
		int right = Integer.MAX_VALUE - 1;
		for(int i=0;i<n;i++){
			spend[i] = Integer.parseInt(br.readLine().trim());
			left = left < spend[i] ? spend[i] : left;
		}
		right -= left;
		
		while(left<=right){
			int mid = (left + right) / 2;
			if(!injection(mid)){
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}
		}
		System.out.println(left);
	}
	public static boolean injection(int kk){
		int cnt = 0; int money = 0;
		for(int i=0;i<n;i++){
			if(money - spend[i] < 0){
				cnt++;
				money += kk;
				money -= spend[i];
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
