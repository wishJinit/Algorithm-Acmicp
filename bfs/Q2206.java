package bfs;

// https://www.acmicpc.net/problem/2206
// 벽 부수고 이동하기

import java.util.*;
import java.io.*;

public class Q2206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++)
                map[i][j] = s.charAt(j)-'0';
        }

    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
