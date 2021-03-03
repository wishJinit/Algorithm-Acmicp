package backtracking;

// https://www.acmicpc.net/problem/15658
// 연산자 끼워넣기 (2)

import java.io.*;
import java.util.*;

public class Q15658 {
    final static int OPERATOR_NUM = 4;
    final static int PLUS = 0;
    final static int MINUS = 1;
    final static int MULTIPLE = 2;
    final static int DIVIDER = 3;

    static int N;
    static int[] num;
    static int[] operator = new int[OPERATOR_NUM];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < OPERATOR_NUM; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        solution(num[0], 1);
        bw.write(String.format("%d\n%d", max, min));
        bw.close();
        br.close();
    }

    static void solution(int sum, int depth) {
        if (N == depth) {
            if (max == Integer.MIN_VALUE) max = sum;
            else max = Math.max(sum, max);
            if (min == Integer.MAX_VALUE) min = sum;
            else min = Math.min(sum, min);
            return;
        }

        for (int i = 0; i < OPERATOR_NUM; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                int copySum = sum;
                switch (i) {
                    case PLUS:
                        copySum += num[depth];
                        break;
                    case MINUS:
                        copySum -= num[depth];
                        break;
                    case MULTIPLE:
                        copySum *= num[depth];
                        break;
                    case DIVIDER:
                        copySum /= num[depth];
                        break;
                }
                solution(copySum, depth + 1);
                operator[i]++;
            }
        }
    }
}
