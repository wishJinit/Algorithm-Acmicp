package datastructure;

// https://www.acmicpc.net/problem/2493
// 탑

import java.io.*;
import java.util.*;

public class Q2493_2 {
    static class Top {
        int index, height;

        Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arr));
    }

    static String solution(int N, int[] arr) {
        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            Top top = new Top(i + 1, arr[i]);
            while (!stack.isEmpty()) {
                Top popTop = stack.pop();
                if (popTop.height >= top.height) {
                    stack.add(popTop);
                    sb.append(popTop.index).append(" ");
                    break;
                }
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.add(top);
        }

        return sb.toString();
    }
}
