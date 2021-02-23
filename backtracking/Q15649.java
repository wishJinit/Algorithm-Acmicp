package backtracking;

// https://www.acmicpc.net/problem/15649
// N과 M (1)

import java.io.*;
import java.util.*;

public class Q15649 {
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        solution(0, "", N, M);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void solution(int depth, String str, int N, int M) {
        if (depth == M) {
            sb.append(str).append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (set.contains(i)) continue;
            String s = (str.equals("") ? Integer.toString(i) : String.format("%s %d", str, i));
            set.add(i);
            solution(depth + 1, s, N, M);
            set.remove(i);
        }
    }
}
