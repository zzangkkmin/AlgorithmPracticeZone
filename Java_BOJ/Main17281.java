package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17281 {
	public static int maxScore;
	public static int inning;
	public static int[][] inn;
	public static int[] select, orderBat;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		inning = sc.nextInt();
		inn = new int[inning][9];
		select = new int[9];
		orderBat = new int[9];
		for(int i=0;i<inning;i++) {
			for(int j=0;j<9;j++) {
				inn[i][j] = sc.nextInt();
			}
		}
		batOrder(0,orderBat);
		System.out.println(maxScore);
		sc.close();
	}
	public static void batOrder(int idx, int[] order) {
		if(idx == 9) {
			play(order);
			return;
		}
		if(idx == 3) {
			select[0] = 1;
			order[idx] = 0;
			batOrder(idx+1,order);
		}
		else {
			for(int i=0;i<9;i++) {
				if(i==0)
					continue;
				if(select[i] == 0) {
					select[i] = 1;
					order[idx] = i;
					batOrder(idx+1,order);
					select[i] = 0;
				}
			}
		}
	}
	public static void play(int[] order) {
		int curInning = 0;
		int score = 0;
		int curBatter = 0;
		int out = 0;
		int[] base = new int[4];
		while(curInning < inning) {
			
			switch(inn[curInning][order[curBatter]]) {
			case 0:
				out++;
				break;
			case 1:
				if(base[3] == 1) {
					score++;
					base[3] = 0;
				}
				if(base[2] == 1) {
					base[3] = 1;
					base[2] = 0;
				}
				if(base[1] == 1) {
					base[2] = 1;
					base[1] = 0;
				}
				base[1] = 1;
				break;
			case 2:
				if(base[3] == 1) {
					score++;
					base[3] = 0;
				}
				if(base[2] == 1) {
					score++;
					base[2] = 0;
				}
				if(base[1] == 1) {
					base[3] = 1;
					base[1] = 0;
				}
				base[2] = 1;
				break;
			case 3:
				if(base[3] == 1) {
					score++;
					base[3] = 0;
				}
				if(base[2] == 1) {
					score++;
					base[2] = 0;
				}
				if(base[1] == 1) {
					score++;
					base[1] = 0;
				}
				base[3] = 1;
				break;
			case 4:
				if(base[3] == 1) {
					score++;
					base[3] = 0;
				}
				if(base[2] == 1) {
					score++;
					base[2] = 0;
				}
				if(base[1] == 1) {
					score++;
					base[1] = 0;
				}
				score++;
				break;
			}
			curBatter = (curBatter + 1) % 9;
			
			if(out==3) {
				for(int i=0;i<4;i++) {
					base[i] = 0;
				}
				out = 0;
				curInning++;
			}
		}

		maxScore = maxScore < score ? score : maxScore;
	}
	
}
