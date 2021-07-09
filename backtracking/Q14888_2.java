package backtracking;

// https://www.acmicpc.net/problem/14888
// 연산자 끼워넣기

import java.io.*;
import java.util.*;

public class Q14888_2 {
    private final static int OPERATOR_LEN = 4;
    private static final int[] operator = new int[OPERATOR_LEN];

    private final static int PLUS = 0;
    private final static int MINUS = 1;
    private final static int MULTIPLE = 2;
    private final static int DIVIDE = 3;

    private static int N;
    private static int[] arr;

    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < OPERATOR_LEN; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        bw.write(String.format("%d\n%d", max, min));
        bw.close();
    }

    private static void dfs(int sum, int depth) {
        if (depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < OPERATOR_LEN; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                dfs(calculate(i, depth, sum), depth + 1);
                operator[i]++;
            }
        }
    }

    private static int calculate(int idx, int deep, int sum) {
        switch (idx) {
            case PLUS:
                sum += arr[deep];
                break;
            case MINUS:
                sum -= arr[deep];
                break;
            case MULTIPLE:
                sum *= arr[deep];
                break;
            case DIVIDE:
                sum /= arr[deep];
                break;
        }
        return sum;
    }
}
