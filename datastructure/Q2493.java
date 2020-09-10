package datastructure;

// https://www.acmicpc.net/problem/2493
// 탑

import java.io.*;
import java.util.*;

public class Q2493 {
    static class Top {
        int height, index;

        public Top(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[] tops = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            tops[i] = parseInt(st.nextToken());

        System.out.println(solution(N, tops));
    }

    public static String solution(int N, int[] tops) {
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[N];
        Top[] topsWithIndex = new Top[N];

        for (int i = 0; i < N; i++)
            topsWithIndex[i] = new Top(tops[i], i);

        Stack<Top> stack = new Stack<>();
        stack.push(topsWithIndex[N - 1]);
        for (int i = N - 2; i >= 0; i--) {
            int height = topsWithIndex[i].height, index = topsWithIndex[i].index;
            while (!stack.isEmpty()) {
                Top item = stack.pop();
                if (item.height < height) {
                    answer[item.index] = index + 1;
                } else {
                    stack.push(item);
                    break;
                }
            }
            stack.push(topsWithIndex[i]);
        }

        for (int i = 0; i < N; i++)
            sb.append(answer[i]).append(" ");

        return sb.toString();
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
