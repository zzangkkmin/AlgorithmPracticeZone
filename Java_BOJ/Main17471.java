package com.ssafy.git.Java_BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main17471 {
	static int n, ans;
	static int[] people, select, visited;
	static int map[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); ans = 9999;
		people = new int[n+1]; select = new int[n+1];
		visited = new int[n+1]; map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			people[i] = sc.nextInt();
		}
		for(int i=1;i<=n;i++) {
			int face = sc.nextInt();
			for(int j=1;j<=face;j++) {
				int nth = sc.nextInt();
				map[i][nth] = 1;
			}
		}
		set1(1);
		if(ans == 9999) ans = -1;
		System.out.println(ans);
	}
	public static void set1(int idx) {
		if(idx==n+1) {
			set2();
			return;
		}
		select[idx] = 1;
		set1(idx+1);
		select[idx] = 2;
		set1(idx+1);
	}
	public static void set2() {
		int select1 = 0, select2 = 0;
		for(int i=1;i<=n;i++) {
			visited[i] = 0;
			select1 = select[i] == 1 ? select1 + 1 : select1;
			select2 = select[i] == 2 ? select2 + 1 : select2;
		}
		boolean a1 = false, a2 = false;
		int[] area1 = new int[2], area2 = new int[2];
		for(int i=1;i<=n;i++) {
			if(a1 == true && a2 == true) {
				break;
			}
			if(a1 == false && visited[i] == 0 && select[i] == 1) {
				area1 = set3(1,i);
				a1 = true;
				continue;
			}
			if(a2 == false && visited[i] == 0 && select[i] == 2) {
				area2 = set3(2,i);
				a2 = true;
				continue;
			}
		}
		if(area1[1] == 0 || area2[1] == 0 || 
			area1[1] != select1 || area2[1] != select2) {
			return;
		}else {
			int diff = area1[0] < area2[0] ? area2[0] - area1[0] : area1[0] - area2[0];
			ans = diff < ans ? diff : ans;
			return;
		}
	}
	public static int[] set3(int num, int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] peopleNSize = new int[2];
		peopleNSize[0] = people[start];
		peopleNSize[1]++;
		visited[start] = num;
		q.add(start);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=1;i<=n;i++) {
				if(map[cur][i] != 0 && visited[i] == 0 && select[i] == num) {
					peopleNSize[0] += people[i];
					peopleNSize[1]++;
					visited[i] = num;
					q.add(i);
				}
			}
		}
		return peopleNSize;
	}
}
