package com.ssafy.swe;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution6109_D4_2048 {
	static String dir;
	static int N;
	static int[][] map;
	static void moving() {
		if(dir.equals("up")) {
			for(int j=0;j<N;j++) {
				int[] temp = new int[N+1];
				int idx = 0;
				for(int i=0;i<N;i++) {
					if(map[i][j] != 0) {
						temp[idx] = map[i][j];
						map[i][j] = 0;
						idx++;
					}
				}
				temp[idx] = -1;//end_point
				int mapIdx = 0;
				for(int ti=0;ti<idx;) {
					if(temp[ti] == -1)
						break;
					if(temp[ti] == temp[ti+1]) {
						map[mapIdx][j] = temp[ti] + temp[ti+1];
						mapIdx++;
						ti = ti + 2;
					}
					else {
						map[mapIdx][j] = temp[ti];
						mapIdx++;
						ti++;
					}
				}
			}
		}
		else if(dir.equals("down")) {
			for(int j=0;j<N;j++) {
				int[] temp = new int[N+1];
				int idx = 0;
				for(int i=N-1;i>=0;i--) {
					if(map[i][j] != 0) {
						temp[idx] = map[i][j];
						map[i][j] = 0;
						idx++;
					}
				}
				temp[idx] = -1;//end_point
				int mapIdx = N-1;
				for(int ti=0;ti<idx;) {
					if(temp[ti] == -1)
						break;
					if(temp[ti] == temp[ti+1]) {
						map[mapIdx][j] = temp[ti] + temp[ti+1];
						mapIdx--;
						ti = ti + 2;
					}
					else {
						map[mapIdx][j] = temp[ti];
						mapIdx--;
						ti++;
					}
				}
			}
		}
		else if(dir.equals("left")) {
			for(int i=0;i<N;i++) {
				int[] temp = new int[N+1];
				int idx = 0;
				for(int j=0;j<N;j++) {
					if(map[i][j] != 0) {
						temp[idx] = map[i][j];
						map[i][j] = 0;
						idx++;
					}
				}
				temp[idx] = -1;//end_point
				int mapIdx = 0;
				for(int ti=0;ti<idx;) {
					if(temp[ti] == -1)
						break;
					if(temp[ti] == temp[ti+1]) {
						map[i][mapIdx] = temp[ti] + temp[ti+1];
						mapIdx++;
						ti = ti + 2;
					}
					else {
						map[i][mapIdx] = temp[ti];
						mapIdx++;
						ti++;
					}
				}
			}
		}
		else if(dir.equals("right")) {
			for(int i=0;i<N;i++) {
				int[] temp = new int[N+1];
				int idx = 0;
				for(int j=N-1;j>=0;j--) {
					if(map[i][j] != 0) {
						temp[idx] = map[i][j];
						map[i][j] = 0;
						idx++;
					}
				}
				temp[idx] = -1;//end_point
				int mapIdx = N-1;
				for(int ti=0;ti<idx;) {
					if(temp[ti] == -1)
						break;
					if(temp[ti] == temp[ti+1]) {
						map[i][mapIdx] = temp[ti] + temp[ti+1];
						mapIdx--;
						ti = ti + 2;
					}
					else {
						map[i][mapIdx] = temp[ti];
						mapIdx--;
						ti++;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			dir = sc.next();
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			moving();
			System.out.println("#" + test_case);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
