package com.ssafy.git.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Line5 {
	public static int C,B;
	public static int[] map = new int[200001];
	public static int[] dist = new int[200001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        B = sc.nextInt();
        brown();
        cony();
	}
	public static void brown(){
		Arrays.fill(map, -1);
		Queue<Integer> q = new LinkedList<>();
		q.add(B);
		map[B] = 0;
		while(!q.isEmpty()){
			int cur = q.poll();
			if(cur - 1 >= 0 && map[cur - 1] == -1){
				q.add(cur - 1);
				map[cur - 1] = map[cur] + 1;
			}
			if(cur + 1 <= 200000 && map[cur + 1] == -1){
				q.add(cur + 1);
				map[cur + 1] = map[cur] + 1;
			}
			if(cur*2 <= 200000 && map[cur*2] == -1){
				q.add(cur*2);
				map[cur*2] = map[cur] + 1;
			}
		}
	}
	public static void cony(){
		Arrays.fill(dist, -1);
		int cur = C;
		int addv = 1;
		dist[cur] = 0;
		while(true){
			if(dist[cur] == map[cur]){
				System.out.println(map[cur]);
				return;
			}
			if(cur + addv > 200000){
				System.out.println(-1);
				return;
			}
			dist[cur + addv] = dist[cur] + 1; 
			cur = cur + addv;
			addv++;
		}
	}
}
