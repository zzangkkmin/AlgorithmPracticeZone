package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main1766 {
	public static Map<Integer, ArrayList<Integer> > mapp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);//1~n
		int m = Integer.parseInt(line[1]);
		mapp = new HashMap<Integer, ArrayList<Integer>>();
		int[] bb = new int[n+1];
		for(int mm = 0; mm < m ; mm++){
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			if(mapp.containsKey(a)){
				mapp.get(a).add(b);
			}
			else{
				mapp.put(a, new ArrayList<>());
				mapp.get(a).add(b);
			}
			bb[b]++;
		}
		pathFind(n,bb);
	}
	public static void pathFind(int n, int[] bb){
		int cnt = 0;
		while(true){
			if(cnt==n){
				break;
			}
			for(int a=1;a<=n;a++){
				if(bb[a]==0){
					if(mapp.containsKey(a)){
						for(int b : mapp.get(a)){
							bb[b]--;
						}
					}
					System.out.print(a + " ");
					bb[a] = -1;
					cnt++;
					break;
				}
			}
		}
	}

}
