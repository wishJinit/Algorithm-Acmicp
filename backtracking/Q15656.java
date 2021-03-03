package backtracking;

// https://www.acmicpc.net/problem/15656
// N과 M (7)

import java.io.*;
import java.util.*;

public class Q15656 {
    static int N, M;
    static int[] arr;
    static int[] num;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        num = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void solution() {
        Arrays.sort(arr);
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(num[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            num[depth] = arr[i];
            dfs(depth + 1);
        }
    }
}
