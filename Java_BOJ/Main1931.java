package com.ssafy.git.Java_BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1931 {
	static class Node implements Comparable{
		private int num;
		private int x;
		private int y;
		Node(int num, int x, int y){
			this.num = num;
			this.x = x;
			this.y = y;
		}
		int getNum() {
			return num;
		}
		int getX() {
			return x;
		}
		int getY() {
			return y;
		}

		@Override
		public int compareTo(Object arg0) {
			Node other = (Node) arg0;
			if(y>other.getY())
				return 1;
			else if(y<other.getY())
				return -1;
			else {
				if(x>other.getX())
					return 1;
				else if(x<other.getX())
					return -1;
				else {
					return 0;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node[] node = new Node[n];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			int start = sc.nextInt();
			int end = sc.nextInt();
			node[i] = new Node(num,start,end);
		}
		
		Arrays.sort(node);
		
//		for(int i=0;i<n;i++) {
//			System.out.println(node[i].getX() + " " + node[i].getY());
//		}
		
		int end_time = node[0].getY();
		list.add(node[0].getNum());
		int idx = 1;
		int ans = 1;
		while(idx < node.length) {
			if(node[idx].getX() < end_time) {
				idx++;
			}
			else {
				end_time = node[idx].getY();
				ans++;
				list.add(node[idx].getNum());
				idx++;
			}
		}
		System.out.println(ans);
		for(int a : list) {
			System.out.print(a+" ");
		}
		System.out.println();
		sc.close();
	}

}
