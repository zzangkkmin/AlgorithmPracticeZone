package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main3025 {
	public static int r,c,n;
	public static String[] linez;
	public static String line;
	public static char[][] map;
	public static ArrayList<Integer>[] colWall, colStone;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		linez = br.readLine().trim().split(" ");
		r = Integer.parseInt(linez[0]);
		c = Integer.parseInt(linez[1]);
		map = new char[r+1][c+1];
		colWall = new ArrayList[c+1];
		colStone = new ArrayList[c+1];
		for(int i=1;i<=r;i++) {
			line = br.readLine().trim();
			for(int j=1;j<=c;j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'X') {
					colWall[j].add(i);
				}
			}
		}
		for(int j=1;j<=c;j++) {
			colWall[j].add(r);
		}
		line = br.readLine().trim();
		n = Integer.parseInt(line);
		for(int i=0;i<n;i++) {
			int dropPoint = Integer.parseInt(br.readLine().trim());
			//drop(dropPoint);
		}
		for(int i=1;i<=r;i++) {
			for(int j=1;j<=c;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	public static void drop(int dpoint) {
		if(colStone[dpoint].size() == 0) {
			
		}
		else {
			
		}
	}
	
}
