package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2912 {
	public static String[] line;
	public static int[] dwarf;
	public static int n, c, m; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);
		line = br.readLine().split(" ");
		dwarf = new int[n];
		for(int i=0;i<n;i++){
			dwarf[i] = Integer.parseInt(line[i]);
		}
		m = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<m;i++){
			int[] hat = new int[c];
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]) - 1;
			int b = Integer.parseInt(line[1]) - 1;
			boolean isOK = false;
			for(int j=a;j<=b;j++){
				hat[dwarf[j]-1]++;
				if(hat[dwarf[j]-1] > (b-a+1)/2){
					isOK = true;
					bw.write("yes "+dwarf[j]+"\n");
					break;
				}
			}
			if(!isOK){
				bw.write("no\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
