package binary_search;

// https://www.acmicpc.net/problem/10816
// 숫자 카드 2

import java.io.*;
import java.util.*;

public class Q10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(solution(N, card, M, arr)).forEach(o -> sb.append(o).append(" "));
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int[] solution(int N, int[] card, int M, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int c : card) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Integer[] cardNum = map.keySet().toArray(Integer[]::new);
        final int LENGTH = cardNum.length;
        int[] answer = new int[M];
        Arrays.sort(cardNum);

        for (int i = 0; i < M; i++) {
            int value = arr[i];
            int start = 0, end = LENGTH - 1;
            while (start <= end) {
                int mid = (end - start) / 2 + start;
                if (cardNum[mid] < value) {
                    start = mid + 1;
                } else if (cardNum[mid] > value) {
                    end = mid - 1;
                } else {
                    answer[i] = map.get(value);
                    break;
                }
            }
        }

        return answer;
    }
}
