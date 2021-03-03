package backtracking;

// https://www.acmicpc.net/problem/9663
// N-Queen

import java.io.*;

public class Q9663 {
    public static int[] col;
    public static int N;
    public static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        col = new int[N];

        solution(0);
        bw.write(Integer.toString(cnt));
        bw.close();
        br.close();
    }

    static void solution(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isPossible(depth, i)) {
                col[depth] = i;
                solution(depth + 1);
            }
        }
    }

    static private boolean isPossible(int depth, int row) {
        for (int i = 0; i < depth; i++) {
            if (col[i] == row) return false;
            if (Math.abs(i - depth) == Math.abs(row - col[i])) return false;
        }
        return true;
    }
}
