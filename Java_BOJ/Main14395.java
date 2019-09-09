package com.ssafy.git.Java_BOJ;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main14395 {
	static long S,T;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		S = sc.nextLong();
		T = sc.nextLong();
		if(S==T) {
			System.out.println("0");
		}else {
			solve();
		}
	}
	public static void solve() {
		Queue<qCont> q = new LinkedList<qCont>();
		Set<Long> s = new HashSet<Long>();
		
		s.add(S);
		q.add(new qCont(S, ""));
		
		while(!q.isEmpty()) {
			qCont cur = q.poll();
			
			if(cur.num == T) {
				System.out.println(cur.opp);
				return;
			}
			if(cur.num == 0) {
				continue;
			}
			long op1 = cur.num + cur.num;
			long op2 = cur.num - cur.num;
			long op3 = cur.num * cur.num;
			long op4 = cur.num / cur.num;
			
			if(!s.contains(op3)) {
				s.add(op3);
				q.add(new qCont(op3,cur.opp+"*"));
			}
			if(!s.contains(op1)) {
				s.add(op1);
				q.add(new qCont(op1,cur.opp+"+"));
			}
			if(!s.contains(op2)) {
				s.add(op2);
				q.add(new qCont(op2,cur.opp+"-"));
			}
			if(!s.contains(op4)) {
				s.add(op4);
				q.add(new qCont(op4,cur.opp+"/"));
			}
		}
		System.out.println("-1");
		return;
	}
	public static class qCont{
		long num;
		String opp;
		public qCont() {
			super();
			// TODO Auto-generated constructor stub
		}
		public qCont(long num, String opp) {
			super();
			this.num = num;
			this.opp = opp;
		}
		@Override
		public String toString() {
			return "qCont [num=" + num + ", opp=" + opp + "]";
		}
		
	}
}
