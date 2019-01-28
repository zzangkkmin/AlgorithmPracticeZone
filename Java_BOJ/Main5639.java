package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main5639 {
	static class node{
		int data;
		node left;
		node right;
		node(){
			data = 0;
			left = null;
			right = null;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		node Rtree = new node();
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String t;
		while(sc.hasNextLine()) {
			String ttt = sc.nextLine();
			int n = Integer.parseInt(ttt);
			insertTree(Rtree,n);
		}
		postOrder(Rtree);
	}
	public static void insertTree(node tt, int num) {
		if(tt.data==0) {
			tt.data = num;
		}
		else if(tt.data>num) {
			if(tt.left == null) {
				node newTree = new node();
				tt.left = newTree;
			}
			insertTree(tt.left,num);
		}
		else if(tt.data<num) {
			if(tt.right == null) {
				node newTree = new node();
				tt.right = newTree;
			}
			insertTree(tt.right,num);
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
			System.out.println(n.data);
		}
	}
}
