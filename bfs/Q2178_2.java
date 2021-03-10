package bfs;

// https://www.acmicpc.net/problem/2178
// 미로 탐색

import java.util.*;
import java.io.*;

public class Q2178_2 {

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bw.write(Integer.toString(solution(N, M, map)));
        bw.close();
        br.close();
    }

    static int solution(int N, int M, int[][] map) {
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        final int DIRECT_CNT = dx.length;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        map[0][0] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int k = 0; k < DIRECT_CNT; k++) {
                int x = p.x + dx[k], y = p.y + dy[k];
                int value = p.value + 1;
                if (isPossible(x, y, M, N, map)) {
                    map[y][x] = value;
                    queue.add(new Point(y, x, value));
                }
            }
        }

        return map[N - 1][M - 1];
    }

    private static boolean isPossible(int x, int y, int M, int N, int[][] map) {
        return 0 <= x && x < M && 0 <= y && y < N && map[y][x] == 1;
    }
}
