package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main16918 {
	public static String[] line;
	public static int r,c,n;
	public static char[][] map;
	public static int[][] timer;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static Queue<Integer[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().split(" ");
		r = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);
		n = Integer.parseInt(line[2]);
		map = new char[r][c];
		timer = new int[r][c];
		//0 sec: bomb setup
		for(int i=0;i<r;i++){
			String rc = br.readLine().trim();
			map[i] = rc.toCharArray();
			for(int j=0;j<c;j++){
				if(map[i][j] == 'O'){
					timer[i][j] = 3;
				}
			}
		}
		//1 sec ~ : active tictok
		tiktok(1,1);
	}
	public static void tiktok(int sec, int mode){
		if(sec > n){
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}
		else{
			if(sec == 1){
				//1 sec: do nothing, bombClock--
				for(int i=0;i<r;i++){
					for(int j=0;j<c;j++){
						if(map[i][j] == 'O'){
							timer[i][j]--;
						}
					}
				}
				tiktok(sec + 1, 1);
			}
			else if(mode == 1){
				//empty setup
				for(int i=0;i<r;i++){
					for(int j=0;j<c;j++){
						if(map[i][j] == 'O'){
							timer[i][j]--;
						}
						else if(map[i][j] == '.'){
							map[i][j] = 'O';
							timer[i][j] = 3;
						}
					}
				}
				tiktok(sec + 1, 0);
			}
			else if(mode == 0){
				//bomb active
				for(int i=0;i<r;i++){
					for(int j=0;j<c;j++){
						if(timer[i][j] == 1){
							timer[i][j]--;
							map[i][j] = '.';
							for(int d=0;d<4;d++){
								int nx = i + dx[d];
								int ny = j + dy[d];
								if(nx>=0&& nx<r && ny>=0 && ny < c){
									map[nx][ny] = '.';
								}
							}
						}
						else{
							timer[i][j]--;
						}
					}
				}
				tiktok(sec + 1, 1);
			}
		}
	}
}
