package simulation;

// https://www.acmicpc.net/problem/2161
// 카드1

import java.io.*;
import java.util.*;

public class Q2161 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        System.out.println(solution(N));
    }

    public static String solution(int N) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) q.add(i);

        boolean isThrow = true;
        while (!q.isEmpty()) {
            int num = q.poll();
            if(isThrow) sb.append(num).append(" ");
            else q.add(num);
            isThrow = !isThrow;
        }

        return sb.toString();
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
