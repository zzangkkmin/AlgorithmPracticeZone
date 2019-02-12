package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2957 {
	public static int cnt = 0;
	static class Node{
		int num;
		Node less;
		Node more;
		Node(int num){
			this.num = num;
		}
	}
	public static void insert(Node in, Node root) {
		cnt++;
		if(in.num < root.num) {
			if(root.less==null) {
				root.less = in;
			}
			else {
				insert(in,root.less);
			}
		}
		else if(in.num > root.num){
			if(root.more==null) {
				root.more = in;
			}
			else {
				insert(in,root.more);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int root = Integer.parseInt(br.readLine().trim());
		Node R = new Node(root);
		System.out.println(0);
		for(int i=0;i<n-1;i++) {
			int num = Integer.parseInt(br.readLine().trim());
			Node k = new Node(num);
			insert(k,R);
			System.out.println(cnt);
		}
	}

}
