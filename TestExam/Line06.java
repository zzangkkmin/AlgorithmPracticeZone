package com.ssafy.git.TestExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
 
public class Line06 {
    static class Node implements Comparable{
        private int x;
        private int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        int getX() {
            return x;
        }
        int getY() {
            return y;
        }
 
        @Override
        public int compareTo(Object arg0) {
            Node other = (Node) arg0;
            if(y>other.getY())
                return 1;
            else if(y<other.getY())
                return -1;
            else {
                if(x>other.getX())
                    return 1;
                else if(x<other.getX())
                    return -1;
                else {
                    return 0;
                }
            }
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Node [x=");
            builder.append(x);
            builder.append(", y=");
            builder.append(y);
            builder.append("]");
            return builder.toString();
        }
         
         
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] node = new Node[n];
        for(int i=0;i<n;i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            node[i] = new Node(start,end);
        }
         
        Arrays.sort(node);
         
//      for(int i=0;i<n;i++) {
//          System.out.println(node[i].getX() + " " + node[i].getY());
//      }
         
        int end_time = node[0].getY();
        int idx = 1;
        int ans = 1;
        while(idx < node.length) {
            if(node[idx].getX() <= end_time) {
                idx++;
            }
            else {
                end_time = node[idx].getY();
                ans++;
                idx++;
            }
        }
        System.out.println(ans);
        sc.close();
    }
 
}