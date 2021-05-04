package two_pointer;

// https://www.acmicpc.net/problem/3273
// 두 수의 합

import java.io.*;
import java.util.*;

public class Q3273_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(solution(N, arr, x)));
        bw.close();
    }

    static int solution(int N, int[] arr, int x) {
        Arrays.sort(arr);

        int cnt = 0;
        int start = 0, end = N - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum < x) start++;
            else end--;
            if (sum == x) cnt++;
        }

        return cnt;
    }
}
