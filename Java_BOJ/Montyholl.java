package com.ssafy.git.Java_BOJ;

public class Montyholl {
	public static final int BN = 3;
	public static final int cnt = 100000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int change = 0;
		int noChange = 0;
		for(int i=0;i<cnt;i++) {
			boolean[] box = new boolean[BN];
			int rIdx = (int)(Math.random() * BN);
			box[rIdx] = true;
			int selectIdx = (int)(Math.random() * BN);
			
			int openIdx;
			for(int j=0;j<BN;j++) {
				if(j == rIdx)
					continue;
				if(j == selectIdx)
					continue;
				openIdx = j;
			}
			
			if(box[selectIdx])
				noChange++;
			else
				change++;
		}
		System.out.println("change: " + change + "(" + change*100/cnt + "%)");
		System.out.println("noChange: "+noChange + "(" + noChange*100/cnt + "%)");
	}

}
