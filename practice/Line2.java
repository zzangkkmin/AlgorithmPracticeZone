package com.ssafy.git.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Line2 {
	public static String input;
	public static ArrayList<String> chemical = new ArrayList<>();
	public static ArrayList<Integer> number = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().trim();
		boolean che = true; int cheIdx = 0;
		boolean num = false; int numIdx = 0;
		String temp = "";
		for(int i = 0; i<input.length();i++){
			if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
				if(temp.equals("")){
					temp += input.charAt(i);
				}
				else{
					chemical.add(temp);
					cheIdx++;
					temp = "";
					temp += input.charAt(i);
				}
			}
			else if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
				temp += input.charAt(i);
				chemical.add(temp);
				cheIdx++;
				temp = "";
			}
			else if(input.charAt(i) >= '1' && input.charAt(i) <= '9'){
				if(che == true){
					che = false;
					num = true;
					if(temp.equals("")==false){
						chemical.add(temp);
						cheIdx++;
					}
					temp = "";
				}
				if(temp.equals("")){
					temp += input.charAt(i);
				}
				else{
					number.add(Integer.parseInt(temp));
					numIdx++;
					temp = "";
					temp += input.charAt(i);
				}
			}
			else if(input.charAt(i) == '0'){
				temp += input.charAt(i);
				number.add(Integer.parseInt(temp));
				numIdx++;
				temp = "";
			}
			if(i==input.length()-1 && temp.equals("") == false){
				number.add(Integer.parseInt(temp));
				numIdx++;
			}
		}
		//System.out.println("pause");
		if(chemical.size() != number.size()){
			System.out.println("error");
		}
		else{
			for(int i=0;i<chemical.size();i++){
				System.out.print(chemical.get(i));
				if(number.get(i)==1)
					continue;
				System.out.print(number.get(i));
			}
		}
	}
	
}
