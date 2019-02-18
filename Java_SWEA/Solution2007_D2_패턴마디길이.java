package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2007_D2_패턴마디길이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			String str = br.readLine().trim();
			System.out.println("#"+t+" "+pattern(str));
		}
	}
	public static int pattern(String str) {
		int len = 0;
		String pat = "";
		for(int i=0;i<str.length();i++) {
			boolean patternOK = true;
			String temp = pat + str.charAt(i);
			for(int j=temp.length();j<str.length()-temp.length();j=j+temp.length()) {
				if(!temp.equals(str.substring(j, j+temp.length()))) {
					patternOK = false;
					break;
				}
			}
			if(patternOK) {
				len = temp.length();
				break;
			}
			else {
				pat = temp;
			}
		}
		return len;
	}
}
/*
10
KOREAKOREAKOREAKOREAKOREAKOREA
SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA
GALAXYGALAXYGALAXYGALAXYGALAXY
EXOEXOEXOEXOEXOEXOEXOEXOEXOEXO
B1A4B1A4B1A4B1A4B1A4B1A4B1A4B1
APINKAPINKAPINKAPINKAPINKAPINK
BLACKPINKBLACKPINKBLACKPINKBLA
TWICETWICETWICETWICETWICETWICE
REDVELVETREDVELVETREDVELVETRED
ABCABCABCABCABCABCABCABCABCABC
*/