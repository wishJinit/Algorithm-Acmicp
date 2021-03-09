package bfs;

// https://www.acmicpc.net/problem/2606
// 바이러스

import java.io.*;
import java.util.*;

public class Q2606_2 {

    public static void main(String[] args) throws Exception {
        final int START = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N + 1][N + 1];
        boolean[] check = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
            arr[v1][v2] = arr[v2][v1] = true;
        }

        check[START] = true;
        q.add(START);

        int cnt = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[v][i] && !check[i]) {
                    check[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }

        bw.write(Integer.toString(cnt));
        bw.close();
        br.close();
    }
}
