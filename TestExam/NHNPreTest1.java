package com.ssafy.git.TestExam;

import java.util.Scanner;

public class NHNPreTest1 {
	static int c,p,n;
	static int[] card;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		card = new int[c+1];
		for(int i=1;i<=c;i++) {
			card[i] = i;
		}
		p = sc.nextInt();
		for(int i=0;i<p;i++) {
			n = sc.nextInt();
			shuffle(c);
		}
		for(int i=1;i<=5;i++) {
			System.out.println(card[i]);
		}
	}
	public static void shuffle(int cardLen) {
		int frontCardIdx = n;
		int backCardIdx = cardLen - n + 1;
		int movingCardN = cardLen - 2*n;
		int cardIdx = 1;
		int[] ret = new int[c+1];
		for(int i=1;i<=c;i++) {
			ret[i] = card[i];
		}
		for(int i = frontCardIdx + 1; i < backCardIdx ; i++) {
			ret[cardIdx++] = card[i];
		}
		for(int i=1;i<=frontCardIdx;i++) {
			ret[cardIdx++] = card[i];
		}
		for(int i=backCardIdx; i<=cardLen; i++) {
			ret[cardIdx++] = card[i];
		}
		for(int i=1;i<=c;i++) {
			card[i] = ret[i];
		}
		if(movingCardN > 2*n) {
			shuffle(movingCardN);
		}
	}
}
