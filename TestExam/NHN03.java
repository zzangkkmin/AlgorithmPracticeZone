package com.ssafy.git.TestExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NHN03 {
	static int pn;
	static node[] player;
	static boolean[] addbonus;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pn = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().trim().split(" ");
		player = new node[pn]; addbonus = new boolean[pn];
		int pi = 0;
		for(int i=0;i<pn;i++) {
			player[i] = new node(0);
		}
		for(int i=0;i<line.length;) {
			if(line[i].equals("K")) {
				int follow = Integer.parseInt(line[i+1]);
				player[pi].pick(follow);
				i = i + 2;
				pi = (pi+1)%pn;
			}else {
				if(line[i].equals("A")) {
					for(int j=0;j<pn;j++) {
						addbonus[j] = false;
					}
					AJ(pi,false);
				} else if(line[i].equals("J")) {
					for(int j=0;j<pn;j++) {
						addbonus[j] = false;
					}
					int piL = pi-1;
					int piR = pi+1;
					if(piL < 0) piL = pn-1;
					if(piR == pn) piR = 0;
					AJ(piL,false);
					AJ(piR,false);
				} else if(line[i].equals("Q")) {
					for(int j=0;j<pn;j++) {
						player[j].val++;
					}
				}
				i++;
				pi = (pi+1)%pn;
			}
		}
		for(int i=0;i<pn;i++) {
			System.out.print(player[i].val);
			if(i<pn-1) {
				System.out.print(" ");
			}
		}
	}
	public static void AJ(int p, boolean bonus) {
		if(bonus && addbonus[p]) {
			return;
		}
		if(bonus) {
			addbonus[p] = true;
		}
		player[p].val++;
		if(player[p].follow.size() == 0) {
			return;
		}
		for(int fn : player[p].follow) {
			AJ(fn,true);
		}
	}
	static class node{
		int val;
		ArrayList<Integer> follow;
		public node(int val) {
			super();
			this.val = val;
			this.follow = new ArrayList<>();
		}
		public void pick(int fp) {
			this.follow.add(fp);
		}
	}
}
