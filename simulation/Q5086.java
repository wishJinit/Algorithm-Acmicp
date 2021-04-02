package simulation;

// https://www.acmicpc.net/problem/5086
// 배수와 약수

import java.io.*;
import java.util.*;

public class Q5086 {
    private static final String FACTOR = "factor";
    private static final String MULTIPLE = "multiple";
    private static final String NEITHER = "neither";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;

            sb.append(solution(a, b)).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    static String solution(int a, int b) {
        if (b % a == 0) return FACTOR;
        else if (a % b == 0) return MULTIPLE;
        return NEITHER;
    }
}
