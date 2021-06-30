package implementation;

// https://www.acmicpc.net/problem/3190
// 뱀

import java.io.*;
import java.util.*;

public class Q3190 {
    private static final int EMPTY = 0;
    private static final int APPLE = 1;
    private static final int SNAKE = 2;

    private static final String LEFT = "L";
    private static final String RIGHT = "D";

    private static final int[][] DIRECT = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    private static class SnakeDirect {
        int time;
        String direct;

        SnakeDirect(int time, String direct) {
            this.time = time;
            this.direct = direct;
        }
    }

    private static class Position {
        int x, y;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0, K = Integer.parseInt(br.readLine()); i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = APPLE;
        }

        int L = Integer.parseInt(br.readLine());
        SnakeDirect[] snakeDirects = new SnakeDirect[L];
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            snakeDirects[i] = new SnakeDirect(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        bw.write(Integer.toString(solution(N, map, L, snakeDirects)));
        bw.close();
    }

    static int solution(int N, int[][] map, int L, SnakeDirect[] snakeDirects) {
        int cnt = 0;

        int x = 0, y = 0;
        int d = 0, sdIdx = 0;
        Queue<Position> queue = new LinkedList<>();
        map[y][x] = SNAKE;
        queue.add(new Position(y, x));
        while (!queue.isEmpty()) {
            cnt++;
            int dy = DIRECT[d][0] + y, dx = DIRECT[d][1] + x;
            if (!check(N, dy, dx)) break;
            else if (map[dy][dx] == SNAKE) break;
            else if (map[dy][dx] == APPLE) {
                queue.add(new Position(dy, dx));
                map[dy][dx] = SNAKE;
            } else {
                queue.add(new Position(dy, dx));
                map[dy][dx] = SNAKE;
                Position nowPos = queue.poll();
                map[nowPos.y][nowPos.x] = EMPTY;
            }
            if (sdIdx < L && snakeDirects[sdIdx].time == cnt) {
                if (snakeDirects[sdIdx].direct.equals(RIGHT)) d = (d + 1) % DIRECT.length;
                else d = d - 1 < 0 ? DIRECT.length - 1 : d - 1;
                sdIdx++;
            }
            y = dy;
            x = dx;
        }
        return cnt;
    }

    private static boolean check(int N, int y, int x) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
