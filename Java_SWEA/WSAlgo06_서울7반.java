package com.ssafy.swe;

import java.util.LinkedList;
import java.util.Queue;

public class WSAlgo06_서울7반 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 20; 
		int output = 0;//who??
		Queue<Integer[]> q = new LinkedList<>();
		Integer[] init = {1,1};//person: ith, cnady: i
		q.add(init);
		int round = 1;
		while(true) {
			Integer[] cur = q.poll();
			Integer[] next = new Integer[2];
			input -= cur[1];
			System.out.println(cur[0] + "번 놈이 사탕 "+cur[1]+"개를 가져갔다!! 남은 개수는 "+
					input+"개이다!!");
			if(input<=0) {
				System.out.println(cur[0]+"번 놈이 마지막으로 적발되었다!!");
				break;
			}
			cur[0] = cur[0];
			cur[1] = cur[1]+1;
			q.add(cur);
			round++;
			next[0] = round;
			next[1] = 1;
			q.add(next);
		}
	}

}
