package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1074 {
	public static int r;
	public static int c;
	public static int Cnt = 0;
	public static int Ans = -1;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] Line = br.readLine().split(" ");
		int N = Integer.parseInt(Line[0]);//2^N * 2^N
		r = Integer.parseInt(Line[1]);
		c = Integer.parseInt(Line[2]);
		int twoN = 1;
		for(int i = 0; i < N ; i++){
			twoN *= 2;
		}
		solve(twoN,0,0);
		System.out.println(Ans);
	}
	public static void solve(int size, int x, int y){
		if(x==r && y==c){
			Ans = Cnt;
			return;
		}
		if(size==1){
			Cnt++;
			return;
		}
		if(!(x <= r && r < x + size && y <= c && c < y + size)){
			Cnt += size * size;
			return;
		}
		else{
			solve(size/2, x, y);
			solve(size/2, x, y + size / 2);
			solve(size/2, x + size / 2, y);
			solve(size/2, x + size / 2, y + size / 2);
		}
	}
}
