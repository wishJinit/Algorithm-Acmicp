package sort;

// https://www.acmicpc.net/problem/1181
// 단어 정렬

import java.io.*;
import java.util.*;

public class Q1181 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(solution(arr)).forEach(o -> sb.append(o).append("\n"));

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static String[] solution(String[] arr) {
        return new HashSet<>(Arrays.asList(arr)).stream().sorted((o1, o2) -> {
            int len1 = o1.length(), len2 = o2.length();
            if (len1 != len2) return Integer.compare(len1, len2);
            else return o1.compareTo(o2);
        }).toArray(String[]::new);
    }
}
