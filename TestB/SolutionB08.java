package com.ssafy.git.TestB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

//SWEA 4042. [Professional] Closest
public class SolutionB08 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			long ans = 0;
			int n = sc.nextInt();
			ArrayList<point> pArr = new ArrayList<point>();
			for(int i=0;i<n;i++) {
				int x = sc.nextInt(); int y = sc.nextInt();
				pArr.add(new point(x, y));
			}
			// 1. X좌표 기준으로 정렬
			Collections.sort(pArr, new ComparatorDescending());
			// 1-1. candidate = y좌표 기준으로 정렬될 후보군 tree-set
			TreeSet<point> candidate = new TreeSet<point>(new ComparatorSet());
			
			// 2. 첫번째와 두번째 점의 거리가 최단이라 가정
			candidate.add(pArr.get(0));
			candidate.add(pArr.get(1));
			ans = distance(pArr.get(0), pArr.get(1));
			
			int start = 0;
			for(int i=2;i<n;i++) {
				point now = pArr.get(i);
				
				// 3. 세번째 무터 X축 검사
				while(start < i) {
					point pivot = pArr.get(start);
					long xP = (pivot.x - now.x);
					if(xP * xP > ans) {
						// 3-1. X축 차이가 최단거리보다 크다면 피벗을 배제
						candidate.remove(pivot);
						start++;
					}else {
						break;
					}
				}
				
				// 4. Y축 기준 정렬된 후보자들을 통해 최단 거리 갱신
				
				// 4-1. d = 현재 정답의 거리 범위 설정
				long d = (long) Math.sqrt((double) ans) + 1;
				
				// 4-2. lowerPoint = 현재의 Y좌표에서 d이하인 범위 설정
				point lowerPoint = new point(now.y - d, now.y + d);
				
				// 4-3. lower = lowerPoint안에 있는 점들의 정렬된 집합
				SortedSet<point> lower = candidate.tailSet(lowerPoint);
				
				// 4-4. iterLower = lower의 iterator, 인덱스 관리
				Iterator<point> iterLower = lower.iterator();
				
				// 4-5. iterLower가 긑날때 까지 범위안에 있는 점 p와 현재점 조사
				while(iterLower.hasNext()) {
					point p = iterLower.next();
					d = distance(now, p);
					if(d < ans) {
						ans = d;
					}
				}
				
				// 5. 현재점을 후보군에 포함
				candidate.add(pArr.get(i));
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
	static class point implements Comparable<point>{
		long x; long y;

		public point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "p( " + x + ", " + y + " )";
		}

		@Override
		public int compareTo(point o) {
			// TODO Auto-generated method stub
			return this.x < o.y && this.y > o.y ? 1 : -1;
		}
		
	}
	static long distance(point a, point b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}
	static class ComparatorSet implements Comparator<point>{

		@Override
		public int compare(point o1, point o2) {
			// TODO Auto-generated method stub
			if(o1.y == o2.y) {
				if(o1.x < o2.x) {
					return -1;
				} else if(o1.x == o2.x) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return o1.y < o2.y ? 1 : -1;
			}
		}
		
	}
	static class ComparatorDescending implements Comparator<point>{

		@Override
		public int compare(point o1, point o2) {
			// TODO Auto-generated method stub
			if(o1.x < o2.x) {
				return -1;
			} else if(o1.x == o2.x) {
				return 0;
			} else {
				return 1;
			}
		}
		
	}
}
