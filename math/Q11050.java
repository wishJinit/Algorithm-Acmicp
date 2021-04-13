package math;

// https://www.acmicpc.net/problem/11050
// 이항 계수 1

import java.io.*;
import java.util.*;

public class Q11050 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(solution(N, K)));
        bw.close();
    }

    static int solution(int N, int K) {
        int diff = N - K;
        int NFac = 1, KFac = 1, diffFac = 1;
        for (int i = 2; i <= N; i++) {
            NFac *= i;
            if (K == i) KFac = NFac;
            if (diff == i) diffFac = NFac;
        }

        return NFac / (KFac * diffFac);
    }
}
