package bfs;

// https://www.acmicpc.net/problem/2583
// 영역 구하기

import java.io.*;
import java.util.*;

public class Q2583 {
    static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = parseInt(st.nextToken()), N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
        int[][] squares = new int[K][4];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            squares[i][0] = parseInt(st.nextToken());
            squares[i][1] = parseInt(st.nextToken());
            squares[i][2] = parseInt(st.nextToken());
            squares[i][3] = parseInt(st.nextToken());
        }

        bw.write(solution(M, N, squares));
        br.close();
        bw.close();
    }

    static String solution(int M, int N, int[][] squares) {
        StringBuilder sb = new StringBuilder();
        Queue<Point> queue = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        boolean[][] map = new boolean[M][N];
        boolean[][] isVisit = new boolean[M][N];

        for (int[] square : squares) {
            int x1 = square[0], y1 = square[1], x2 = square[2], y2 = square[3];
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    map[i][j] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisit[i][j] && !map[i][j]) {
                    int cnt = 0;
                    queue.add(new Point(i, j));
                    isVisit[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        cnt++;
                        for (int k = 0; k < 4; k++) {
                            int y = point.y + dy[k];
                            int x = point.x + dx[k];
                            if (check(y, x, M, N, map, isVisit)) {
                                queue.add(new Point(y, x));
                                isVisit[y][x] = true;
                            }
                        }
                    }
                    answerList.add(cnt);
                }
            }
        }

        sb.append(answerList.size()).append("\n");
        answerList.stream().sorted().forEach(o -> sb.append(o).append(" "));

        return sb.toString();
    }

    private static boolean check(int y, int x, int M, int N, boolean[][] map, boolean[][] isVisit) {
        return 0 <= y && y < M && 0 <= x && x < N && !map[y][x] && !isVisit[y][x];
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
