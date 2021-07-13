package bfs;

// https://www.acmicpc.net/problem/18428
// 감시 피하기

import java.io.*;
import java.util.*;

public class Q18405 {
    private static class Virus implements Comparable<Virus> {
        int y, x, num, cnt;

        Virus(int y, int x, int num, int cnt) {
            this.y = y;
            this.x = x;
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Virus o) {
            if (cnt != o.cnt) return Integer.compare(cnt, o.cnt);
            else return Integer.compare(num, o.num);
        }
    }

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static final int DIRECT_LEN = dx.length;
    private static final int EMPTY = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        Queue<Virus> queue = new PriorityQueue<>();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != EMPTY) queue.add(new Virus(i, j, arr[i][j], 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(solution(N, K, S, X, Y, arr, queue)));
        bw.close();
    }

    static int solution(int N, int K, int S, int X, int Y, int[][] arr, Queue<Virus> queue) {
        int second = 0;
        while (second++ < S) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                Virus v = queue.poll();
                int num = v.num;
                for (int k = 0; k < DIRECT_LEN; k++) {
                    int y = dy[k] + v.y, x = dx[k] + v.x;
                    if (check(y, x, N, arr)) {
                        arr[y][x] = num;
                        queue.add(new Virus(y, x, num, second));
                    }
                }
            }
        }

        return arr[X - 1][Y - 1];
    }

    private static boolean check(int y, int x, int N, int[][] arr) {
        return 0 <= y && y < N && 0 <= x && x < N && arr[y][x] == EMPTY;
    }
}
