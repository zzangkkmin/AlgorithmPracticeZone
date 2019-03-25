package com.ssafy.git.Java_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3987 {
	public static int n,m,pr,pc;
	public static char[][] map;
	public static visit[][] visited;
	public static int[] dx = {0,-1,0,1,0};
	public static int[] dy = {0,0,1,0,-1};
	public static int[] c1 = {0,4,3,2,1};// '\'
	public static int[] c2 = {0,2,1,4,3};// '/'
	public static char[] urdr = {0,'U','R','D','L'};
	public static String[] linez;
	public static String line;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		linez = br.readLine().trim().split(" ");
		n = Integer.parseInt(linez[0]);
		m = Integer.parseInt(linez[1]);
		map = new char[n][m];
		visited = new visit[n][m];
		for(int i=0;i<n;i++){
			line = br.readLine().trim();
			for(int j=0;j<m;j++){
				map[i][j] = line.charAt(j);
				visited[i][j] = new visit();
			}
		}
		
		linez = br.readLine().trim().split(" ");
		pr = Integer.parseInt(linez[0]);
		pc = Integer.parseInt(linez[1]);
		
		int ans = 0;
		int ansD = 0;
		for(int d=1;d<=4;d++){
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					visited[i][j] = new visit();
				}
			}
			int temp = go(pr-1,pc-1,d,1);
			if(temp == -1){
				System.out.println(urdr[d]);
				System.out.println("Voyager");
				return;
			}
			else if(ans < temp){
				ans = temp;
				ansD = d;
			}
		}
		System.out.println(urdr[ansD]);
		System.out.println(ans);
	}
	public static boolean inrange(int x, int y){
		if(x>=0&&x<n&&y>=0&&y<m){
			return true;
		}
		else
			return false;
	}
	public static int go(int x, int y, int dir, int time){
		visited[x][y] = new visit(1,dir);
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(!inrange(nx,ny) || map[nx][ny]=='C'){
			return time;
		}
		else if(map[nx][ny]=='\\' && dir != visited[nx][ny].dir){
			dir = c1[dir];
			return go(nx,ny,dir,time+1);
		}
		else if(map[nx][ny]=='/' && dir != visited[nx][ny].dir){
			dir = c2[dir];
			return go(nx,ny,dir,time+1);
		}
		else if(visited[nx][ny].visited == 1 && dir == visited[nx][ny].dir){
			return -1;
		}
		else{
			return go(nx,ny,dir,time+1);
		}
	}
	public static class visit{
		int visited;
		int dir;
		public visit(){
			this.visited = 0;
			this.dir = 0;
		}
		public visit(int visited, int dir) {
			super();
			this.visited = visited;
			this.dir = dir;
		}		
	}
}
