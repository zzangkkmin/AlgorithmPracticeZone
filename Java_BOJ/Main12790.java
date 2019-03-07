package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12790 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<n;i++) {
			String[] line = br.readLine().trim().split(" ");
			int[] status = new int[4];
			for(int j=0;j<4;j++) {
				status[j] = Integer.parseInt(line[j]);
			}
			for(int j=4;j<8;j++) {
				status[j-4] += Integer.parseInt(line[j]);
				if(j==4 && status[j-4] < 1) {
					status[j-4] = 1;
				}
				else if(j==5 && status[j-4] < 1) {
					status[j-4] = 1;
				}
				else if(j==6 && status[j-4] < 0) {
					status[j-4] = 0;
				}
			}
			int score = status[0] + status[1] * 5 + status[2] * 2 + status[3] * 2;
			System.out.println(score);
		}
	}

}
