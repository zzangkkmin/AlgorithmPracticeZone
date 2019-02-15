package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2263 {
	public static int[] inorder;
	public static int[] postorder;
	public static int[] position;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		inorder = new int[n];
		postorder = new int[n];
		position = new int[n+1];
		String[] line = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			inorder[i] = Integer.parseInt(line[i]);
			position[inorder[i]] = i;
		}
		line = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			postorder[i] = Integer.parseInt(line[i]);
		}
		preorder(0,n-1,0,n-1);
	}
	public static void preorder(int inS, int inE, int postS, int postE) {
		if(inS>inE || postS>postE) {
			return;
		}
		int root = postorder[postE];
		System.out.print(root+" ");
		int left = position[root] - inS;
		preorder(inS, position[root]-1, postS, postS + left - 1);
		preorder(position[root]+1, inE, postS + left, postE - 1);
	}
}
/*
6
1 4 2 3 6 5
1 2 4 6 5 3
*/