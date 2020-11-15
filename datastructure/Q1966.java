package datastructure;

// https://www.acmicpc.net/problem/1966
// 프린터 큐

import java.util.*;
import java.io.*;

public class Q1966 {
    static class Print {
        int index, priority;

        Print(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());

            int[] printers = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                printers[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(solution(printers, M)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int solution(int[] printers, int M) {
        Queue<Print> queue = new LinkedList<>();
        int size = printers.length, index = size - 1, answer = 0;

        for (int i = 0; i < size; i++) {
            queue.add(new Print(i, printers[i]));
        }

        Arrays.sort(printers);

        while (!queue.isEmpty()) {
            int priority = printers[index--];
            answer++;
            do {
                Print p = queue.poll();
                if (priority == p.priority) {
                    if (p.index == M) return answer;
                    break;
                } else {
                    queue.add(p);
                }
            } while (!queue.isEmpty());
        }
        return answer;
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
