package com.ssafy.git.Java_SWEA;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution5549_D3_홀짝 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			String str = sc.next();
			if((str.charAt(str.length() - 1) - '0') % 2 == 0) {
				str = "Even";
			}
			else {
				str = "Odd";
			}
			System.out.println("#" + test_case + " " + str);
		}
	}

}
