package greedy;

// https://www.acmicpc.net/problem/11047
// 동전 0

import java.io.*;
import java.util.*;

public class Q11047 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(Integer.toString(solution(N, K, arr)));
        br.close();
        bw.close();
    }

    static int solution(int N, int K, int[] arr) {
        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K == 0) break;
            else if (K < arr[i]) continue;
            answer += K / arr[i];
            K %= arr[i];
        }
        return answer;
    }
}
