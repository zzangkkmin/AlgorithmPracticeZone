package com.ssafy.git.Java_SWEA;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution4047_D3_카드카운팅 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			char[] input = sc.next().toCharArray();
			int[][] deck = new int[4][13+1];
			boolean error = false;
			for(int i=0;i<4;i++) {
				char SDHC = input[i*3+0];//S,D,H,C
				int num = (input[i*3+1] - '0') * 10;//10
				num += (input[i*3+2] - '0');//01
				if(SDHC=='S') {
					deck[0][num]++;
					if(deck[0][num]==2) {
						error = true;
						break;
					}
				}
				else if(SDHC=='D') {
					deck[1][num]++;
					if(deck[1][num]==2) {
						error = true;
						break;
					}
				}
				else if(SDHC=='H') {
					deck[2][num]++;
					if(deck[2][num]==2) {
						error = true;
						break;
					}
				}
				else if(SDHC=='C') {
					deck[3][num]++;
					if(deck[3][num]==2) {
						error = true;
						break;
					}
				}
			}
			if(error) {
				System.out.println("#" + test_case + "ERROR");
			}
			else {
				System.out.print("#" + test_case + " ");
				for(int i=0;i<4;i++) {
					int cnt = 0;
					for(int j=1;j<=13;j++) {
						if(deck[i][j]==0) {
							cnt++;
						}
					}
					System.out.print(cnt + " ");
				}
			}
		}
	}

}
