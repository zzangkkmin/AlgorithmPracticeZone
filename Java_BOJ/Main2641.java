package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2641 {
	public static ArrayList<String[]> ans = new ArrayList<>();
	public static String[] line;
	public static String origin = "";
	public static String revOrigin ="";
	public static int n,m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		line = br.readLine().trim().split(" ");
		for(int i=0;i<n;i++) {
			origin += line[i];
			if(line[i].equals("1")) {
				revOrigin = "3" + revOrigin;
			}
			else if(line[i].equals("2")) {
				revOrigin = "4" + revOrigin;
			}
			else if(line[i].equals("3")) {
				revOrigin = "1" + revOrigin;
			}
			else if(line[i].equals("4")) {
				revOrigin = "2" + revOrigin;
			}
		}
		m = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<m;i++) {
			line = br.readLine().trim().split(" ");
			check(line);
		}
		System.out.println(ans.size());
		for(int i=0;i<ans.size();i++) {
			for(int j=0;j<n;j++) {
				System.out.print(ans.get(i)[j] + " ");
			}
			System.out.println();
		}
	}
	public static void check(String[] str) {
		String cur = "";
		for(int i=0;i<n;i++) {
			cur += str[i];
		}
		cur = cur + cur;
		if(cur.contains(origin) || cur.contains(revOrigin)) {
			ans.add(str);
		}
	}
}
