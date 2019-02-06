package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1655 {
	public static PriorityQueue<Integer> minq = new PriorityQueue<>();
	public static PriorityQueue<Integer> maxq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<n;i++){
			int a = Integer.parseInt(br.readLine().trim());
			if(maxq.isEmpty()){
				maxq.add(-a);
			}
			else if(-maxq.peek() < a){
				minq.add(a);
			}
			else{
				maxq.add(-a);
			}
			
			if(maxq.size() < minq.size()){
				maxq.add(-minq.poll());
			}
			else if(maxq.size() > minq.size() + 1){
				minq.add(-maxq.poll());
			}
			System.out.println(-maxq.peek());
		}
	}

}
