package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main16925 {
	public static int n;
	public static String[] origin;
	public static String[][] arr;
	public static int[] inputIdx;
	public static int[] psmode;
	public static int[] position;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		origin = new String[2*n-2];
		psmode = new int[2*n-2];
		position = new int[2*n+1];
		arr = new String[n][2];
		inputIdx = new int[n];
		for(int i=0;i<2*n-2;i++){
			origin[i] = br.readLine().trim();
			arr[origin[i].length()][inputIdx[origin[i].length()]] = origin[i];
			position[origin[i].length() * 2 + inputIdx[origin[i].length()]] = i;
			inputIdx[origin[i].length()]++;
		}
		if(n==2){
			System.out.println(origin[0] + origin[1]);
			System.out.println("PS");
			return;
		}
		if(arr[1][0].charAt(0) == arr[2][0].charAt(0)){
			psmode[position[1*2+0]] = 1;
			psmode[position[2*2+0]] = 1;
			psmode[position[1*2+1]] = -1;
			psmode[position[2*2+1]] = -1;
		}
		else if(arr[1][0].charAt(0) == arr[2][1].charAt(0)){
			psmode[position[1*2+0]] = 1;
			psmode[position[2*2+1]] = 1;
			psmode[position[1*2+1]] = -1;
			psmode[position[2*2+0]] = -1;
		}
		else if(arr[1][1].charAt(0) == arr[2][0].charAt(0)){
			psmode[position[1*2+1]] = 1;
			psmode[position[2*2+0]] = 1;
			psmode[position[1*2+0]] = -1;
			psmode[position[2*2+1]] = -1;
		}
		else if(arr[1][1].charAt(0) == arr[2][1].charAt(0)){
			psmode[position[1*2+1]] = 1;
			psmode[position[2*2+1]] = 1;
			psmode[position[1*2+0]] = -1;
			psmode[position[2*2+0]] = -1;
		}
		if(n>3){
			for(int i=3;i<n;i++){
				int curPSmode = psmode[position[(i-1)*2+0]];
				if(curPSmode == 1){
					if(arr[i-1][0].equals(arr[i][0].substring(0, i-1))){
						psmode[position[i*2+0]] = 1;
						psmode[position[i*2+1]] = -1;
					}
					else{
						psmode[position[i*2+0]] = -1;
						psmode[position[i*2+1]] = 1;
					}
				}
				else{
					if(arr[i-1][1].equals(arr[i][0].substring(0, i-1))){
						psmode[position[i*2+0]] = 1;
						psmode[position[i*2+1]] = -1;
					}
					else{
						psmode[position[i*2+0]] = -1;
						psmode[position[i*2+1]] = 1;
					}
				}	
			}
		}
		String pre = psmode[position[1*2+0]] == 1 ? arr[1][0] : arr[1][1];
		String post = psmode[position[(n-1)*2+1]] == -1 ? arr[n-1][1] : arr[n-1][0];
		System.out.println(pre+post);
		for(int i=0;i<2*n-2;i++){
			if(psmode[i] == 1){
				System.out.print("P");
			}
			else{
				System.out.print("S");
			}
		}
		System.out.println();
	}

}

