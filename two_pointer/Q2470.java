package two_pointer;

// https://www.acmicpc.net/problem/2470
// 두 용액

import java.io.*;
import java.util.*;

public class Q2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.stream(solution(N, arr))
                .forEach(o -> sb.append(o).append(" "));
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static int[] solution(int N, int[] arr) {
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);

        int start = 0, end = N - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (Math.abs(sum) < min) {
                answer[0] = arr[start];
                answer[1] = arr[end];
                min = Math.abs(sum);
            }
            if (sum < 0) start++;
            else if (sum > 0) end--;
            else {
                start++;
                end--;
            }
        }

        return answer;
    }
}
