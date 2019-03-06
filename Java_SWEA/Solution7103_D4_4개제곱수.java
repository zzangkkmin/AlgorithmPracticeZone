package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution7103_D4_4개제곱수 {
	public static int[] powerArr = new int[182];
	public static int[] number = new int[32768];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine().trim());
		init();
		for(int t=1;t<=tc;t++) {
			int n = Integer.parseInt(br.readLine().trim());
			System.out.println("#"+t+" "+number[n]);
		}
	}
	public static void init() {
		for(int i=1;i<=181;i++) {
			powerArr[i] = i*i;
		}
		for(int a=1;a<=181;a++) {
			if(powerArr[a] <= 32767)
				number[powerArr[a]]++;
			for(int b=a;b<=181;b++) {
				if(powerArr[a]+powerArr[b] <= 32767)
					number[powerArr[a]+powerArr[b]]++;
				for(int c=b;c<=181;c++) {
					if(powerArr[a]+powerArr[b]+powerArr[c] <= 32767)
						number[powerArr[a]+powerArr[b]+powerArr[c]]++;
					for(int d=c;d<=181;d++) {
						if(powerArr[a]+powerArr[b]+powerArr[c]+powerArr[d] <= 32767)
							number[powerArr[a]+powerArr[b]+powerArr[c]+powerArr[d]]++;
					}
				}
			}
		}
	}
}
