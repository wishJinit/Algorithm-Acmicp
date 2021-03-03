package backtracking;

// https://www.acmicpc.net/problem/15659
// 연산자 끼워넣기 (3)

import java.io.*;
import java.util.*;

public class Q15659 {
    final static int OPERATOR_NUM = 4;
    final static int PLUS = 0;
    final static int MINUS = 1;
    final static int MULTIPLE = 2;
    final static int DIVIDER = 3;

    static int N;
    static int[] num;
    static int[] operator = new int[OPERATOR_NUM];
    static int[] currentOperator;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        currentOperator = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < OPERATOR_NUM; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        solution();
        bw.write(String.format("%d\n%d", max, min));
        bw.close();
        br.close();
    }

    static void solution() {
        createExp(0);
    }

    private static void createExp(int depth) {
        if (depth == N - 1) {
            calculate();
            return;
        }

        for (int i = 0; i < OPERATOR_NUM; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                currentOperator[depth] = i;
                createExp(depth + 1);
                operator[i]++;
            }
        }
    }

    private static void calculate() {
        Deque<Integer> numQueue = new LinkedList<>();
        Deque<Integer> operatorQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            numQueue.add(num[i]);
        }

        for (int i = 0; i < N - 1; i++) {
            operatorQueue.add(currentOperator[i]);
        }

        for (int i = 0; i < N - 1; i++) {
            int n = numQueue.poll();
            int o = operatorQueue.poll();
            if (o == MULTIPLE || o == DIVIDER) {
                int n2 = numQueue.poll();
                int copyN = n;

                if (o == MULTIPLE) copyN *= n2;
                else copyN /= n2;

                if (i == N - 2) numQueue.add(copyN);
                else numQueue.addFirst(copyN);
            } else {
                numQueue.add(n);
                operatorQueue.add(o);
                if (i == N - 2) numQueue.add(numQueue.poll());
            }
        }

        int sum = numQueue.poll();
        int size = operatorQueue.size();
        for (int i = 0; i < size; i++) {
            int o = operatorQueue.poll();
            int n = numQueue.poll();
            if (o == PLUS) sum += n;
            else sum -= n;
        }

        if (max == Integer.MIN_VALUE) max = sum;
        else max = Math.max(sum, max);
        if (min == Integer.MAX_VALUE) min = sum;
        else min = Math.min(sum, min);
    }
}
