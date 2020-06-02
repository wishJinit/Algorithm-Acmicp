package two_pointer;

// https://www.acmicpc.net/problem/1806
// 부분합

import java.io.*;
import java.util.*;

public class Q1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int S = parseInt(st.nextToken());
        int max = N+1;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = parseInt(st.nextToken());
        }

        int sum = 0, start = 0, end = 0, result = max;
        while(!(end == N && sum < S)) {
            if(sum < S) sum += arr[end++];
            if(sum >= S) {
                result = min(result, end - start);
                sum -= arr[start++];
            }
        }

        System.out.print(result == max ? 0 : result);
    }

    private static int parseInt(String s){
        return Integer.parseInt(s);
    }
    private static int min(int a, int b){
        return (a < b ? a : b);
    }
}
