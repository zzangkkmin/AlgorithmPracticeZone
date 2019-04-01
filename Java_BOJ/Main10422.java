package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main10422 {
	public static int[] d;
	//d[n]=길이 n일때 올바른 괄호문자열의 개수
	//n은 짝수
	//첫번째는 여는괄호(1번째), 그리고 그 괄호에 맞는 잗는괄호는 임의위치(i번째)
	//나누기: 1~i(length: i-2) and i~n(length: n-i)
	//d[n] = for(i=짝수~n){d[i-2] * d[n-i]}	
	public static int n;
	public static int mod = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setting();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0;i<n;i++){
			int k = sc.nextInt();
			System.out.println(d[k]);
		}
	}
	public static void setting(){
		d = new int[5001];
		d[0] = 1; d[2] = 1;
		for(int i=4;i<=5000;i=i+2){
			for(int j=2;j<=i;j=j+2){
				d[i] += (d[j-2]%mod * d[i-j]%mod) % mod;
			}
		}
	}
}
