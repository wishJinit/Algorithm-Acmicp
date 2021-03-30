package datastructure;

// https://www.acmicpc.net/problem/11286
// 절댓값 힙

import java.io.*;
import java.util.*;

public class Q11286 {
    private static class Number {
        int value, absoluteValue;

        Number(int value) {
            this.value = value;
            this.absoluteValue = Math.abs(value);
        }
    }

    private static class CustomComparator implements Comparator<Number> {
        @Override
        public int compare(Number o1, Number o2) {
            if (o1.absoluteValue == o2.absoluteValue) {
                return Integer.compare(o1.value, o2.value);
            } else {
                return Integer.compare(o1.absoluteValue, o2.absoluteValue);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Number> queue = new PriorityQueue<>(new CustomComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(queue.isEmpty() ? 0 : queue.poll().value).append("\n");
            } else {
                queue.add(new Number(x));
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
