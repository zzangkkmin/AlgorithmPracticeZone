package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1027 {
	public static int ans = 0;
	public static long[][] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().split(" ");
		arr = new long[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0] = i+1;
			arr[i][1] = Long.parseLong(line[i]);
		}
		for(int A = 0; A<n; A++) {
			int temp = 0;
			//left
			for(int B = A - 1; B>=0; B--) {
				if(A-B==1) {
					temp++;
					continue;
				}
				boolean isOK = true;
				for(int C = B + 1; C<A; C++) {
					if(ccwAl(arr[A][0],arr[A][1],arr[B][0],arr[B][1],arr[C][0],arr[C][1]) != 1) {
						isOK = false;
						break;
					}
				}
				if(isOK) {
					temp++;
				}
			}
			//right
			for(int B = A + 1; B<n; B++) {
				if(B-A==1) {
					temp++;
					continue;
				}
				boolean isOK = true;
				for(int C = B-1; C>A; C--) {
					if(ccwAl(arr[A][0],arr[A][1],arr[B][0],arr[B][1],arr[C][0],arr[C][1]) != -1) {
						isOK = false;
						break;
					}
				}
				if(isOK) {
					temp++;
				}
			}
			ans = ans < temp ? temp : ans;
		}
		System.out.println(ans);
	}	
	public static int ccwAl(long x1, long y1, long x2, long y2, long x3, long y3) {
		long res = (x1*y2+x2*y3+x3*y1) - (y1*x2+y2*x3+y3*x1);
		if(res<0)
			return -1;//clock
		else if(res==0)
			return 0;//one-line
		else
			return 1;//counter-clock
	}
}
