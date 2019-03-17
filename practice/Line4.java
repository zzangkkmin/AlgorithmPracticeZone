package com.ssafy.git.practice;

import java.util.Scanner;
import java.util.Stack;

public class Line4 {
	public static int n, d;
	public static Stack<Integer[]> s = new Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		//d = 1;//이것때매 틀렸음
		for(int i = 0;i<n;i++){
			int h = sc.nextInt();
			if(s.isEmpty()){
				s.add(new Integer[] {h,i});
			}
			else{
				while(!s.isEmpty()){
					Integer[] top = s.peek();
					if(top[0] <= h){
						d = d < i - top[1] ? i - top[1] : d;
						s.pop();
					}
					else{
						break;
					}
				}
				s.add(new Integer[] {h,i});
			}
		}
		System.out.println(d);
	}
}
