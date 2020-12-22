package bfs;

// https://www.acmicpc.net/problem/10026
// 적록색약

import java.io.*;
import java.util.*;

public class Q10026 {
    final static char RED = 'R';
    final static char GREEN = 'G';
    final static char BLUE = 'B';

    static class Point {
        int y, x;
        char color;

        Point(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) map[i][j] = s.charAt(j);
        }

        Arrays.stream(solution(N, map)).forEach(o -> sb.append(o).append(" "));
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static int[] solution(int N, char[][] map) {
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        Queue<Point> notPillQueue = new LinkedList<>();
        Queue<Point> pillQueue = new LinkedList<>();
        boolean[][] notPillIsVisit = new boolean[N][N];
        boolean[][] pillIsVisit = new boolean[N][N];
        int notPillAnswer = 0, pillAnswer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!notPillIsVisit[i][j]) {
                    notPillQueue.add(new Point(i, j, map[i][j]));
                    notPillIsVisit[i][j] = true;
                    notPillAnswer++;
                    while (!notPillQueue.isEmpty()) {
                        Point point = notPillQueue.poll();
                        for (int k = 0; k < 4; k++) {
                            char c = point.color;
                            int y = point.y + dy[k];
                            int x = point.x + dx[k];
                            if (notPillCheck(c, y, x, N, map, notPillIsVisit)) {
                                notPillQueue.add(new Point(y, x, c));
                                notPillIsVisit[y][x] = true;
                            }
                        }
                    }
                }
                if (!pillIsVisit[i][j]) {
                    pillQueue.add(new Point(i, j, map[i][j]));
                    pillIsVisit[i][j] = true;
                    pillAnswer++;
                    while (!pillQueue.isEmpty()) {
                        Point point = pillQueue.poll();
                        for (int k = 0; k < 4; k++) {
                            char c = point.color;
                            int y = point.y + dy[k];
                            int x = point.x + dx[k];
                            if (pillCheck(c, y, x, N, map, pillIsVisit)) {
                                pillQueue.add(new Point(y, x, c));
                                pillIsVisit[y][x] = true;
                            }
                        }
                    }
                }
            }
        }

        return new int[]{notPillAnswer, pillAnswer};
    }

    private static boolean notPillCheck(char c, int y, int x, int N, char[][] map, boolean[][] isVisit) {
        return positionIsAvail(y, x, N) && map[y][x] == c && !isVisit[y][x];
    }

    private static boolean pillCheck(char c, int y, int x, int N, char[][] map, boolean[][] isVisit) {
        if (positionIsAvail(y, x, N) && !isVisit[y][x]) {
            if (c == BLUE) return map[y][x] == BLUE;
            else return map[y][x] != BLUE;
        }
        return false;
    }

    private static boolean positionIsAvail(int y, int x, int N) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }
}
