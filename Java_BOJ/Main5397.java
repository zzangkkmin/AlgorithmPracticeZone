package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main5397 {
	static int tc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);		
		//tc = sc.nextInt();
		tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			//String str = sc.next();
			String str = br.readLine().trim();
			solve(str);
		}
	}
	public static void solve(String str) {
		char[] input = str.toCharArray();
		node cursor = null;
		node cursorPrev = null;
		node cursorNext = null;
		for(char c : input) {
			if(c=='<') {
				if(cursorPrev == null) continue;
				else {
					cursor = cursorPrev;
					cursorPrev = cursor.prev;
					cursorNext = cursor.next;
				}
			}
			else if(c=='>') {
				if(cursor == null) continue;
				else {
					cursorPrev = cursor;
					cursor = cursor.next;
					if(cursor != null) {
						cursorNext = cursor.next;
					}
				}
			}
			else if(c=='-') {
				if(cursorPrev != null) {
					node delNode = cursorPrev;
					node delPrev = delNode.prev;
					node delNext = delNode.next;
					if(delPrev != null && delNext != null) {
						delPrev.next = delNext;
						delNext.prev = delPrev;
						delNode.del();
						cursorPrev = delPrev;
					}
					else if(delPrev == null && delNext != null) {
						delNext.prev = null;
						delNode.del();
						cursorPrev = null;
					}
					else if(delPrev != null && delNext == null) {
						delPrev.next = delNext;
						delNode.del();
						cursorPrev = delPrev;
					}
					else if(delPrev == null && delNext == null) {
						cursor = null;
						cursorPrev = null;
					}
				}
			}
			else {
				if(cursor == null && cursorPrev == null) {
					node make = new node(c);
					cursorPrev = make;
					cursor = make.next;
					//cursorNext = cursor.next;
				}
				else if(cursor == null && cursorPrev != null) {
					node make = new node(c);
					make.prev = cursorPrev;
					cursorPrev.next = make;
					cursorPrev = make;
					cursor = make.next;
					//cursorNext = cursor.next;
				}
				else if(cursor != null) {
					node make = new node(c);
					make.prev = cursorPrev;
					if(make.prev != null)
						cursorPrev.next = make;
					make.next = cursor;
					cursor.prev = make;
					cursorPrev = cursor.prev;
					cursorNext = cursor.next;
				}
			}
		}
		
		while(cursorPrev!=null) {
			cursor = cursorPrev;
			cursorPrev = cursor.prev;
		}
		while(true) {
			System.out.print(cursor.context);
			cursor = cursor.next;
			if(cursor==null)
				break;
		}
		System.out.println();
	}
	static class node{
		node prev;
		char context;
		node next;
		
		public node() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public node(char context) {
			super();
			this.prev = null;
			this.context = context;
			this.next = null;
		}
		
		public void del() {
			this.prev = null;
			this.context = ' ';
			this.next = null;
		}

		@Override
		public String toString() {
			return "node [prev=" + prev.context + ", context=" + context + ", next=" + next.context + "]";
		}		
	}
}
