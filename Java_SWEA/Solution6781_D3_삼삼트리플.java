package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution6781_D3_삼삼트리플 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t<=tc;t++) {
			char[] num = sc.next().toCharArray();
			char[] RGB = sc.next().toCharArray();
			int[][] RGB_NUM = new int[3][10];
			for(int i=0;i<9;i++) {
				if(RGB[i]=='R') {
					RGB_NUM[0][num[i]-'0']++;
				}
				if(RGB[i]=='G') {
					RGB_NUM[1][num[i]-'0']++;
				}
				if(RGB[i]=='B') {
					RGB_NUM[2][num[i]-'0']++;
				}
			}
			
			boolean isWin = true;
			for(int i = 0; i <3;i++) {
				if(!isWin)
					break;
				for(int j = 0; j <10;) {
					if(RGB_NUM[i][j] >= 3) {
						RGB_NUM[i][j] -= 3;
					}
					else if(RGB_NUM[i][j] >= 1) {
						if(j+2<=9 && RGB_NUM[i][j+1] >= 1 && RGB_NUM[i][j+2] >= 1) {
							RGB_NUM[i][j] -= 1;
							RGB_NUM[i][j + 1] -= 1;
							RGB_NUM[i][j + 2] -= 1;
						}
						else {
							isWin = false;
							break;
						}
					}
					else {
						j++;
					}
				}
			}
			System.out.println("#"+t+" "+(isWin?"Win":"Continue"));
		}
	}	

}
