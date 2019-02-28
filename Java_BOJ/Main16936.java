package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main16936 {
	public static int n;
	public static long[] arr;
	public static ArrayList<Long>[] atob;
	public static Map<Long,Integer> map = new HashMap<Long, Integer>();
	public static Map<Long,Integer> idxmap = new HashMap<Long, Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		arr = new long[n];
		atob = new ArrayList[n];
		String[] line = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Long.parseLong(line[i]);
			map.put(arr[i], 0);
			idxmap.put(arr[i], i);
			atob[i] = new ArrayList<>();
		}
		for(int i=0;i<n;i++) {
			if(arr[i] % 3 == 0) {
				long next = arr[i] / 3;
				if(map.containsKey(next)) {
					map.replace(next, map.get(next)+1);
					atob[i].add(next);
				}
			}
			long next = arr[i] * 2;
			if(map.containsKey(next)) {
				map.replace(next, map.get(next)+1);
				atob[i].add(next);
			}
		}
		find(0);
	}
	public static void find(int cnt) {
		if(cnt==n) {
			System.out.println();
			return;
		}
		for(long k : map.keySet()) {
			if(map.get(k)==0) {
				System.out.print(k+" ");
				int idx = idxmap.get(k);
				for(long next:atob[idx]) {
					map.replace(next, map.get(next)-1);
				}
				map.remove(k);
				find(cnt+1);
				break;
			}
		}
	}
}
