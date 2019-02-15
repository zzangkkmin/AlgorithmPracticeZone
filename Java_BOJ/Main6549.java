package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main6549 {
	public static Stack<Integer> s;
	public static String[] line;
	public static int[] height;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			if(n==0) {
				break;
			}
			height = new int[n+2];
			Arrays.fill(height, 0);
			for(int i=1;i<=n;i++) {
				height[i] = Integer.parseInt(line[i]);
			}
			int len = 0;
			long area = 0;
			s = new Stack<Integer>(); s.push(0);
			for(int i=1;i<=n+1;i++) {
				while(true) {
					if(s.size()==0)
						break;
					int prevIndex = s.peek();
					if(height[prevIndex] < height[i]) {
						break;
					}
					s.pop();
					if(s.size()>0) {
						long tempArea = (long) (height[prevIndex] * ((long)len - (long)s.peek()));
						area = area < tempArea ? tempArea : area;
					}
				}
				s.push(i);
				len++;
			}
			System.out.println(area);
		}
		
	}

}
