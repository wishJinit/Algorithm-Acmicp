package sort;

// https://www.acmicpc.net/problem/1715
// 카드 정렬하기

import java.io.*;
import java.util.*;

public class Q1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Long> queue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write("0");
            bw.close();
            return;
        }

        for (int i = 0; i < N; i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        long answer = 0;
        while (queue.size() > 1) {
            long a = queue.poll(), b = queue.poll();
            long sum = a + b;
            queue.add(sum);
            answer += sum;
        }

        bw.write(Long.toString(answer == 0 ? queue.poll() : answer));
        bw.close();
    }
}
