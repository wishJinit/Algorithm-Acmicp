package math;

// https://www.acmicpc.net/problem/2981
// 검문

import java.io.*;
import java.util.*;

public class Q2981 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        solution(N, arr).forEach(o -> sb.append(o).append(" "));
        bw.write(sb.toString());
        bw.close();
    }

    static List<Integer> solution(int N, int[] arr) {
        Arrays.sort(arr);

        int value = arr[1] - arr[0];
        for (int i = 2; i < N; i++) {
            value = gcd(value, arr[i] - arr[i - 1]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= value; i++) {
            if (value % i == 0) list.add(i);
        }

        return list;
    }

    private static int gcd(int a, int b) {
        if (a == 0) return b;
        else if (b == 0) return a;
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
