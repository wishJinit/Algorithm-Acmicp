package two_pointer;

// https://www.acmicpc.net/problem/2003
// 수들의 합 2

import java.util.*;
import java.io.*;

public class Q2003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int start = 0, end = 0, sum = 0, cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        while(true) {
            if(sum < M) sum += arr[end++];
            else if (sum > M) sum -= arr[start++];
            else {
                sum += arr[end++];
                sum -= arr[start++];
            }
            if(sum == M) cnt++;
            if(end == N && sum <= M) break;
        }
        System.out.print(cnt);
    }
}
