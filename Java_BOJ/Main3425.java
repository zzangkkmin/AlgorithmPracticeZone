package com.ssafy.git.Java_BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3425 {
	public static String input;
	public static ArrayList<String> calStack;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
			calStack = new ArrayList<>();
			while(true){
				input = sc.next();
				if(input.equals("QUIT")){
					return;
				}else if(input.equals("END")){
					break;
				}else if(input.equals("NUM")){
					String num = sc.next();
					calStack.add(input+" "+num);
				}else {
					calStack.add(input);
				}
			}
			int n = sc.nextInt();
			for(int i=0;i<n;i++){
				long init = sc.nextLong();
				System.out.println(goStack(init));
			}
			System.out.println();
		}
	}
	public static String goStack(long initNum){
		ArrayList<Long> stack = new ArrayList<>();
		stack.add(initNum);
		int nextTopIdx = 1;
		int curTopIdx = 0; 
		int curSecondIdx = -1;
		for(String comm : calStack){
			if(comm.contains("NUM")){
				long num = Long.parseLong(comm.substring(4));
				stack.add(num);
				curSecondIdx = curTopIdx;
				curTopIdx = nextTopIdx;
				nextTopIdx++;
			}else if(comm.equals("POP")){
				if(stack.size()==0){
					return "ERROR";
				}
				stack.remove(curTopIdx);
				nextTopIdx = curTopIdx;
				curTopIdx = curSecondIdx;
				curSecondIdx--;
			}else if(comm.equals("INV")){
				stack.set(curTopIdx, -stack.get(curTopIdx));				
			}else if(comm.equals("DUP")){
				long num = stack.get(curTopIdx);
				stack.add(num);
				curSecondIdx = curTopIdx;
				curTopIdx = nextTopIdx;
				nextTopIdx++;
			}else if(comm.equals("SWP")){
				if(stack.size()<2){
					return "ERROR";
				}
				long first = stack.get(curTopIdx);
				long second = stack.get(curSecondIdx);
				stack.set(curSecondIdx, first);
				stack.set(curTopIdx, second);
			}else if(comm.equals("ADD")){
				if(stack.size()<2){
					return "ERROR";
				}
				long first = stack.get(curTopIdx);
				long second = stack.get(curSecondIdx);
				if(first+second > 1000000000){
					return "ERROR";
				}
				stack.remove(curTopIdx);
				nextTopIdx = curTopIdx;
				curTopIdx = curSecondIdx;
				curSecondIdx--;
				stack.set(curTopIdx, first+second);
			}else if(comm.equals("SUB")){
				if(stack.size()<2){
					return "ERROR";
				}
				long first = stack.get(curTopIdx);
				long second = stack.get(curSecondIdx);
				if(Math.abs(second-first) > 1000000000){
					return "ERROR";
				}
				stack.remove(curTopIdx);
				nextTopIdx = curTopIdx;
				curTopIdx = curSecondIdx;
				curSecondIdx--;
				stack.set(curTopIdx, second-first);
			}else if(comm.equals("MUL")){
				if(stack.size()<2){
					return "ERROR";
				}
				long first = stack.get(curTopIdx);
				long second = stack.get(curSecondIdx);
				if(Math.abs(second*first) > 1000000000){
					return "ERROR";
				}
				stack.remove(curTopIdx);
				nextTopIdx = curTopIdx;
				curTopIdx = curSecondIdx;
				curSecondIdx--;
				stack.set(curTopIdx, first*second);
			}else if(comm.equals("DIV")){
				if(stack.size()<2){
					return "ERROR";
				}
				long first = stack.get(curTopIdx);
				long second = stack.get(curSecondIdx);
				if(first==0 || Math.abs(second/first) > 1000000000){
					return "ERROR";
				}
				stack.remove(curTopIdx);
				nextTopIdx = curTopIdx;
				curTopIdx = curSecondIdx;
				curSecondIdx--;
				stack.set(curTopIdx, second/first);
			}else if(comm.equals("MOD")){
				if(stack.size()<2){
					return "ERROR";
				}
				long first = stack.get(curTopIdx);
				long second = stack.get(curSecondIdx);
				if(first==0 || Math.abs(second%first) > 1000000000){
					return "ERROR";
				}
				stack.remove(curTopIdx);
				nextTopIdx = curTopIdx;
				curTopIdx = curSecondIdx;
				curSecondIdx--;
				stack.set(curTopIdx, second%first);
			}
		}
		if(stack.size()!=1){
			return "ERROR";
		}else{
			return Long.toString(stack.get(0));
		}
	}
}
