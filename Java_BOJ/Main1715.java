package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1715 {
	public static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<n;i++){
			int a = Integer.parseInt(br.readLine().trim());
			pq.add(a);
		}
		int ans = 0;
		while(true){
			if(n==1){
				ans = 0;
				break;
			}
			if(pq.size() == 1){
				break;
			}
			else{
				int temp = pq.poll();
				temp += pq.poll();
				ans += temp;
				pq.add(temp);
			}
		}
		System.out.println(ans);
	}

}
