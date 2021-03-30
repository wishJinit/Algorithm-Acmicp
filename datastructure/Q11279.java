package datastructure;

// https://www.acmicpc.net/problem/11279
// 최대 힙

import java.io.*;
import java.util.*;

public class Q11279 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
            } else {
                queue.add(x);
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
