package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1266_D6_소수완제품확률 {
	/** 
	 * Hint: nCr * p^r * (1-p)^(n-r)
	 * */
	public static int[] combifact;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
	}

}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    static int[] facto;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        factoPrime();
        for(int tc = 1; tc <= t; tc++) {
            String[] str = br.readLine().split(" ");
            double perA = Double.parseDouble(str[0]);
            double perB = Double.parseDouble(str[1]);
            double sumA = sumPercent(perA);
            double sumB = sumPercent(perB);
            double result = 0;
            if(sumA==0 && sumB==0) {
                result = 0;
            }else if(sumA==0){
                result = 1.0 - sumB;
            }else if(sumB==0) {
                result = 1.0 - sumA;
            }
            else {
                result = 1.0 - (sumA*sumB);
            }
            System.out.printf("#%d %.6f\n",tc,result);
        }
 
    }
 
    public static double sumPercent(double p) {
        int[] prime = {0,1,4,6,8,9,10,12,14,15,16,18};
        double sum = 0.0;
        if(p==100) p = 0;
        double tmp1 = p/100.0;
        double tmp2 = (100-p)/100.0;
        for (int i = 0; i < prime.length; i++) {
            double res1 = 1.0;
            double res2 = 1.0;
            for (int j = 0; j < prime[i]; j++) {
                res1 = res1 * tmp1;
            }
            for (int j = 0; j < 18-prime[i]; j++) {
                res2 = res2 * tmp2;
            }
            sum += facto[prime[i]]*res1*res2;
        }
        return sum;
    }
     
    public static void factoPrime() {
        facto = new int[19];
        facto[0] = 1;
        int top = 18;
        int bot = 1;
        int tmp = top / bot;
        for (int i = 1; i < facto.length; i++) {
            facto[i] = tmp;
            top--; bot++;
            tmp *= top;
            tmp /= bot;
        }
    }
 
}
 */
*/