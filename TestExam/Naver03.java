package com.ssafy.git.TestExam;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Naver03 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//int[][] data = { {1,2,10}, {2,5,8}, {3,6,9}, {4,20,6}, {5,25,5} };
		int[][] data = { {1,0,5}, {2,2,2}, {3,3,1}, {4,4,1}, {5,10,2} };
		int[] ans = solution(data);
		for(int num : ans) {
			System.out.print(num+" ");
		}
		System.out.println();
	}

	static int[] solution(int[][] data) {
		// TODO Auto-generated method stub
		int[] ans = new int[data.length];
		int ansIdx = 0;
		int idx = 0;
		int time = 0;
		// 1.
		int[] pd = data[0];
		time = pd[1] + pd[2];
		ans[ansIdx++] = 1;
		idx++;
		
		PriorityQueue<docu> pq = new PriorityQueue<docu>(new comparatorPQ());
		
		//2.
		while(true) {
			if(ansIdx == data.length) {
				break;
			}
			for(int i=idx;i<data.length;i++) {
				if(data[i][1] <= time) {
					pq.add(new docu(data[i][0], data[i][1], data[i][2]));
					idx = i;
				}
				else {
					idx++;
					//pq.add(new docu(data[idx][0], data[idx][1], data[idx][2]));
					break;
				}
				if(i==data.length-1) {
					idx = data.length;
				}
			}
			docu print = pq.poll();
			time = time + print.page;
			ans[ansIdx++] = print.num;
		}
		
		return ans;
	}
	static class docu{
		int num;
		int reqT;
		int page;
		public docu(int num, int reqT, int page) {
			super();
			this.num = num;
			this.reqT = reqT;
			this.page = page;
		}
		
	}
	static class comparatorPQ implements Comparator<docu>{

		@Override
		public int compare(docu o1, docu o2) {
			// TODO Auto-generated method stub
			if(o1.page == o2.page) {
				if(o1.num < o2.num) {
					return -1;
				} else {
					return 1;
				}
			} else {
				return o1.page < o2.page ? -1 : 1;
			}
		}
		
	}
}
