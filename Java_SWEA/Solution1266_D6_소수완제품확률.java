package com.ssafy.git.Java_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1266_D6_소수완제품확률 {
	/** 
	 * Hint: nCr * p^r * (1-p)^(n-r)
	 * */
	public static int[] combifact;
	public static double[] a = new double[19];
	public static double[] b = new double[19];
	public static String[] line;
	public static double pa, pb, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		setCombiFact();
		for(int t=1;t<=tc;t++) {
			line = br.readLine().split(" ");
			pa = (double) Integer.parseInt(line[0]) / 100.0;
			for(int i=0;i<=18;i++) {
				a[i] = combifact[i] * power(pa,i) * power(1-pa,18-i);
			}
			pb = (double) Integer.parseInt(line[1]) / 100.0;
			for(int i=0;i<=18;i++) {
				b[i] = combifact[i] * power(pb,i) * power(1-pb,18-i);
			}
			ans = notPrimeSelectA() * notPrimeSelectB();
			System.out.printf("#%d %.6f\n",t,1-ans);
		}
	}
	public static double notPrimeSelectA() {
		double ret = 0;
		for(int i=0;i<=18;i++) {
			if(!(i==2||i==3||i==5||i==7||i==11||i==13||i==17)) {
				ret += a[i];
			}
		}
		return ret;
	}
	public static double notPrimeSelectB() {
		double ret = 0;
		for(int i=0;i<=18;i++) {
			if(!(i==2||i==3||i==5||i==7||i==11||i==13||i==17)) {
				ret += b[i];
			}
		}
		return ret;
	}
	public static double power(double d, int n) {
		double ret = 1;
		for(int i=0;i<n;i++) {
			ret *= d;
		}
		return ret;
	}
	public static void setCombiFact() {
		combifact = new int[19];
		combifact[0] = combifact[18] = 1;
		int top = 18; int bot = 1; 
		int temp = top / bot;
		for(int i=1;i<=9;i++) {
			combifact[i] = temp;
			combifact[18-i] = temp;
			top--; bot++;
			temp = temp * top / bot;
		}
	}
}
/*
10
0 0
80 90
10 20
1 2
100 100
60 23
70 23
80 32
90 32
100 32
*/














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