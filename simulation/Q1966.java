package simulation;

// https://www.acmicpc.net/problem/1966
// 프린터 큐

import java.io.*;
import java.util.*;

public class Q1966 {
    static class Print {
        int index, importance;

        Print(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Queue<Print> q = new LinkedList<>();
            Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            String[] tmp = br.readLine().split(" ");
            int N = parseInt(tmp[0]), M = parseInt(tmp[1]);
            tmp = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                int num = parseInt(tmp[j]);
                q.add(new Print(j, num));
                priorityQueue.add(num);
            }

            int cnt = 1, order = -1;
            do {
                int importance = priorityQueue.poll();
                for (int j = 0; j < N; j++) {
                    Print print = q.poll();
                    if (print.importance != importance) {
                        q.add(print);
                    } else {
                        if (print.index == M) order = cnt;
                        break;
                    }
                }
                cnt++;
            } while (order == -1);
            sb.append(order).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
