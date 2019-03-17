package com.ssafy.git.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Line3 {
	public static int t1, t2, attrNum;
	public static String[] linez;
	public static HashMap<Integer, String>[] attribute;
	public static HashSet<Integer> ID = new HashSet<>();
	public static String[] attr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t1 = Integer.parseInt(br.readLine().trim());
		attribute = new HashMap[4];
		attr = new String[4];
		for(int i=0;i<4;i++){
			attribute[i] = new HashMap<>();
		}
		for(int i=0;i<t1;i++){
			linez = br.readLine().trim().split(" ");
			if(i==0){
				int an = linez.length - 1;
				attrNum = an;
				for(int j = 0; j < an; j++){
					attr[j] = linez[j+1];
				}
			}
			else{
				for(int j = 1; j < linez.length; j++){
					attribute[j-1].put(Integer.parseInt(linez[0]), linez[j]);
				}
				ID.add(Integer.parseInt(linez[0]));
			}
		}
		t2 = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<t2;i++){
			linez = br.readLine().trim().split(" ");
			int an = linez.length - 1;
			if(i==0){
				for(int j = 0; j < an; j++){
					attr[attrNum + j] = linez[j+1];
				}
				attrNum += an;
			}
			else{
				an = attrNum - an; 
				for(int j = 1; j < linez.length; j++){
					attribute[an + j-1].put(Integer.parseInt(linez[0]), linez[j]);
				}
			}
		}
		//System.out.println("pause");
		//left outer join
		System.out.print("id ");
		for(int j=0;j<attrNum;j++){
			System.out.print(attr[j]);
			if(j==attrNum-1){
				break;
			}
			System.out.print(" ");
		}
		System.out.println();
		for(int id : ID){
			System.out.print(id + " ");
			for(int j=0;j<attrNum;j++){
				if(attribute[j].containsKey(id)==false){
					System.out.print("NULL");
				}
				else{
					System.out.print(attribute[j].get(id));
				}
				if(j==attrNum-1){
					break;
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
