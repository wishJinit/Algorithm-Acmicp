package bfs;

//https://www.acmicpc.net/problem/7576
//토마토

import java.util.*;
import java.io.*;

public class Q7576 {
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Point> q = new LinkedList<Point>();
		int[] mx = {0, 0, 1, -1};
		int[] my = {1, -1, 0, 0};
		
		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j] == 1) {q.add(new Point(j, i));}
			}
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k = 0; k < 4; k++) {
				int x = p.x + mx[k];
				int y = p.y + my[k];
				if(x >= 0 && y >= 0 && x < M && y < N && map[y][x] == 0) {
					q.add(new Point(x, y));
					map[y][x] = map[p.y][p.x]+1;
				}
			}
		}

		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					result = 0;
					i = M;
					break;
				}
				result = Math.max(map[i][j], result);
			}
		}
		
		System.out.println(result-1);
	}
}
