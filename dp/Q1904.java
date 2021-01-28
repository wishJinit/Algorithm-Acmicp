package dp;

// https://www.acmicpc.net/problem/1904
// 01타일

import java.io.*;

public class Q1904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int FLAG = 15746;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        arr[0] = arr[1] = 1;
        if (N > 1) {
            for (int i = 2; i <= N; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % FLAG;
            }
        }

        bw.write(Integer.toString(arr[N]));
        br.close();
        bw.close();
    }
}
