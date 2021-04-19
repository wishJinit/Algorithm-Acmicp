package bfs;

// https://www.acmicpc.net/problem/9372
// 상근이의 여행

import java.io.*;
import java.util.*;

public class Q9372 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean[][] arr = new boolean[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = arr[b][a] = true;
            }

            sb.append(solution(N, M, arr)).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    static int solution(int N, int M, boolean[][] arr) {
        boolean[] visit = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;

        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()) {
            cnt++;
            int idx = queue.poll();
            for (int j = 1; j <= N; j++) {
                if (!visit[j] && arr[j][idx]) {
                    queue.add(j);
                    visit[j] = true;
                }
            }
        }

        return cnt - 1;
    }
}
