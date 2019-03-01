package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main16924 {
	public static int n,m, ans;
	public static char[][] map;
	public static char[][] cmap;
	public static String line;
	public static boolean isOK = true;
	public static ArrayList<Integer[]> ansList = new ArrayList<>();
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		map = new char[n+1][m+1];
		cmap = new char[n+1][m+1];
		for(int i=1;i<=n;i++){
			line = br.readLine().trim();
			for(int j=1;j<=m;j++){
				map[i][j] = line.charAt(j-1);
			}
			Arrays.fill(cmap[i], '.');
		}
		for(int i = 2; i<=n-1;i++){
			for(int j = 2;j<=m-1;j++){
				if(map[i][j] == '*'){
					find(i,j);
				}
			}
		}
		for(int i = 1; i<=n;i++){
			if(isOK==false){
				break;
			}
			for(int j = 1;j<=m;j++){
				if(map[i][j] != cmap[i][j]){
					isOK = false;
					break;
				}
			}
		}
		if(isOK==false){
			System.out.println(-1);
		}
		else{
			System.out.println(ans);
			for(Integer[] a : ansList){
				System.out.println(a[0]+" "+a[1]+" "+a[2]);
			}
		}
	}
	public static void find(int x, int y){
		
		int k = 1;
		while(true){
			int[][] crossLine = new int[4][2];
			boolean cross = true;
			for(int d=0;d<4;d++){
				int nx = x + dx[d] * k;
				int ny = y + dy[d] * k;
				if(!(nx>=1 && nx<=n && ny>=1 && ny<=m && map[nx][ny]=='*')){
					cross = false;
					break;
				}
				crossLine[d][0] = nx;
				crossLine[d][1] = ny;
			}
			if(cross==false){
				break;
			}
			else{
				ans++;
				cmap[x][y] = '*';
				for(int d=0;d<4;d++){
					cmap[crossLine[d][0]][crossLine[d][1]] = '*';
				}
				Integer[] listInput = new Integer[3];
				listInput[0] = x; listInput[1] = y; listInput[2] = k;
				ansList.add(listInput);
				k++;
			}
		}
	}

}
