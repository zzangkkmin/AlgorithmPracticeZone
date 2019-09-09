package com.ssafy.git.Java_BOJ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main12886 {
	public static int[] abc = new int[3];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		abc[0] = sc.nextInt();
		abc[1] = sc.nextInt();
		abc[2] = sc.nextInt();
		if((abc[0]+abc[1]+abc[2])%3 != 0) {
			System.out.println("0");
		}
		else {
			Arrays.sort(abc);
			System.out.println(find(abc));
		}
	}
	public static int find(int[] abc) {
		Set<Long> visit = new HashSet<Long>();
		Queue<int[]> q = new LinkedList<int[]>();
		visit.add(new Long(abc[0] * 1000 * 1000 + abc[1] * 1000 + abc[2]));
		q.add(abc);
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == cur[1] && cur[1] == cur[2]) {
				return 1;
			}
			if(cur[0] < cur[1]) {
				int[] next = {cur[0],cur[1],cur[2]};
				next[1] = next[1] - next[0];
				next[0] = next[0] + next[0];
				Arrays.sort(next);
				Long nv = new Long(next[0] * 1000 * 1000 + next[1] * 1000 + next[2]);
				if(!visit.contains(nv)) {
					visit.add(nv);
					q.add(next);
				}
			}
			if(cur[0] < cur[2]) {
				int[] next = {cur[0],cur[1],cur[2]};
				next[2] = next[2] - next[0];
				next[0] = next[0] + next[0];
				Arrays.sort(next);
				Long nv = new Long(next[0] * 1000 * 1000 + next[1] * 1000 + next[2]);
				if(!visit.contains(nv)) {
					visit.add(nv);
					q.add(next);
				}
			}
			if(cur[1] < cur[2]) {
				int[] next = {cur[0],cur[1],cur[2]};
				next[2] = next[2] - next[1];
				next[1] = next[1] + next[1];
				Arrays.sort(next);
				Long nv = new Long(next[0] * 1000 * 1000 + next[1] * 1000 + next[2]);
				if(!visit.contains(nv)) {
					visit.add(nv);
					q.add(next);
				}
			}
		}
		return 0;
	}
}
