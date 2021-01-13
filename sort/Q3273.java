package sort;

// https://www.acmicpc.net/problem/3273
// 두 수의 합

import java.io.*;
import java.util.*;

public class Q3273 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int T = Integer.parseInt(br.readLine());
        bw.write(Integer.toString(solution(N, T, arr)));
        br.close();
        bw.close();
    }

    static int solution(int N, int T, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = arr[i] + arr[j];
                if (sum == T) answer++;
                if (sum >= T) break;
            }
        }

        return answer;
    }
}
