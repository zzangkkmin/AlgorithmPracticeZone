package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1808_D4_지희고장난계산기 {
	public static String[] line;
	public static int[] calNum = new int[10];
	public static int[] num;
	public static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tc;t++) {
			line = br.readLine().trim().split(" ");
			for(int i=0;i<10;i++) {
				calNum[i] = Integer.parseInt(line[i]);
			}
			n = Integer.parseInt(br.readLine().trim());
			num = new int[1000001];
			for(int i=0;i<10;i++) {
				num[i] = calNum[i];
			}
//			pushValidNum();
//			find();
//			ffind(n);
//			if(num[n] == 0) {
//				//System.out.println("#"+t+" -1");
//				bw.write("#"+t+" -1\n");
//			}
//			else {
//				//System.out.println("#"+t+" " + (num[n] + 1));
//				bw.write("#"+t+" " + (num[n] + 1)+"\n");
//			}
			bw.write("#"+t+" " + (ffind(n) + 1)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();		
	}
	public static void pushValidNum() {
		for(int i=10;i<=n;i++) {
			String numstr = new Integer(i).toString();
			boolean valid = true;
			for(int j=0;j<numstr.length();j++) {
				int nIdx = numstr.charAt(j) - '0';
				if(num[nIdx]==0) {
					valid = false;
					break;
				}
			}
			if(valid == true) {
				num[i] = numstr.length(); 
			}
		}
	}
	public static void find() {
		for(int i=2;i<n;i++) {
			if(num[i] == 0)
				continue;
			for(int j=i;j<n;j++) {
				if((long)i*(long)j>(long)n) {
					break;
				}
				if(num[j] == 0) {
					continue;
				}
				if(num[i*j] == 0) {
					num[i*j] = num[i] + num[j] + 1;
				}
				else if(num[i*j] > num[i] + num[j] + 1){
					num[i*j] = num[i] + num[j] + 1;
				}
			}
		}
	}
	public static int ffind(int numm) {
		int minn = Integer.MAX_VALUE;
		int cur = numm;
		int len = 0;
		while(true) {
			if(cur == 0 || num[cur % 10] == 0) {
				break;
			}
			len++;
			cur = cur / 10;
		}
		if(cur == 0) {
			minn = len;
		}
		else {
			cur = (int) Math.floor(Math.sqrt(numm));
			while(true) {
				if(cur == 1) {
					break;
				}
				if(numm % cur == 0) {
					int a = ffind(cur);
					int b = ffind(numm / cur);
					if(a != -2 && b != -2) {
						minn = minn > a + b + 1 ? a + b + 1 : minn;
					}
				}
				cur--;
			}
			if(minn==Integer.MAX_VALUE) {
				minn = -2;
			}
		}
		return minn;
	}
}
