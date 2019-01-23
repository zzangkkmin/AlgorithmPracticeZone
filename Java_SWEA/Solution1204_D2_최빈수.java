package com.ssafy.swe;

import java.util.Scanner;

public class Solution1204_D2_최빈수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int T = 1; T<=test_case;T++){
			int tt = sc.nextInt();
			int[] scoreNum = new int[101];
			for(int i=0;i<1000;i++){
				int score = sc.nextInt();
				scoreNum[score]++;
			}
			int Ans = 0; int Max = 0;
			for(int i=100;i>=0;i--){
				if(Max<scoreNum[i]){
					Ans = i;
					Max = scoreNum[i];
				}
			}
			System.out.println("#" + tt + " " + Ans);
		}
	}
}
