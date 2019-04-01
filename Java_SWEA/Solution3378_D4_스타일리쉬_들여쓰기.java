package com.ssafy.git.Java_SWEA;

import java.util.Scanner;

public class Solution3378_D4_스타일리쉬_들여쓰기 {
	static String line;
	static int p,q;
	static int R,C,S;
	static int[] rcs;
	static int[][] rcsP;
	static int[][] rcsQ;
	static int[] result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			R = C = S = -1;
			rcs = new int[3];
			p = sc.nextInt(); q = sc.nextInt();
			rcsP = new int[p][4];
			rcsQ = new int[q][3];
			result = new int[q];
			readP(sc);
			readQ(sc);
			Qfront();
			System.out.print("#"+t+" ");
			for(int i=0;i<q;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}
	}
	public static void readP(Scanner sc) {
		int rcnt = 0;
		int ccnt = 0;
		int scnt = 0;
		for(int i=0;i<p;i++) {
			line = sc.next();
			rcsP[i][0] = rcnt;
			rcsP[i][1] = ccnt;
			rcsP[i][2] = scnt;
			boolean frontEmpty = true;
			int frontEmptyCnt = 0;
			for(int l=0;l<line.length();l++) {
				if(frontEmpty && line.charAt(l)=='.') {
					frontEmptyCnt++;
				}
				else {
					frontEmpty = false;
					rcsP[i][3] = frontEmptyCnt;
					if(line.charAt(l) == '(') {
						rcnt++;
					}else if(line.charAt(l) == '{') {
						ccnt++;
					}else if(line.charAt(l) == '[') {
						scnt++;
					}else if(line.charAt(l) == ')') {
						rcnt--;
					}else if(line.charAt(l) == '}') {
						ccnt--;
					}else if(line.charAt(l) == ']') {
						scnt--;
					}
				}
			}
		}
		validate();
	}
	public static void validate() {
		for(int a=1;a<=20;a++) {
			for(int b=1;b<=20;b++) {
				for(int c=1;c<=20;c++) {
					boolean allValid = true;
					for(int i=0;i<p;i++) {
						if(a*rcsP[i][0] + b*rcsP[i][1] + c*rcsP[i][2] != rcsP[i][3]) {
							allValid = false;
							break;
						}
					}
					if(allValid) {
						if(R!=a) {
							R=a;
							rcs[0]++;
						}
						if(C!=b) {
							C=b;
							rcs[1]++;
						}
						if(S!=c) {
							S=c;
							rcs[2]++;
						}
					}
				}
			}
		}
	}
	public static void readQ(Scanner sc) {
		int rcnt = 0;
		int ccnt = 0;
		int scnt = 0;
		for(int i=0;i<q;i++) {
			line = sc.next();
			rcsQ[i][0] = rcnt;
			rcsQ[i][1] = ccnt;
			rcsQ[i][2] = scnt;
			for(int l=0;l<line.length();l++) {
				if(line.charAt(l) == '(') {
					rcnt++;
				}else if(line.charAt(l) == '{') {
					ccnt++;
				}else if(line.charAt(l) == '[') {
					scnt++;
				}else if(line.charAt(l) == ')') {
					rcnt--;
				}else if(line.charAt(l) == '}') {
					ccnt--;
				}else if(line.charAt(l) == ']') {
					scnt--;
				}
			}
		}
	}
	public static void Qfront() {
		for(int i=0;i<q;i++) {
			if((rcsQ[i][0] != 0 && rcs[0] != 1) ||
			   (rcsQ[i][1] != 0 && rcs[1] != 1) ||
			   (rcsQ[i][2] != 0 && rcs[2] != 1)) {
				
				int res = -1;
				for(int j=0;j<p;j++) {
					int t1 = -1; int t2 = -1; int tn = 0;
					if(rcsP[j][0] == 0 && rcsQ[i][0] == 0) {
						t1 = 1; t2 = 2; tn++;
					}
					if(rcsP[j][1] == 0 && rcsQ[i][1] == 0) {
						t1 = 0; t2 = 2; tn++;
					}
					if(rcsP[j][2] == 0 && rcsQ[i][2] == 0) {
						t1 = 0; t2 = 1; tn++;
					}
					if(tn!= 1) {
						continue;
					}
					int pt1 = rcsP[j][t1]; int pt2 = rcsP[j][t2];
					int qt1 = rcsQ[i][t1]; int qt2 = rcsQ[i][t2];
					if(qt2==0||pt2==0)
						continue;
					if(pt2*qt1==pt1*qt2) {
						res = qt1 * rcsP[j][3] / qt2;
						break;
					}
				}
				result[i] = res;
				
			}else {
				result[i] = R*rcsQ[i][0] + C*rcsQ[i][1] + S*rcsQ[i][2];
			}
		}
	}
}
