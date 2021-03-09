package bfs;

// https://www.acmicpc.net/problem/2667
// 단지번호붙이기

import java.util.*;
import java.io.*;

public class Q2667_2 {

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

        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = chars[j] == '1';
            }
        }

        bw.write(solution(N, map));
        bw.close();
        br.close();
    }

    static String solution(int N, boolean[][] map) {
        List<Integer> answer = new ArrayList<>();
        int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) {
                    map[i][j] = false;
                    queue.add(new Point(i, j));
                    int cnt = 1;
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int y = p.y + dy[k];
                            int x = p.x + dx[k];
                            if (isPossible(y, x, N, map)) {
                                cnt++;
                                map[y][x] = false;
                                queue.add(new Point(y, x));
                            }
                        }
                    }
                    answer.add(cnt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(answer.size()).append("\n");
        Collections.sort(answer);
        answer.forEach(o -> sb.append(o).append("\n"));

        return sb.toString();
    }

    private static boolean isPossible(int y, int x, int N, boolean[][] map) {
        return 0 <= y && y < N && 0 <= x && x < N && map[y][x];
    }
}
