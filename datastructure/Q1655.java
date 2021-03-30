package datastructure;

// https://www.acmicpc.net/problem/1655
// 가운데를 말해요

import java.io.*;
import java.util.*;

public class Q1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> ascendingQueue = new PriorityQueue<>();
        Queue<Integer> descendingQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (ascendingQueue.size() == descendingQueue.size()) descendingQueue.add(value);
            else ascendingQueue.add(value);

            if (!ascendingQueue.isEmpty() && !descendingQueue.isEmpty()) {
                if (ascendingQueue.peek() < descendingQueue.peek()) {
                    int temp = descendingQueue.poll();
                    descendingQueue.add(ascendingQueue.poll());
                    ascendingQueue.add(temp);
                }
            }

            sb.append(descendingQueue.peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
