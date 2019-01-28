package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main1991 {
	static class node{
		char data;
		node right;
		node left;
		node(){
			data = 0;
			right = null;
			left = null;
		}
	}
	public static node[] abc = new node[26]; 
	public static void main(String[] args) throws Exception, IOException {
		for(int i = 0 ; i <26; i++) {
			abc[i] = new node();
		}
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<n;i++) {
			String[] line = br.readLine().split(" ");
			char[] ROLR = new char[3];
			ROLR[0] = line[0].charAt(0);
			ROLR[1] = line[1].charAt(0);
			ROLR[2] = line[2].charAt(0);

			abc[ROLR[0]-'A'].data = ROLR[0];
			abc[ROLR[0]-'A'].left = (ROLR[1] != '.' ? abc[ROLR[1] - 'A'] : null);
			abc[ROLR[0]-'A'].right = (ROLR[2] != '.' ? abc[ROLR[2] - 'A'] : null);
		}
		preOrder(abc[0]);
		System.out.println();
		inOrder(abc[0]);
		System.out.println();
		postOrder(abc[0]);
		System.out.println();
	}
	public static void preOrder(node n) {
		if(n.data != 0) {
			System.out.print(n.data);
		}
		if(n.left != null) {
			preOrder(n.left);
		}
		if(n.right != null) {
			preOrder(n.right);
		}
	}
	public static void inOrder(node n) {
		if(n.left != null) {
			inOrder(n.left);
		}
		if(n.data != 0) {
			System.out.print(n.data);
		}
		if(n.right != null) {
			inOrder(n.right);
		}
	}
	public static void postOrder(node n) {
		if(n.left != null) {
			postOrder(n.left);
		}
		if(n.right != null) {
			postOrder(n.right);
		}
		if(n.data != 0) {
			System.out.print(n.data);
		}
	}
}
