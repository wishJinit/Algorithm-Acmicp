package bfs;

// https://www.acmicpc.net/problem/1697
// 숨바꼭질

import java.util.*;
import java.io.*;

public class Q1697 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(solution(N, K)));
        bw.close();
        br.close();
    }

    static int solution(int N, int K) {
        final int LEN = 100_001;

        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[LEN];

        arr[N] = 1;
        queue.add(N);

        while (!queue.isEmpty()) {
            int p = queue.poll();
            int value = arr[p] + 1;

            if (p == K) break;

            if (p - 1 >= 0 && arr[p - 1] == 0) {
                queue.add(p - 1);
                arr[p - 1] = value;
            }

            if (p + 1 < LEN && arr[p + 1] == 0) {
                queue.add(p + 1);
                arr[p + 1] = value;
            }

            if (p * 2 < LEN && arr[p * 2] == 0) {
                queue.add(p * 2);
                arr[p * 2] = value;
            }
        }

        return arr[K] - 1;
    }
}
