package bfs;

// TODO : 다시 풀어보기
// https://www.acmicpc.net/problem/5427
// 불

import java.io.*;
import java.util.*;

public class Q5427 {
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] mx = {0, 0, 1, -1};
		int[] my = {1, -1, 0, 0};
		int N = Integer.parseInt(br.readLine());
		
		for(int z = 0; z < N; z++) {
			Queue<int[]> sq = new LinkedList<int[]>();
			Queue<Point> fq = new LinkedList<Point>();
			String[] s = br.readLine().split(" ");
			int w = Integer.parseInt(s[0]);
			int h = Integer.parseInt(s[1]);
			char[][] map = new char[h][w];
			boolean[][] visit = new boolean[h][w];
			boolean isEnd = false;
			
			for(int i = 0; i < h; i++) {
				char[] arr = br.readLine().toCharArray();
				for(int j = 0; j < w; j++) {
					if(arr[j] == '@') {sq.add(new int[] {i, j, 0}); visit[i][j] = true;}
					else if (arr[j] == '*') fq.add(new Point(j, i));
					map[i][j] = arr[j];
				}
			}
			
			while(!sq.isEmpty()) {
				int size = sq.size();
				for(int i = 0; i < size; i++) {
					int[] sang = sq.poll();
					int yy = sang[0];
					int xx = sang[1];
					int t = sang[2];
					if(map[yy][xx] == '*') continue;
					map[yy][xx] = '@';
					
					for(int k = 0; k < 4; k++) {
						int x = xx + mx[k];
						int y = yy + my[k];
						
						if(x < 0 || x >= w || y < 0 || y >= h) {
							sb.append(t+1+"\n");
							k = 4;
							i = size;
							isEnd = true;
						} else if(!visit[y][x] && map[y][x] == '.') {
							visit[y][x] = true;
							sq.add(new int[] {y, x, t+1});
						}
					}
					map[yy][xx] = '.';
				}
				if(isEnd) break;
				
				size = fq.size();
				for(int i = 0; i < size; i++) {
					Point f = fq.poll();
					for(int k = 0; k < 4; k++) {
						int x = f.x + mx[k];
						int y = f.y + my[k];
						
						if(x >= 0 && y >= 0 && x < w && y < h) {
							if(map[y][x] == '.') {
								map[y][x] = '*';
								fq.add(new Point(x, y));
							}
						}
					}
				}
			}
			if(!isEnd) sb.append("IMPOSSIBLE\n");
		}
		System.out.println(sb.toString());
	}
}
