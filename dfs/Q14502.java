package dfs;

// https://www.acmicpc.net/problem/14502
// 연구소

import java.io.*;
import java.util.*;

public class Q14502 {
    private static final int FENCE_MAX_CNT = 3;

    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;

    private static final int[] dy = {0, 0, 1, -1};
    private static final int[] dx = {1, -1, 0, 0};
    private static final int DIRECT_LEN = dy.length;

    private static int N, M;
    private static int[][] map;
    private static int answer = 0;

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        bw.write(Integer.toString(answer));
        bw.close();
    }

    private static void dfs(int y, int x, int cnt) {
        if (cnt == FENCE_MAX_CNT) {
            List<Point> changedPoint = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == VIRUS) {
                        setVirus(i, j, changedPoint);
                    }
                }
            }
            answer = Math.max(getEmptyCnt(), answer);
            for (Point p : changedPoint) {
                map[p.y][p.x] = EMPTY;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (y < i || (y == i && x <= j)) {
                    if (map[i][j] == EMPTY) {
                        map[i][j] = WALL;
                        dfs(i, j, cnt + 1);
                        map[i][j] = EMPTY;
                    }
                }
            }
        }
    }

    private static void setVirus(int y, int x, List<Point> changedPoint) {
        for (int z = 0; z < DIRECT_LEN; z++) {
            int yy = y + dy[z], xx = x + dx[z];
            if (0 <= yy && yy < N && 0 <= xx && xx < M && map[yy][xx] == EMPTY) {
                map[yy][xx] = VIRUS;
                changedPoint.add(new Point(yy, xx));
                setVirus(yy, xx, changedPoint);
            }
        }
    }

    private static int getEmptyCnt() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == EMPTY) cnt++;
            }
        }

        return cnt;
    }
}
