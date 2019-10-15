package com.ssafy.git.TestExam;

public class Naver02 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String[] str = {"######",">#*###","####*#","#<#>>#",">#*#*<","######" };
		int ans = solution(str);
		System.out.println(ans);
	}

	static int solution(String[] str) {
		// TODO Auto-generated method stub
		int n = str.length;
		int ans = 0;
		char[][] map = new char[n][n];
		for(int i=0;i<n;i++) {
			char[] line = str[i].toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j] = line[j];
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		for(int j=0;j<n;j++) {
			int x = j; int i = 0; int star = 0;
			while(true) {
				if(star == 2) {
					break;
				}
				if(i==n) {
					ans++;
					break;
				}
				
				if(map[i][x] == '#') {
					i++;
				} else if(map[i][x] == '>') {
					x++;
				} else if(map[i][x] == '<') {
					x--;
				} else if(map[i][x] == '*') {
					star++;
					i++;
				}
			}
		}
		return ans;
	}
	
}
