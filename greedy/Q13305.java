package greedy;

// https://www.acmicpc.net/problem/13305
// 주유소

import java.io.*;
import java.util.*;

public class Q13305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] city = new int[N], distance = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0, len = N - 1; i < len; i++) {
            int value = Integer.parseInt(st.nextToken());
            distance[i] = value;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Long.toString(solution(N, distance, city)));
        bw.close();
        br.close();
    }

    static long solution(int N, int[] distance, int[] city) {
        long answer = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0, len = N - 1; i < len; i++) {
            minPrice = Math.min(minPrice, city[i]);
            answer += (long) distance[i] * minPrice;
        }

        return answer;
    }
}
