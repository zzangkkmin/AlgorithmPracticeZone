package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution5550_D4_개구리 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int t=1;t<=n;t++) {
			String str = br.readLine().trim();
			int size = str.length();
			ArrayList<Character> frog = new ArrayList<>(); 
			int fn = 0; boolean ok = true;
			for(int i=0;i<size;i++) {
				char cur = str.charAt(i);
				if(cur=='c') {
					boolean find = false;
					for(int j=0;j<fn;j++) {
						if(frog.get(j).equals('k')) {
							frog.set(j, 'c');
							find = true;
							break;
						}
					}
					if(!find) {
						frog.add('c');
						fn++;
					}
				}
				else if(cur=='r') {
					boolean find = false;
					for(int j=0;j<fn;j++) {
						if(frog.get(j).equals('c')) {
							frog.set(j, 'r');
							find = true;
							break;
						}
					}
					if(!find) {
						ok = false;
						break;
					}
				}
				else if(cur=='o') {
					boolean find = false;
					for(int j=0;j<fn;j++) {
						if(frog.get(j).equals('r')) {
							frog.set(j, 'o');
							find = true;
							break;
						}
					}
					if(!find) {
						ok = false;
						break;
					}
				}
				else if(cur=='a') {
					boolean find = false;
					for(int j=0;j<fn;j++) {
						if(frog.get(j).equals('o')) {
							frog.set(j, 'a');
							find = true;
							break;
						}
					}
					if(!find) {
						ok = false;
						break;
					}
				}
				else if(cur=='k') {
					boolean find = false;
					for(int j=0;j<fn;j++) {
						if(frog.get(j).equals('a')) {
							frog.set(j, 'k');
							find = true;
							break;
						}
					}
					if(!find) {
						ok = false;
						break;
					}
				}
			}
			if(ok==true) {
				for(int i = 0; i<fn;i++) {
					if(!frog.get(i).equals('k')) {
						ok = false;
						break;
					}
				}
				if(ok==false) {
					System.out.println("#"+t+" -1");
				}
				else {
					System.out.println("#"+t+" "+fn);
				}
			}
			else {
				System.out.println("#"+t+" -1");
			}
		}
	}

}
