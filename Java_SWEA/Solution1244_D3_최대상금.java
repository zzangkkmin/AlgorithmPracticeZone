package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1244_D3_최대상금 {
	static boolean find = false;
	static int ans;
	static int change_num;
	static String[] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t = 1;t<=tc;t++) {
			ans = 0;
			line = br.readLine().split(" ");
			char[] num = line[0].toCharArray();
			change_num = Integer.parseInt(line[1]);
			change(num,0,0);
			System.out.println("#"+t+" "+ans);
		}
	}
	public static void change(char[] numbers, int cnt, int idx) {
		if(cnt==change_num) {
			int res = Integer.parseInt(new String(numbers));
			ans = ans < res ? res : ans;
			find = true;
			return;
		}
		for(int i = idx + 1; i<numbers.length;i++) {
			if(numbers[idx] <= numbers[i]) {
				char temp = numbers[idx];
				numbers[idx] = numbers[i];
				numbers[i] = temp;
				change(numbers,cnt+1,idx+1);
				temp = numbers[idx];
				numbers[idx] = numbers[i];
				numbers[i] = temp;
			}
		}
		if(find==false) {
			for(int i = idx + 1; i<numbers.length; i++) {
				change(numbers,cnt,idx+1);
			}
		}
	}
}
/*
10
123 1
2737 1
757148 1
78466 2
32888 2
777770 5
436659 2
431159 7
112233 3
456789 10

#1 321
#2 7732
#3 857147
#4 87664	/
#5 88832
#6 777770	/
#7 966354
#8 954311	/
#9 332211
#10 987645	/

78466 2
777770 5
431159 7
456789 10

*/