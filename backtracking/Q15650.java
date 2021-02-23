package backtracking;

// https://www.acmicpc.net/problem/15650
// N과 M (2)

import java.io.*;
import java.util.*;

public class Q15650 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        solution(1, 0, "", N, M);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void solution(int idx, int depth, String str, int N, int M) {
        if (depth == M) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = idx; i <= N; i++) {
            String s = (depth == 0 ? "" : str + " ") + i;
            solution(i + 1, depth + 1, s, N, M);
        }
    }
}
