package com.ssafy.git.Java_BOJ;
import java.util.Scanner;

public class Main529 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int weight = sc.nextInt();
        int score = weight + 100 - height;
        System.out.println(score);
        if(score>0) {
            System.out.println("Obesity");
        }
	}
//	input:
//		180 100
//	output:
//		20
//		Obesity
}
