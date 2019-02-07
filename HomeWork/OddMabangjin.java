package com.ssafy.git.HomeWork;

public class OddMabangjin {
	/** 
	 * 홀수 마방진 푸는 법은 다음의 규칙을 따른다.
	 * 1. 정사각형의 맨 아랫줄 가운데에 숫자 1 을 둔다.
	 * 2. 이전 숫자 위치에서 오른쪽 아래칸이 비어 있으면 다음 숫자를 채운다.
	 * 3. 이전 숫자 위치에서 오른쪽 아래칸이 채워져 있으면 이전 숫자의 위칸에 다음 숫자를 채운다.
	 * 4. 오른쪽 아래칸이 사각형의 영역 밖이면 다음의 규칙을 따른다.
	 * 4-1. 수평 및 수직으로 이동해서 마지막 칸이 비어 있으면 해당 칸에 숫자를 채운다.
	 * 4-2. 수평 및 수직으로 이동해도 칸이 없는 경우 이전의 숫자 위치 위쪽 칸에 다음 숫자를 채운다.
	 * 
	 * 그 와중에 마방진의 총합은	n^2 * (1 + n^2) / 2 이고,
	 * 마방진의 각 열의 합은	n * (1 + n^2) / 2 이다.
	 * 
	 * 출처: https://memorist.tistory.com/151 [메모리스트의 상상 노트]
	 * */
	public static int[][] map;
	public static void main(String[] args){
		for(int odd = 1; odd < 10; odd = odd + 2){
			makeOddMabangjin(odd);
			for(int i=0;i<odd;i++){
				for(int j=0;j<odd;j++){
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			int totalSum = 0;
			for(int i=0;i<odd;i++){
				int colSum = 0;
				for(int j=0;j<odd;j++){
					colSum += map[i][j];
					totalSum += map[i][j];
				}
				System.out.println("Col " + i +" sum: " + colSum);
			}
			System.out.println("totalSum: "+totalSum);
			if(confirmMabangjin(odd)){
				System.out.println("This is Mabangjin");
			}
			else{
				System.out.println("This is NOT Mabangjin");
			}
			System.out.println("//////////////////////");
		}
	}
	public static void makeOddMabangjin(int oddn) {
		// TODO Auto-generated method stub
		map = new int[oddn][oddn];
		int x = oddn-1;
		int y = oddn/2;
		int number = 1;
		while(true){
			map[x][y] = number;
			if(number==oddn*oddn){
				break;
			}
			number++;
			int nx = (x + 1) % oddn;
			int ny = (y + 1) % oddn;
			if(map[nx][ny] == 0){
				x = nx;
				y = ny;
			}
			else{
				x = (x - 1 < 0 ? oddn-1 : x-1);
			}
		}
	}
	public static boolean confirmMabangjin(int oddn){
		int confirm = oddn * (1 + oddn * oddn) / 2;
		for(int i=0;i<oddn;i++){
			int sum = 0;
			for(int j=0;j<oddn;j++){
				sum += map[i][j];
			}
			if(sum != confirm){
				return false;
			}
		}
		return true;
	}
}
