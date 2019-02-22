package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1297 {
	public static int inch, x,y;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		inch = Integer.parseInt(line[0]);
		x = Integer.parseInt(line[1]);
		y = Integer.parseInt(line[2]);
		double k = (double) (inch*inch) / (double) (x*x + y*y);
		k = Math.sqrt(k);
		System.out.println((int) (x*k) + " " + (int) (y*k));
	}

}
