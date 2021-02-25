package backtracking;

// https://www.acmicpc.net/problem/14889
// 스타트와 링크

import java.io.*;
import java.util.*;

public class Q14889 {
    static int N;
    static int[][] arr;
    static boolean[] member;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        member = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);
        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    static void calculator() {
        int start = 0, link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (member[i] && member[i] == member[j]) {
                    start += arr[i][j];
                } else if (!member[i] && member[i] == member[j]) {
                    link += arr[i][j];
                }
            }
        }

        answer = Math.min(answer, Math.abs(start - link));
    }

    static void solution(int idx, int depth) {
        if (depth == N / 2) {
            calculator();
            return;
        }
        for (int i = idx; i < N; i++) {
            member[i] = true;
            solution(i + 1, depth + 1);
            member[i] = false;
        }
    }
}
