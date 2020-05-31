package bfs;

// https://www.acmicpc.net/problem/2667
// 단지번호붙이기

import java.util.*;
import java.io.*;

public class Q2667 {
	static class Point {
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> al = new ArrayList<Integer>();
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++)
				map[i][j] = s.charAt(j) - '0';
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) al.add(dfs(map, N, i, j));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(al.size()+"\n");
		
		Collections.sort(al);

		for(Integer i : al) {
			sb.append(i+"\n");
		}
		
		System.out.print(sb);
	}
	
	private static int dfs(int[][] map, int N, int y, int x) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y));
		map[y][x] = 0;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			cnt++;
			for(int k = 0; k < 4; k++) {
				int xx = p.x + dx[k];
				int yy = p.y + dy[k];
				if(check(map, N, xx, yy)) {
					q.offer(new Point(xx, yy));
					map[yy][xx] = 0;
				}
			}
		}
		
		return cnt;
	}
	
	private static boolean check(int[][] map, int N, int x, int y) {
		if(x >= N || y >= N) return false;
		else if(x < 0 || y < 0) return false;
		else if(map[y][x] == 0) return false;
		return true;
	}
}
