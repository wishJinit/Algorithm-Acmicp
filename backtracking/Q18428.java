package backtracking;

// https://www.acmicpc.net/problem/18428
// 감시 피하기

import java.io.*;
import java.util.*;

public class Q18428 {
    private static final char TEACHER = 'T';
    private static final char STUDENT = 'S';
    private static final char EMPTY = 'X';
    private static final char WALL = 'O';

    private static final int WALL_MAX_CNT = 3;

    private static final String YES = "YES";
    private static final String NO = "NO";

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static final int DIRECT_LEN = dx.length;

    private static int N;
    private static char[][] arr;
    private static final List<Position> teacherPositions = new ArrayList<>();
    private static int teacherPositionSize;

    private static class Position {
        int y, x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.nextToken().charAt(0);
                if (arr[i][j] == TEACHER) {
                    teacherPositions.add(new Position(i, j));
                }
            }
        }

        teacherPositionSize = teacherPositions.size();
        bw.write(dfs(0, 0, 0) ? YES : NO);
        bw.close();
    }

    private static boolean dfs(int y, int x, int cnt) {
        if (cnt == WALL_MAX_CNT) {
            return check();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (y < i || (y == i) && (x <= j)) {
                    if (arr[i][j] == EMPTY) {
                        arr[i][j] = WALL;
                        if (dfs(i, j, cnt + 1)) {
                            return true;
                        }
                        arr[i][j] = EMPTY;
                    }
                }
            }
        }
        return false;
    }

    private static boolean check() {
        for (int s = 0; s < teacherPositionSize; s++) {
            Position p = teacherPositions.get(s);

            for (int k = 0; k < DIRECT_LEN; k++) {
                int x = p.x, y = p.y;
                while (true) {
                    x += dx[k];
                    y += dy[k];
                    if (0 <= x && x < N && 0 <= y && y < N) {
                        if (arr[y][x] == WALL) break;
                        else if (arr[y][x] == STUDENT) return false;
                    } else {
                        break;
                    }
                }
            }
        }

        return true;
    }
}
