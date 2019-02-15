package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main2448 {
	public static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		map = new char[n][n*2-1];
		//3*2^k
		for(int i=0;i<n;i++) {
			Arrays.fill(map[i], ' ');
		}
		makeStar(0,(n*2-1)/2,n);
		for(int i=0;i<n;i++) {
			bw.write(new String(map[i])+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void makeStar(int x, int y, int size) {
		if(size==3) {
													map[x][y] = '*';
								map[x+1][y-1] = '*';				  map[x+1][y+1] = '*';
			map[x+2][y-2] = '*';map[x+2][y-1] = '*';map[x+2][y] = '*';map[x+2][y+1] = '*';map[x+2][y+2] = '*';
			return;
		}
		makeStar(x,y,size/2);
		makeStar(x+size/2,y-size/2,size/2);
		makeStar(x+size/2,y+size/2,size/2);
	}
}
