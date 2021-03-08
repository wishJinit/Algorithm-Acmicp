package bfs;

// https://www.acmicpc.net/problem/1260
// DFS와 BFS

import java.io.*;
import java.util.*;

public class Q1260_2 {
    static StringBuilder sb = new StringBuilder();
    static boolean[][] arr;
    static boolean[] check;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new boolean[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1][v2] = arr[v2][v1] = true;
        }

        check[V] = true;
        sb.append(V).append(" ");
        dfs(V);

        Arrays.fill(check, false);
        sb.append("\n").append(V).append(" ");
        bfs(V);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int v) {
        for (int i = 1; i <= N; i++) {
            if (arr[v][i] && !check[i]) {
                check[i] = true;
                sb.append(i).append(" ");
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        check[v] = true;

        while (!q.isEmpty()) {
            int cv = q.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[cv][i] && !check[i]) {
                    check[i] = true;
                    q.add(i);
                    sb.append(i).append(" ");
                }
            }
        }
    }
}
