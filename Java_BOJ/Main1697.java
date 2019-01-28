package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1697 {
	public static int n,k,ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		k = Integer.parseInt(line[1]);
		find();
		System.out.println(ans);
	}
	public static void find() {
		int[] timer = new int[200001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		timer[n] = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur==k) {
				ans = timer[cur] - 1;
				break;
			}
			if(cur-1>=0 && timer[cur-1]==0) {
				q.add(cur-1);
				timer[cur-1] = timer[cur] + 1;
			}
			if(cur+1<=200000 && timer[cur+1]==0) {
				q.add(cur+1);
				timer[cur+1] = timer[cur] + 1;
			}
			if(cur*2<=200000 && timer[cur*2]==0) {
				q.add(cur*2);
				timer[cur*2] = timer[cur] + 1;
			}
		}
	}
}
