package com.ssafy.git.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JungOl_2577_회전초밥 {
	static int n,d,k,c,max;
    static int[] count;
    static int[] select;
    static int[] sushi;
    static int[] coupon;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        n = Integer.parseInt(line[0]);
        d = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);
        c = Integer.parseInt(line[3]);
        sushi = new int[n+k+1];
        count = new int[n+k+1];
        coupon = new int[n+k+1];
        select = new int[d+1];
        int i;
        for(i=1;i<=n;i++) {
            sushi[i] = Integer.parseInt(br.readLine().trim());
        }
        for(;i<=n+k;i++) {
            sushi[i] = sushi[i-n];
        }
         
        counterMax();
        for(i=k+1;i<=n+k;i++) {
            if(coupon[i] != 0) {
                count[i]--;
            }
            if(count[i] > max) {
                max = count[i];
            }
        }
         
        System.out.println(max+1);
    }
    public static void counterMax() {
        int i;
        int cnt = 0;
        for(i=1;i<=k;i++) {
            cnt = count[i-1];
            if(cnt < k && select[sushi[i]] == 0) {
                cnt++;
            }
            count[i] = cnt;
            select[sushi[i]]++;
        }
        for(;i<=n+k;i++) {
            select[sushi[i-k]]--;
            if(select[sushi[i-k]]==0) {
                cnt--;
            }
            if(cnt < k && select[sushi[i]] == 0) {
                cnt++;
            }
            count[i] = cnt;
            select[sushi[i]]++;
            
            coupon[i] = select[c];
        }
    }
}
