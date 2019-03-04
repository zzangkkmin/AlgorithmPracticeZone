package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main16922 {
	public static int[] roma = {1,5,10,50};
	public static int n;
	public static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		find();
	}
	public static void find() {
		set.add(0);
		for(int lev = 0; lev < n; lev++) {
			HashSet<Integer> tempset = new HashSet<>();
			for(int sett : set) {
				for(int rom : roma) {
					tempset.add(sett+rom);
				}
			}
			set = tempset;
		}
		System.out.println(set.size());
	}
}
