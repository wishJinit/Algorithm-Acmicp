package bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2178
// 미로 탐색

public class Q2178 {
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		int[] mx = {0, 0, 1, -1};
		int[] my = {1, -1, 0, 0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Point> q = new LinkedList<Point>();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		
		q.add(new Point(0, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
 			for(int k = 0; k < 4; k++) {
				int x = p.x + mx[k];
				int y = p.y + my[k];
				if(x >= 0 && y >= 0 && x < M && y < N && !visit[y][x] && map[y][x] >= 1) {
					q.add(new Point(x, y));
					visit[y][x] = true;
					map[y][x] = map[p.y][p.x] + 1;
				}
			}
		}
		
		System.out.println(map[N-1][M-1]);
		
	}
}
