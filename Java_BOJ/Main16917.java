package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16917 {
	public static int a,b,c,c2,x,y;
	public static long ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		//1<=a,b,c<=5000
		a = Integer.parseInt(line[0]); // 1x
		b = Integer.parseInt(line[1]); // 1y
		c = Integer.parseInt(line[2]); // 2C = 1x+1y 
		c2 = c*2;
		//1<=x,y<=100000
		x = Integer.parseInt(line[3]);
		y = Integer.parseInt(line[4]);
		if(a+b<c2){
			ans = a*x + b*y;
		}
		else{
			if(x<y){
				ans = c2 * x;
				if(b<c2){
					ans += b*(y-x);
				}
				else{
					ans += c2*(y-x);
				}
			}
			else{
				ans = c2 * y;
				if(a<c2){
					ans += a*(x-y);
				}
				else{
					ans += c2*(x-y);
				}
			}
		}
		System.out.println(ans);
	}

}
