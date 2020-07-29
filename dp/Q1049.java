package dp;

// https://www.acmicpc.net/problem/1049
// 기타줄

import java.io.*;
import java.util.*;

public class Q1049 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());

        int minPackage = Integer.MAX_VALUE, minSingle = Integer.MAX_VALUE, price = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minPackage = Math.min(minPackage, parseInt(st.nextToken()));
            minSingle = Math.min(minSingle, parseInt(st.nextToken()));
        }

        int a = N / 6, b = N % 6;
        price = Math.min(minPackage * (a + 1), Math.min(minPackage * a + minSingle * b, minSingle * N));
        System.out.println(price);
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}