package com.ssafy.git.HomeWork;

public class Even4Mabangjin {
	public static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int even4 = 4; even4 <= 20; even4 = even4 + 4){
			makeEven4(even4);
			for(int i=0;i<even4;i++){
				for(int j=0;j<even4;j++){
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			int totalSum = 0;
			for(int i=0;i<even4;i++){
				int colSum = 0;
				for(int j=0;j<even4;j++){
					colSum += map[i][j];
					totalSum += map[i][j];
				}
				System.out.println("Col " + i +" sum: " + colSum);
			}
			System.out.println("totalSum: "+totalSum);
			if(confirmMabangjin(even4)){
				System.out.println("This is Mabangjin");
			}
			else{
				System.out.println("This is NOT Mabangjin");
			}
			System.out.println("//////////////////////");
		}
	}
	public static void makeEven4(int even4){
		map = new int[even4][even4];
		int number = 1;
		for(int i=0;i<even4;i++){
			for(int j=0;j<even4;j++){
				if(firstIn(i,j,even4)){
					map[i][j] = number;
				}
				number++;
			}
		}
		number = 1;
		for(int i=even4-1;i>=0;i--){
			for(int j=even4-1;j>=0;j--){
				if(map[i][j] == 0){
					map[i][j] = number;
				}
				number++;
			}
		}
	}
	public static boolean firstIn(int x, int y, int even4){
		if(x>=0 && x < even4/4*1 && y>=0 && y < even4/4*1){
			return true;
		}
		else if(x>=0 && x < even4/4*1 && y>=even4/4*3 && y < even4){
			return true;
		}
		else if(x>=even4/4*3 && x<even4 && y>=0 && y < even4/4*1){
			return true;
		}
		else if(x>=even4/4*3 && x<even4 && y>=even4/4*3 && y < even4){
			return true;
		}
		else if(x>=even4/4*1 && x<even4/4*3 && y>=even4/4*1 && y<even4/4*3){
			return true;
		}
		return false;
	}
	public static boolean confirmMabangjin(int even4){
		int confirm = even4 * (1 + even4 * even4) / 2;
		for(int i=0;i<even4;i++){
			int sum = 0;
			for(int j=0;j<even4;j++){
				sum += map[i][j];
			}
			if(sum != confirm){
				return false;
			}
		}
		return true;
	}
}
