package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main16722 {
	public static pic[] game;
	public static String[] line;
	public static Map<Integer, Boolean> map;
	public static int n, score, hap_n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		game = new pic[9];
		for(int i=0;i<9;i++) {
			line = br.readLine().split(" ");
			game[i] = new pic(modify(line[0],1), modify(line[1],2), modify(line[2],3));
		}
		map = new HashMap<>();
		for(int i=0;i<7;i++) {
			for(int j=i+1;j<8;j++) {
				for(int k=j+1;k<9;k++) {
					hap(i,j,k);
				}
			}
		}
		hap_n = map.size(); int cur_hap = 0;
		n = Integer.parseInt(br.readLine().trim());
		boolean Gyeoul = false;
		for(int i=0;i<n;i++) {
			line = br.readLine().split(" ");
			if(line[0].equals("H")) {
				int[] arr = new int[3];
				arr[0] = Integer.parseInt(line[1]);
				arr[1] = Integer.parseInt(line[2]);
				arr[2] = Integer.parseInt(line[3]);
				Arrays.sort(arr);
				int key = arr[0]*100 + arr[1]*10 + arr[2];
				if(map.containsKey(key) && map.get(key) == false) {
					score += 1;
					map.replace(key, true);
					cur_hap++;
				}
				else {
					score -= 1;
				}
			}
			else {
				if(cur_hap == hap_n && Gyeoul == false) {
					score += 3;
					Gyeoul = true;
				}
				else {
					score -= 1;
				}
			}
		}
		System.out.println(score);
	}
	static class pic{
		int shape;//1,2,3 = circle, triangle, square
		int color;//1,2,3 = yellow, red, blue
		int back; //1,2,3 = gray, white, black
		public pic(int shape, int color, int back) {
			super();
			this.shape = shape;
			this.color = color;
			this.back = back;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("pic [shape=").append(shape).append(", color=").append(color).append(", back=").append(back)
					.append("]");
			return builder.toString();
		}
		
	}
	public static int modify(String str, int mode) {
		if(mode==1) {//shape
			if(str.equals("CIRCLE")) {
				return 1;
			}
			else if(str.equals("TRIANGLE")) {
				return 2;
			}
			else if(str.equals("SQUARE")) {
				return 3;
			}
		}
		else if(mode == 2){//color
			if(str.equals("YELLOW")) {
				return 1;
			}
			else if(str.equals("RED")) {
				return 2;
			}
			else if(str.equals("BLUE")) {
				return 3;
			}
		}
		else {//back
			if(str.equals("GRAY")) {
				return 1;
			}
			else if(str.equals("WHITE")) {
				return 2;
			}
			else if(str.equals("BLACK")) {
				return 3;
			}
		}
		return 0;
	}
	public static void hap(int i, int j, int k) {
		if((game[i].shape == game[j].shape && game[j].shape == game[k].shape) || 
			(game[i].shape != game[j].shape && game[j].shape != game[k].shape && 
			 game[k].shape != game[i].shape)) {
			if((game[i].color == game[j].color && game[j].color == game[k].color)||
				(game[i].color != game[j].color && game[j].color != game[k].color &&
				game[k].color != game[i].color)) {
				if((game[i].back == game[j].back && game[j].back == game[k].back)||
					(game[i].back != game[j].back && game[j].back != game[k].back && 
					game[k].back != game[i].back)) {
					map.put((i+1)*100 + (j+1)*10 + (k+1), false);
				}
			}
		}
	}
}
