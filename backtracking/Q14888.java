package backtracking;

// https://www.acmicpc.net/problem/14888
// 연산자 끼워넣기

import java.io.*;
import java.util.*;

public class Q14888 {
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
        bw.write(String.format("%d %d", max, min));
        bw.close();
        br.close();
    }

    static void solution(int sum, int depth) {
        if (depth == N) {
            max = (max == Integer.MIN_VALUE ? sum : Math.max(max, sum));
            min = (min == Integer.MAX_VALUE ? sum : Math.min(min, sum));
        }

        for (int i = 0; i < OPERATOR_NUM; i++) {
            if (operator[i] == 0) continue;
            operator[i]--;
            int sumCopy = sum;
            switch (i) {
                case PLUS:
                    sumCopy += num[depth];
                    break;
                case MINUS:
                    sumCopy -= num[depth];
                    break;
                case MULTIPLE:
                    sumCopy *= num[depth];
                    break;
                case DIVIDER:
                    sumCopy /= num[depth];
                    break;
            }
            solution(sumCopy, depth + 1);
            operator[i]++;
        }
    }
}
