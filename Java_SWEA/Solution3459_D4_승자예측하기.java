package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution3459_D4_승자예측하기 {
	public static long n, turn, level;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			n = Long.parseLong(br.readLine().trim());
			turn = 0;
			if(n==1) {
				bw.write("#"+t+" Bob\n");
			}
			else if(n==2 || n==3) {
				bw.write("#"+t+" Alice\n");
			}
			else {
				bw.write("#"+t+" "+find()+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static String find() {
		for(int i=0;;i++) {
			if(n>=Math.pow(2, i) && n<Math.pow(2, i+1)) {
				level = i;
				if(i%2==0) {
					//alice level
					turn = 0;
				}
				else {
					//bob level
					turn = 1;
				}
				break;
			}
		}
		long x = 1;
		String res = "";
		if(turn==0) {//alice level;
			for(int i = 0; i<level;i++) {
				x = 2*x+1; i++;
				x = 2*x;
				if(i==(level-1) && x <= n) {
					res = "Bob";
				}
				else if(i==(level-1) && x > n){
					res = "Alice";
				}
			}
		}
		else {//bob level
			for(int i = 0; i<=level;i++) {
				x = 2*x; i++;
				if(i==(level) && x <= n) {
					res = "Alice";
				}
				else if(i==(level) && x > n){
					res = "Bob";
				}
				x = 2*x + 1;
			}
		}
		return res;
	}
}
