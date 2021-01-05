package two_pointer;

// https://www.acmicpc.net/problem/2003
// 수들의 합 2

import java.io.*;
import java.util.*;

public class Q2003_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = parseInt(st.nextToken());
        }

        bw.write(Integer.toString(solution(N, M, arr)));
        br.close();
        bw.close();
    }

    static int solution(int N, int M, int[] arr) {
        int answer = 0;
        int s = 0, e = 0, sum = 0;
        while (!(e >= N && sum <= M)) {
            if (sum > M) sum -= arr[s++];
            else if (sum < M) sum += arr[e++];
            if (sum == M) answer++;
        }
        return answer;
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
