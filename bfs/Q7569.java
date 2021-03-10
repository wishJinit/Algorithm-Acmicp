package bfs;

// https://www.acmicpc.net/problem/7569
// 토마토

import java.util.*;
import java.io.*;

public class Q7569 {

    private static class Point {
        int h, y, x;
        int value;

        Point(int h, int y, int x, int value) {
            this.h = h;
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[H][N][M];
        boolean[][][] check = new boolean[H][N][M];

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int z = 0; z < M; z++) {
                    int v = Integer.parseInt(st.nextToken());
                    if (v == 1) {
                        queue.add(new Point(i, j, z, v));
                        check[i][j][z] = true;
                    }
                    map[i][j][z] = v;
                }
            }
        }

        int[] dh = {0, 0, 0, 0, 1, -1}, dx = {0, 0, 1, -1, 0, 0}, dy = {1, -1, 0, 0, 0, 0};
        final int DIRECT_CNT = dh.length;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int k = 0; k < DIRECT_CNT; k++) {
                int h = p.h + dh[k], y = p.y + dy[k], x = p.x + dx[k];
                int value = p.value + 1;
                if (isPossible(h, y, x, H, N, M, map, check)) {
                    map[h][y][x] = value;
                    check[h][y][x] = true;
                    queue.add(new Point(h, y, x, value));
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int z = 0; z < M; z++) {
                    if (map[i][j][z] == 0) {
                        answer = 0;
                        i = H;
                        j = N;
                        break;
                    }
                    answer = Math.max(answer, map[i][j][z]);
                }
            }
        }

        bw.write(Integer.toString(answer - 1));
        bw.close();
        br.close();
    }

    private static boolean isPossible(int h, int y, int x, int H, int N, int M, int[][][] map, boolean[][][] check) {
        return 0 <= h && h < H && 0 <= y && y < N && 0 <= x && x < M && map[h][y][x] == 0 && !check[h][y][x];
    }
}
