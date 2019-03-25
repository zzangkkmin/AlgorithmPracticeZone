package com.ssafy.git.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JungOl1077_배낭채우기1_강민 {

	 public static String[] line;
	 public static int n,k;
	 public static int[][] arr;
	 public static int[] d;
	 public static void main(String[] args) throws NumberFormatException, IOException {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         line = br.readLine().split(" ");
         n = Integer.parseInt(line[0]);
         k = Integer.parseInt(line[1]);
         arr = new int[n+1][2];
         //d[i][j] = 1~i번째 물건 까지 고른 결과, 무게j일때 최대 가치
         d = new int[k+1];
         for(int i=0;i<n;i++) {
             line = br.readLine().split(" ");
             arr[i+1][0] = Integer.parseInt(line[0]);//무게 
             arr[i+1][1] = Integer.parseInt(line[1]);//가치
         }
          
         for(int i=1;i<=k;i++) {
             int temp = 0;
             boolean change = false;
             for(int j=1;j<=n;j++) {
                 if(i-arr[j][0]>=0) {
                    if(temp <  arr[j][1] + d[i-arr[j][0]]) {
                        temp = arr[j][1] + d[i-arr[j][0]];
                        change = true;
                    }
                }
             }
                if(change==false) {
                    d[i] = d[i-1];
                }
                else {
                    d[i] = temp;
                }
            }
            System.out.println(d[k]);
	    }
}
