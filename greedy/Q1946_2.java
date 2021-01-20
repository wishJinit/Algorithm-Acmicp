package greedy;

// https://www.acmicpc.net/problem/1946
// 신입 사원

import java.io.*;
import java.util.*;

public class Q1946_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            sb.append(solution(N, arr)).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static int solution(int N, int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int answer = 1;
        int min = arr[0][1];
        for (int i = 1; i < N; i++) {
            if (arr[i][1] < min) {
                answer++;
                min = arr[i][1];
            }
        }
        return answer;
    }
}
