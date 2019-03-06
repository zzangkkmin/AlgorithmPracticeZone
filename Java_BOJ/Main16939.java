package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16939 {
	public static String[] line;
	public static int[] dice = new int[25];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().trim().split(" ");
		for(int i=1;i<=24;i++) {
			dice[i] = Integer.parseInt(line[i-1]);
		}
		System.out.println(rotate_top_clock());
	}
	public static int rotate_top_clock() {		
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[1] = dice[3];
		rd[2] = dice[1];
		rd[4] = dice[2];
		rd[3] = dice[4];
		
		rd[21] = dice[13];
		rd[22] = dice[14];
		rd[17] = dice[19];
		rd[18] = dice[18];
		rd[5] = dice[17];
		rd[6] = dice[18];
		rd[13] = dice[5];
		rd[14] = dice[6];
		
		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return rotate_top_anticlock();
		}
	}
	public static int rotate_top_anticlock() {
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[1] = dice[2];
		rd[2] = dice[4];
		rd[4] = dice[3];
		rd[3] = dice[1];
		
		rd[22] = dice[18];
		rd[21] = dice[17];
		rd[18] = dice[6];
		rd[17] = dice[5];
		rd[6] = dice[14];
		rd[5] = dice[13];
		rd[14] = dice[22];
		rd[13] = dice[21];

		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return rotate_bottom_clock();
		}
	}
	public static int rotate_bottom_clock() {
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[9] = dice[11];
		rd[10] = dice[9];
		rd[12] = dice[10];
		rd[11] = dice[12];
		
		rd[8] = dice[16];
		rd[7] = dice[15];
		rd[20] = dice[8];
		rd[19] = dice[7];
		rd[24] = dice[20];
		rd[23] = dice[19];
		rd[16] = dice[24];
		rd[15] = dice[23];

		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return rotate_bottom_anticlock();
		}
	}
	public static int rotate_bottom_anticlock() {
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[9] = dice[10];
		rd[11] = dice[9];
		rd[12] = dice[11];
		rd[10] = dice[12];
		
		rd[7] = dice[19];
		rd[8] = dice[20];
		rd[19] = dice[23];
		rd[20] = dice[24];
		rd[23] = dice[15];
		rd[24] = dice[16];
		rd[15] = dice[7];
		rd[16] = dice[8];

		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return rotate_left_clock();
		}
	}
	public static int rotate_left_clock() {
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[13] = dice[15];
		rd[14] = dice[13];
		rd[16] = dice[14];
		rd[15] = dice[16];
		
		rd[3] = dice[22];
		rd[1] = dice[24];
		rd[7] = dice[3];
		rd[5] = dice[1];
		rd[11] = dice[7];
		rd[9] = dice[5];
		rd[22] = dice[11];
		rd[24] = dice[9];

		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return rotate_left_anticlock();
		}
	}
	public static int rotate_left_anticlock() {
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[13] = dice[14];
		rd[14] = dice[16];
		rd[16] = dice[15];
		rd[15] = dice[13];
		
		rd[1] = dice[5];
		rd[3] = dice[7];
		rd[5] = dice[9];
		rd[7] = dice[11];
		rd[9] = dice[24];
		rd[11] = dice[22];
		rd[24] = dice[1];
		rd[22] = dice[3];


		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return rotate_right_clock();
		}
	}
	public static int rotate_right_clock() {
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[17] = dice[19];
		rd[18] = dice[17];
		rd[20] = dice[18];
		rd[19] = dice[20];
		
		rd[2] = dice[6];
		rd[4] = dice[8];
		rd[23] = dice[2];
		rd[21] = dice[4];
		rd[10] = dice[23];
		rd[12] = dice[21];
		rd[6] = dice[10];
		rd[8] = dice[12];

		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return rotate_right_anticlock();
		}
	}
	public static int rotate_right_anticlock() {
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[17] = dice[18];
		rd[18] = dice[20];
		rd[20] = dice[19];
		rd[19] = dice[17];
		
		rd[4] = dice[21];
		rd[2] = dice[23];
		rd[8] = dice[4];
		rd[6] = dice[2];
		rd[12] = dice[8];
		rd[10] = dice[6];
		rd[21] = dice[12];
		rd[23] = dice[10];

		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return rotate_front_clock();
		}
	}
	public static int rotate_front_clock() {
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[5] = dice[7];
		rd[6] = dice[5];
		rd[8] = dice[6];
		rd[7] = dice[8];
		
		rd[4] = dice[14];
		rd[3] = dice[16];
		rd[19] = dice[4];
		rd[17] = dice[3];
		rd[9] = dice[19];
		rd[10] = dice[17];
		rd[14] = dice[9];
		rd[16] = dice[10];

		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return rotate_front_anticlock();
		}
	}
	public static int rotate_front_anticlock() {
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[5] = dice[6];
		rd[6] = dice[8];
		rd[8] = dice[7];
		rd[7] = dice[5];
		
		rd[3] = dice[17];
		rd[4] = dice[19];
		rd[17] = dice[10];
		rd[19] = dice[9];
		rd[10] = dice[16];
		rd[9] = dice[14];
		rd[16] = dice[3];
		rd[14] = dice[4];

		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return rotate_back_clock();
		}
	}
	public static int rotate_back_clock() {
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[21] = dice[23];
		rd[22] = dice[21];
		rd[24] = dice[22];
		rd[23] = dice[24];
		
		rd[1] = dice[18];
		rd[2] = dice[20];
		rd[15] = dice[1];
		rd[13] = dice[2];
		rd[12] = dice[15];
		rd[11] = dice[13];
		rd[18] = dice[12];
		rd[20] = dice[11];

		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return rotate_back_anticlock();
		}
	}
	public static int rotate_back_anticlock() {
		int[] rd = new int[25];
		for(int i=1;i<=24;i++) {
			rd[i] = dice[i];
		}
		
		rd[21] = dice[22];
		rd[22] = dice[24];
		rd[24] = dice[23];
		rd[23] = dice[21];
		
		rd[2] = dice[13];
		rd[1] = dice[15];
		rd[13] = dice[11];
		rd[15] = dice[12];
		rd[11] = dice[20];
		rd[12] = dice[18];
		rd[20] = dice[2];
		rd[18] = dice[1];

		boolean ok = true;
		for(int i=0;i<6;i++) {
			if(!(rd[i*4+1]==rd[i*4+2] && rd[i*4+2]==rd[i*4+3] && rd[i*4+3]==rd[i*4+4] && rd[i*4+4]==rd[i*4+1])) {
				ok = false;
				break;
			}
		}
		if(ok) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
