package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17136 {
	static int[][] map = new int[10][10];
	static int[][] tmap = new int[10][10];
	static int[] onearr = new int[10*10];
	static int idx = 0;
	static int ans = 26;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1){
					onearr[idx++] = i*10+j;
				}
			}
		}
		findPaper(0, new int[] {0,0,0,0,0,0});
		if(ans == 26){
			System.out.println(-1);
		}else{
			System.out.println(ans);
		}
	}
	public static boolean validPaper(int[] p){
		for(int i=1;i<=5;i++){
			if(p[i] > 5){
				return false;
			}
		}
		return true;
	}
	public static int cntPaper(int[] p){
		int cnt = 0;
		for(int i=1;i<=5;i++){
			cnt += p[i];
		}
		return cnt;
	}
	public static void findPaper(int nth, int[] p){
		if(validPaper(p)){
			return;
		}
		if(cntPaper(p) > ans){
			return;
		}
		if(nth == idx){
			int cnt = cntPaper(p);
			ans = ans > cnt ? cnt : ans;
			return;
		}
		int x = onearr[nth] / 10;
		int y = onearr[nth] % 10;
		if(tmap[x][y] == 1){
			findPaper(nth+1, p);
			return;
		}
		for(int s=5;s>=1;s--){
			if(isPaperin(x, y, s)){
				paperChkIn(x, y, s);
				p[s]++;
				findPaper(nth, p);
				p[s]--;
				paperChkOut(x, y, s);
			}
		}
	}
	public static boolean isPaperin(int x, int y, int size){
		if(x>10-size||y>10-size){
			return false;
		}
		for(int i=x;i<x+size;i++){
			for(int j=y;j<y+size;j++){
				if(map[i][j] == 0 || tmap[i][j] == 1){
					return false;
				}
			}
		}
		return true;
	}
	public static void paperChkIn(int x, int y, int size){
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				tmap[i][j] = 1;
			}
		}
	}
	public static void paperChkOut(int x, int y, int size){
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				tmap[i][j] = 0;
			}
		}
	}
}
