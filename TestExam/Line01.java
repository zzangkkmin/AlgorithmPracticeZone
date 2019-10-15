package com.ssafy.git.TestExam;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Line01 {
	static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<m;i++) {
			pq.add(0);
		}
		for(int i=0;i<n;i++) {
			int time = sc.nextInt();
			int user = pq.poll();
			pq.add(user + time);
		}
		int ans = 0;
		while(!pq.isEmpty()) {
			int time = pq.poll();
			ans = ans < time ? time : ans;
		}
		System.out.println(ans);
	}

}
