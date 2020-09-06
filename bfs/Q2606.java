package bfs;

// https://www.acmicpc.net/problem/2606
// 바이러스

import java.io.*;
import java.util.*;

public class Q2606 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int N = parseInt(br.readLine()), M = parseInt(br.readLine()), cnt = 0;
        boolean[] check = new boolean[N+1];
        boolean[][] map = new boolean[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken()), b = parseInt(st.nextToken());
            map[a][b] = map[b][a] = true;
        }

        q.add(1);
        check[1] = true;
        while (!q.isEmpty()) {
            int num = q.poll();
            for(int i = 1; i <= N; i++) {
                if(map[num][i] && !check[i]) {
                    check[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
