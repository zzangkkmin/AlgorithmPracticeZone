package com.ssafy.git.Java_BOJ;

import java.util.Scanner;

public class Main17135 {
	static int N,M,D, tIdx, ans;
	static enemy[] target;
	static boolean[] archerSelect;
	static int[] archerPos;
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N][M];
		target = new enemy[N*M];
		archerSelect = new boolean[M];
		archerPos = new int[3];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int j=0;j<M;j++) {
			for(int i=N-1;i>=0;i--) {
				int mapIJ = map[i][j];
				if(mapIJ == 1) {
					target[tIdx++] = new enemy(i,j,0);
				}
			}
		}
		select(-1,0);
		System.out.println(ans);
		sc.close();
	}
	public static void select(int idx, int cnt) {
		if(cnt==3) {
			//defense
			int apIdx = 0;
			for(int i=0;i<M;i++) {
				if(archerSelect[i] == true) {
					archerPos[apIdx++] = i;
				}
			}
			int shootKill = defense();
			ans = ans < shootKill ? shootKill : ans;
			return;
		}
		if(idx == M) {
			//none
			return;
		}
		for(int i=idx+1;i<M;i++) {
			if(archerSelect[i] == false) {
				archerSelect[i] = true;
				select(i,cnt+1);
				archerSelect[i] = false;
			}
		}
	}
	public static int defense() {
		enemy[] att = new enemy[tIdx];
		for(int i = 0; i<tIdx; i++) {
			att[i] = new enemy(target[i].x, target[i].y, target[i].death);
		}
		int kill = 0; int wall = 0;
		while(true) {
			int[] shoot = {-1,-1,-1};
			int shootIdx = 0;
			// 1. Archer select target
			for(int arch = 0; arch < 3; arch++) {
				//int x = N;
				int y = archerPos[arch];
				int min = D+1; int minIdx = -1;
				for(int i=0;i<tIdx; i++) {
					int distance = dist(att[i],y); 
					if(distance <= D && att[i].death == 0 && distance < min) {
						min = distance;
						minIdx = i;
					}
				}
				if(minIdx != -1) {
					shoot[shootIdx++] = minIdx;
				}
			}
			// 2. Archer shoot target
			for(int i = 0; i<shootIdx; i++) {
				if(att[shoot[i]].death == 0) {
					att[shoot[i]].death = 1;
					kill++;
				}
			}
			// 3. target move down
			for(int i=0;i<tIdx; i++) {
				if(att[i].death == 0) {
					att[i].x++;
					if(att[i].x == N) {
						wall++;
						att[i].death = 1;
					}
				}
			}
			// 4. confrim end
			if(kill + wall == tIdx) {
				break;
			}
		}
		return kill;
	}
	public static int dist(enemy E, int archerP) {
		return Math.abs(E.x - N) + Math.abs(E.y - archerP);
	}
	public static class enemy{
		int x; int y; int death;
		public enemy() {
			super();
			// TODO Auto-generated constructor stub
		}
		public enemy(int x, int y, int death) {
			super();
			this.x = x;
			this.y = y;
			this.death = death;
		}
		@Override
		public String toString() {
			return "enemy [x=" + x + ", y=" + y + ", death=" + death + "]";
		}
		
	}
}
