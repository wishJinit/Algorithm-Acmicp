package bfs;

// https://www.acmicpc.net/problem/1260
// DFS와 BFS

import java.util.*;
import java.io.*;

public class Q1260 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int V = Integer.parseInt(s[2]);
		
		boolean[][] map = new boolean[N+1][N+1]; 
		map[V][V] = true;
		
		for(int i = 1; i <= M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			map[a][b] = map[b][a] = true;
		}
		
		dfs(map, new boolean[N+1], N, V);
		sb.append("\n");
		bfs(map, new boolean[N+1], N, V);
		
		System.out.println(sb.toString());
	}
	
	static void dfs(boolean[][] map, boolean[] visit, int N, int n) {
		if(visit[n]) return;
		visit[n] = true;
		sb.append(n+" ");
		
		for(int i = 1; i <= N; i++) {
			if(map[n][i] && !visit[i]) {
				dfs(map, visit, N, i);
			}
		}
	}
	
	static void bfs(boolean[][] map, boolean[] visit, int N, int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V);
		visit[V] = true;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			sb.append(n+" ");
			for(int i = 1; i <= N; i++) {
				if(map[n][i] && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
