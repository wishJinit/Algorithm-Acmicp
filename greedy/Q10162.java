package greedy;

// https://www.acmicpc.net/problem/10162
// 전자레인지

import java.io.*;
import java.util.*;

public class Q10162 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        System.out.println(solution(T));
    }

    public static String solution(int T) {
        if (T % 10 > 0) return "-1";

        int[] timer = {300, 60, 10};
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = timer.length; i < len; i++) {
            int time = timer[i];
            sb.append(T / time).append(" ");
            T %= time;
        }
        return sb.toString();
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
