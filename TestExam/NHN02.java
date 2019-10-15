package com.ssafy.git.TestExam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NHN02 {
	static int n, qsize, qi;
	static HashMap<Integer, Integer> numls = new HashMap<>();
	static int[] queue;
	static ArrayList<Integer> ans = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		queue = new int[n]; qsize = 0; qi = 0;
		for(int i=0;i<n;i++) {
			String cmd = sc.next();
			if(cmd.equals("enqueue")) {
				int input = sc.nextInt();
				if(numls.containsKey(input)) {
					numls.replace(input, numls.get(input) + 1);
				}else {
					numls.put(input, 1);
				}
				queue[qi++] = input;
				qsize++;
			}else {
				deq();
			}
		}
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i));
			if(i!=ans.size()-1) {
				System.out.print(" ");	
			}
		}
	}
	public static void deq() {
		if(qsize==0) {
			ans.add(-1);
			return;
		}
		int King = 0; int KingVal = 0;
		for(int num : numls.keySet()) {
			if(KingVal < numls.get(num)) {
				King = num;
				KingVal = numls.get(num);
			}
			else if(KingVal == numls.get(num)) {
				King = 0;
			}
		}
		if(King == 0) {
			for(int i=0;i<qi;i++) {
				if(queue[i] != 0) {
					ans.add(queue[i]);
					queue[i] = 0;
					qsize--;
					break;
				}
			}
		}
		else {
			for(int i=0;i<qi;i++) {
				if(queue[i] == King) {
					ans.add(King);
					queue[i] = 0;
					qsize--;
					numls.replace(King, numls.get(King)-1);
					break;
				}
			}
		}
	}

}
