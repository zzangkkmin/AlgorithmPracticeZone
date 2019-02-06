package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main1202 {
	static class jew{
		int m;
		int v;
		public jew(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}
	public static class jewCompare implements Comparator<jew>{

		@Override
		public int compare(jew o1, jew o2) {
			// TODO Auto-generated method stub
			return o1.m - o2.m;
		}
		
	}
	public static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static int n,k;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		k = Integer.parseInt(line[1]);
		
		jew[] jewArr = new jew[n];
		for(int i=0;i<n;i++){
			line = br.readLine().split(" ");
			int m = Integer.parseInt(line[0]);
			int v = Integer.parseInt(line[1]);
			jewArr[i] = new jew(m,v); 
		}
		Arrays.sort(jewArr, new jewCompare());
		
		int[] bagArr = new int[k];
		for(int i=0;i<k;i++){
			int bag = Integer.parseInt(br.readLine().trim());
			bagArr[i] = bag;
		}
		Arrays.sort(bagArr);
		
		long ans = 0;
		for(int bagIdx = 0, jewIdx = 0; bagIdx < k; bagIdx++){
			while(jewIdx < n && jewArr[jewIdx].m <= bagArr[bagIdx]){
				pq.add(-jewArr[jewIdx].v);
				jewIdx++;
			}
			if(!pq.isEmpty()){
				ans += -pq.poll();
			}
		}
		System.out.println(ans);
		
	}

}
