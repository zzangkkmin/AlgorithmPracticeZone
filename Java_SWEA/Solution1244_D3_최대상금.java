package com.ssafy.git.Java_SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1244_D3_최대상금 {
	static int max;
	static int change_num;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<=T;t++) {
			max = -1;
			String num = sc.next();
			char[] cnum = num.toCharArray();
			change_num = sc.nextInt();
			
			Arrays.sort(cnum);
			int size = cnum.length;
			System.out.print("#" + t + " ");
			for(int i=0;i<size;i++) {
				System.out.print(cnum[i]);
			}
			System.out.println();
		}
	}

}
