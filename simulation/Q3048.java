package simulation;

// https://www.acmicpc.net/problem/3048
// 개미

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3048 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len1 = parseInt(st.nextToken()), len2 = parseInt(st.nextToken());
        String str1 = br.readLine(), str2 = br.readLine();
        int T = parseInt(br.readLine());

        System.out.println(solution(len1, len2, str1, str2, T));
    }

    public static String solution(int len1, int len2, String str1, String str2, int T) {
        StringBuilder sb = new StringBuilder();
        str1 = new StringBuilder(str1).reverse().toString();
        int total = len1 + len2 - 1;

        if (total <= T) {
            sb.append(str2).append(str1);
        } else if (len1 > T) {
            for (int i = 0; i < len1 - T; i++) {
                sb.append(str1.charAt(i));
            }
            for (int i = 0; i < Math.min(T, len2); i++) {
                sb.append(str2.charAt(i));
                sb.append(str1.charAt(i + (len1 - T)));
            }
            for (int i = len1 - T + Math.min(T, len2); i < len1; i++) {
                sb.append(str1.charAt(i));
            }
            for (int i = Math.min(T, len2); i < len2; i++) {
                sb.append(str2.charAt(i));
            }
        } else {
            for (int i = 0; i <= T - len1; i++) {
                sb.append(str2.charAt(i));
            }
            for (int i = 0; i < Math.min(total - T, len1); i++) {
                sb.append(str1.charAt(i));
                sb.append(str2.charAt(i + (T - len1 + 1)));
            }
            for (int i = T - len1 + 1 + Math.min(total - T, len1); i < len2; i++) {
                sb.append(str2.charAt(i));
            }
            for (int i = Math.min(total - T, len1); i < len1; i++) {
                sb.append(str1.charAt(i));
            }
        }
        return sb.toString();
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}