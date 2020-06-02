package bfs;

// TODO : 실패 - 해결
// https://www.acmicpc.net/problem/2206
// 벽 부수고 이동하기

import java.util.*;
import java.io.*;

public class Q2206 {
    static class Point {
        int x, y;
        boolean isBreak;
        Point(int x, int y, boolean isBreak) {
            this.x = x;
            this.y = y;
            this.isBreak = isBreak;
        }
    }

    public static void main(String[] args) throws Exception {
        Queue<Point> q = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][][] visit = new int[2][N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++)
                map[i][j] = s.charAt(j)-'0';
        }

        if(N == 1 && M == 1) {System.out.print(map[0][0]==0?1:-1); return;}

        q.offer(new Point(0, 0, false));
        visit[0][0][0] = 1;
        visit[0][N-1][M-1] = visit[1][N-1][M-1] = -1;

        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            boolean isBreak = p.isBreak;
            for (int i = 0; i < 4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];
                if(checkRoad(xx, yy, N, M)) {
                    if(isBreak){
                        if(map[yy][xx] == 0 && visit[1][yy][xx] <= 0) {
                            q.offer(new Point(xx, yy, true));
                            visit[1][yy][xx] = visit[1][y][x] + 1;
                        }
                    } else {
                        if(visit[0][yy][xx] <= 0) {
                            if(map[yy][xx] == 0) {
                                q.offer(new Point(xx, yy, false));
                                visit[0][yy][xx] = visit[0][y][x] + 1;
                            } else {
                                q.offer(new Point(xx, yy, true));
                                visit[1][yy][xx] = visit[0][y][x] + 1;
                            }
                        }
                    }
                }
            }
        }

        int a = visit[0][N-1][M-1], b = visit[1][N-1][M-1], result;
        if(a == -1 || b == -1) result = Math.max(a, b);
        else result = Math.min(a, b);
        System.out.print(result);
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    private static boolean checkRoad(int x, int y, int N, int M) {
        return (x >= 0 && y >= 0 && x < M && y < N);
    }
}