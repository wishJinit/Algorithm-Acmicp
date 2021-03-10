package bfs;

// https://www.acmicpc.net/problem/7576
// 토마토

import java.util.*;
import java.io.*;

public class Q7576_2 {

    private static class Point {
        int y, x;
        int value;

        Point(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        final int DIRECT_CNT = dx.length;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] check = new boolean[N][M];

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) {
                    queue.add(new Point(i, j, v));
                    check[i][j] = true;
                }
                map[i][j] = v;
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int k = 0; k < DIRECT_CNT; k++) {
                int y = p.y + dy[k], x = p.x + dx[k];
                int value = p.value + 1;
                if (isPossible(y, x, N, M, map, check)) {
                    queue.add(new Point(y, x, value));
                    map[y][x] = value;
                    check[y][x] = true;
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    answer = 0;
                    i = N;
                    break;
                }
                answer = Math.max(answer, map[i][j]);
            }
        }

        bw.write(Integer.toString(answer - 1));
        bw.close();
        br.close();
    }

    private static boolean isPossible(int y, int x, int N, int M, int[][] map, boolean[][] check) {
        return 0 <= y && y < N && 0 <= x && x < M && map[y][x] == 0 && !check[y][x];
    }
}
