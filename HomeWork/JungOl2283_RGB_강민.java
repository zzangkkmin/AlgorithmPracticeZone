package com.ssafy.git.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JungOl2283_RGB_강민 {
	public static int n, ans;
	public static String[] line;
	public static int rgb[] = new int[3];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     n = Integer.parseInt(br.readLine().trim());
	     for(int i=0;i<n;i++) {
	    	 line = br.readLine().trim().split(" ");
	    	 int r = Integer.parseInt(line[0]);
	    	 int g = Integer.parseInt(line[1]);
	    	 int b = Integer.parseInt(line[2]);
	    	 int cr = rgb[0];
	    	 int cg = rgb[1];
	    	 int cb	= rgb[2];
	    	 rgb[0] = Math.min(cg, cb) + r;
	    	 rgb[1] = Math.min(cr, cb) + g;
	    	 rgb[2] = Math.min(cr, cg) + b;
	     }
	     int ans = Math.min(Math.min(rgb[0], rgb[1]), rgb[2]);
	     System.out.println(ans);
	}

}
