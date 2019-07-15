package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main1158 {
	static int N, K;// 1<= K <= N <= 5000
	static int cur, prev, idx;
	static int restN, restK;
	static node[] person;
	static int[] ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		restN = N;
		restK = K;
		cur = 1;
		prev = N;
		idx = 0;
		person = new node[N+1];
		ans = new int[N];
		for(int i=1;i<=N;i++) {
			person[i] = new node(i);
		}
		for(int i=1;i<=N-1;i++) {
			person[i].next = person[i+1];
		}
		person[N].next = person[1];

		while(true) {
			if(restN == 1) {
				ans[idx] = cur;
				break;
			}
			restK = K;
			while(true) {
				if(restK == 1) {
					break;
				}
				prev = cur;
				cur = person[cur].next.num;
				restK--;
			}
			
			person[prev].next = person[cur].next;
			person[cur].delete();
			ans[idx] = cur;
			cur = person[prev].next.num;
			restN--;
			idx++;
		}
		System.out.print("<");
		for(int i=0;i<N-1;i++) {
			System.out.print(ans[i]+", ");
		}
		System.out.println(ans[N-1]+">");
		sc.close();
	}
	static public class node{
		int num;
		node next;
		
		public node() {
			super();
			// TODO Auto-generated constructor stub
		}
		public node(int num, node next) {
			super();
			this.num = num;
			this.next = next;
		}
		public node(int num) {
			super();
			this.num = num;
		}
		public void delete() {
			this.num = -1;
			this.next = null;
		}
		@Override
		public String toString() {
			return "node [num=" + num + ", next=" + next.num + "]";
		}
	}
}
