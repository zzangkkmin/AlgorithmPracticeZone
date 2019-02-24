package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main3015 {
	public static int n;
	public static long ans = 0;
	public static Integer[] in;
	public static Stack<Integer[]> s = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<n;i++){
			int key = Integer.parseInt(br.readLine().trim());
			int combo = 0;
			if(s.isEmpty()){
				in = new Integer[2];
				in[0] = key; 
				in[1] = 1; //combo init;
				s.add(in);
			}
			else{
				while(true){
					if(!s.isEmpty()){
						if(s.peek()[0] < key){
							ans += s.peek()[1];
							s.pop();
						}
						else if(s.peek()[0] == key){
							combo += s.peek()[1];
							ans += s.peek()[1];
							s.pop();
						}
						else{
							ans++;
							break;
						}
					}
					else{
						break;
					}
				}
				if(combo!=0){
					in = new Integer[2];
					in[0] = key; in[1] = combo+1;
					s.push(in);
				}
				else{
					in = new Integer[2];
					in[0] = key; in[1] = 1;
					s.add(in);
				}
			}
		}
		System.out.println(ans);
	}

}
