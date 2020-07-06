package bs;

// https://www.acmicpc.net/problem/2869
// 달팽이는 올라가고 싶다

import java.io.*;
import java.util.*;

public class Q2869 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = parseInt(st.nextToken());
        int B = parseInt(st.nextToken());
        int V = parseInt(st.nextToken());
        int a = V-B;
        int b = A-B;
        int result = a/b;
        if(a%b!=0) result++;

        System.out.print(result);
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}