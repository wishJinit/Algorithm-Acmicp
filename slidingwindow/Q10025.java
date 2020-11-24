package slidingwindow;

// https://www.acmicpc.net/problem/10025
// 게으른 백곰

import java.io.*;
import java.util.*;

public class Q10025 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(K, arr));
    }

    static int solution(int K, int[][] arr) {
        Arrays.sort(arr, (Comparator.comparingInt(o -> o[1])));
        int icesLen = arr[arr.length - 1][1], scope = K * 2 + 1;

        if (scope >= icesLen) {
            return Arrays.stream(arr).mapToInt(i -> i[0]).sum();
        }

        int[] ices = new int[icesLen + 1];
        Arrays.stream(arr).forEach(i -> ices[i[1]] = i[0]);
        int sum = Arrays.stream(ices, 0, scope).sum(), answer = sum;

        for (int i = (int) Math.ceil(scope / 2f); i < icesLen - K; i++) {
            sum += ices[i + K];
            sum -= ices[i - K - 1];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
