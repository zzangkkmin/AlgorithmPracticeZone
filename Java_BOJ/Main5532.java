package com.ssafy.git.Java_BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main5532 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int ac, bd;
		if(a%c!=0) {
			ac = a/c+1;
		}
		else {
			ac = a/c;
		}
		if(b%d!=0) {
			bd = b/d + 1;
		}
		else {
			bd = b/d;
		}
		int m = ac<bd?bd:ac;
		System.out.println(l-m);
		
	}

}
