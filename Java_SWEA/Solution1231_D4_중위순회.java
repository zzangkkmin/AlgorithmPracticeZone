package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution1231_D4_중위순회 {
	static class TreeNode{
		int num;
		TreeNode left;
		TreeNode right;
		public TreeNode() {}
		public TreeNode(int num) {
			this.num = num;
		}
	}
	public static TreeNode root;
	public static void insertKey(TreeNode rt, int n, int l, int r) {
		if(rt != null) {
			boolean inserted = false;
			if(rt.num == n && rt.left == null && l != 0) {
				rt.left = new TreeNode(l);
				inserted = true;
			}
			if(rt.num == n && rt.right == null && r != 0) {
				rt.right = new TreeNode(r);
				inserted = true;
			}
			if(inserted) {
				return;
			}
			insertKey(rt.left,n,l,r);
			insertKey(rt.right,n,l,r);
		}
	}
	public static void insert(int n, int l, int r) {
		if(root==null) {
			root = new TreeNode(n);
		}
		insertKey(root, n, l, r);
	}
	public static void inorder(TreeNode rt) {
		if(rt!=null) {
			inorder(rt.left);
			System.out.print(str[rt.num]);
			inorder(rt.right);
		}
	}
	public static String[] str;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test=1;test<=10;test++) {
			int n = Integer.parseInt(br.readLine().trim());
			str = new String[n+1];
			for(int i = 0; i < n; i++) {
				String[] line = br.readLine().split(" ");
				int num = 0; String data = "";
				int leftN = 0; int rightN = 0;
				for(int j=0;j<line.length;j++) {
					if(j==0) {
						num = Integer.parseInt(line[j]);
					}
					else if(j==1) {
						data = line[j];
					}
					else if(j==2) {
						leftN = Integer.parseInt(line[j]);
					}
					else if(j==3) {
						rightN = Integer.parseInt(line[j]);
					}
				}
				str[num] = data;
				insert(num, leftN, rightN);
			}
			System.out.print("#"+test + " ");
			inorder(root);
			System.out.println();
			root = null;
		}
		
	}

}
