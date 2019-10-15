package com.ssafy.git.TestExam;

import java.io.*;
import java.util.*;

class NHNtest {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static String[][] map, update;
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		map = new String[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				map[i][j] = sc.next();
			}
		}
		update = Set(n,k);
		System.out.println();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(update[i][j]);
				if(j==n-1){
					System.out.println();
				} else{
					System.out.print(" ");
				}
			}
		}
				
	}
	public static String[][] Set(int n, int k){
		int len = n; int pivot = 0;
		String[][] ret = new String[n][n];
		while(true){
			if(len==1){
				ret[pivot][pivot] = map[pivot][pivot];
				break;
			} 
			if(len==0){
	 			break;
	 		}
			int rotateLen = len*len - (len-2)*(len-2);
			content[] rotateArr = new content[rotateLen];
			int pivotX = pivot; int pivotY = pivot; int lenIdx = 0; 
			int d = 0; int move = 0;
			rotateArr[0] = new content(pivot, pivot, map[pivot][pivot]);
			lenIdx++;
			while(lenIdx < rotateLen){
				if(move == len - 1){
					d++;
					move = 0;
				}
				int nx = pivotX + dx[d];
				int ny = pivotY + dy[d];
				rotateArr[lenIdx] = new content(nx,ny,map[nx][ny]);
				pivotX = nx;
				pivotY = ny;
				move++; lenIdx++;
			}
			
			int pointIdx = 0;
			if(k>=0){//clock wise
				pointIdx = k % rotateLen;
			} else{//counter clock
				int tk = (-k) % rotateLen;
				pointIdx = rotateLen - tk;
			}
			for(int i=0;i<rotateLen;i++){
				int cx = rotateArr[(i+pointIdx)%rotateLen].x;
				int cy = rotateArr[(i+pointIdx)%rotateLen].y;
				String cname = rotateArr[i].name;
				ret[cx][cy] = cname;
			}
			len = len - 2;
			pivot++; k = -k;
		}
		return ret;
	}
	 
	static class content{
		int x; int y;
		String name;
		public content(int x, int y, String name){
			this.x = x;
			this.y = y;
			this.name = name;
		}
	}
}