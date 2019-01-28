package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution1240_D3_단순이진암호 {
	public static int numeric(char[] b) {
		String s = "";
		for(int i=0;i<7;i++) {
			s += b[i];
		}
//		System.out.println(s);
		if(s.equals("0001101")) {//0
			return 0;
		}
		else if(s.equals("0011001")) {//1
			return 1;
		}
		else if(s.equals("0010011")) {//2
			return 2;
		}
		else if(s.equals("0111101")) {//3
			return 3;
		}
		else if(s.equals("0100011")) {//4
			return 4;
		}
		else if(s.equals("0110001")) {//5
			return 5;
		}
		else if(s.equals("0101111")) {//6
			return 6;
		}
		else if(s.equals("0111011")) {//7
			return 7;
		}
		else if(s.equals("0110111")) {//8
			return 8;
		}
		else if(s.equals("0001011")) {//9
			return 9;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t<=tc;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] map = new char[n][m];
			for(int i=0;i<n;i++) {
				map[i] = sc.next().toCharArray();
			}
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<m;j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			int sx = -1; int sy = -1; boolean find = false;
			for(int i=0;i<n;i++) {
				if(find)
					break;
				for(int j = m - 1; j>=0; j--) {
					if(map[i][j] == '1') {
						sx = i; sy = j - 56 + 1;
						find = true;
						break;
					}
				}
			}
			char[] temp = new char[7];
			int[] number = new int[8];
			int nIdx = 0;
			for(int i = sy, j = 0; i <= sy + 56 - 1; i++, j = (j+1)%7) {
				temp[j] = map[sx][i];
				if(j==6) {
					number[nIdx] = numeric(temp);
					nIdx++;
				}
			}
			int sum = 0; int odd = 0; int even = 0;
			for(int i=0;i<8;i++) {
				sum += number[i];
				if(i%2==0) {
					odd += number[i];
				}
				else {
					even += number[i];
				}
			}
			int confirm = odd * 3 + even;
			if(confirm%10==0) {
				System.out.println("#" + t + " " + sum);
			}
			else {
				System.out.println("#" + t + " " + 0);
			}
			
		}
	}

}
