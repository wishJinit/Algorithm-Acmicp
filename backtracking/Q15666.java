package backtracking;

// https://www.acmicpc.net/problem/15666
// N과 M (12)

import java.io.*;
import java.util.*;

public class Q15666 {
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
        dfs(0, 0);
    }

    private static void dfs(int idx, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(num[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < N; i++) {
            int value = arr[i];
            if (!set.contains(value)) {
                set.add(value);
                num[depth] = value;
                dfs(i, depth + 1);
            }
        }
    }
}
