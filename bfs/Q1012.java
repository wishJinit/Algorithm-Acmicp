package bfs;

// https://www.acmicpc.net/problem/1012
// 유기농 배추

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1012 {
    private static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }

            sb.append(solution(M, N, map)).append("\n");

            T--;
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int solution(int M, int N, boolean[][] map) {
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        final int DIRECT_CNT = dx.length;

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j]) {
                    cnt++;
                    map[i][j] = false;
                    queue.add(new Point(i, j));
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        for (int k = 0; k < DIRECT_CNT; k++) {
                            int y = p.y + dy[k], x = p.x + dx[k];
                            if (isPossible(x, y, M, N, map)) {
                                queue.add(new Point(y, x));
                                map[y][x] = false;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }

    private static boolean isPossible(int x, int y, int M, int N, boolean[][] map) {
        return 0 <= x && x < M && 0 <= y && y < N && map[y][x];
    }
}
