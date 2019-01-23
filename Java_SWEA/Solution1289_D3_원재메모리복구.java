package com.ssafy.swe;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Solution1289_D3_원재메모리복구 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/d3_1289.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int Ans = 0;
			String str = sc.next();
			int size = str.length();
			
			//case 1:
//			StringBuilder nData = new StringBuilder(str);
//			int N = 1;
//			int idx = str.indexOf("1");//첫 번째 1의 위치 구하기
//			for(int i=idx;i<size;) {
//				change(nData, i, size, "" + (N%2));
//				//변경 후 원래 메모리값과 같은지 비교
//				if(str.equals(nData.toString())) {
//					break;
//				}
//				for(int j= i + 1;j < size; j++) {
//					if(str.charAt(j) != nData.charAt(j)) {
//						i = j;
//						break;
//					}
//				}
//				N++;
//			}
//			Ans = N;
			
			//case 2:
			char mode = '0';
			for(int i=0;i<size;i++) {
				if(mode != str.charAt(i)) {
					mode = str.charAt(i);
					Ans++;
				}
			}
			
			System.out.println("#" + test_case + " " + Ans);
		}
	}

	private static void change(StringBuilder nData, int start, int size, String fill) {
		// TODO Auto-generated method stub
		for(int i = start; i< size; i++) {
			nData.replace(i, i+1, fill);
		}
	}

}
