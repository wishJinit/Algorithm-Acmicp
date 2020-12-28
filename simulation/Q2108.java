package simulation;

// https://www.acmicpc.net/problem/2108
// 통계학

import java.io.*;
import java.util.*;

public class Q2108 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(solution(N, arr)).forEach(o -> sb.append(o).append("\n"));
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static int[] solution(int N, int[] arr) {
        int[] answer = new int[4]; // 0: 산술평균, 1: 중앙값, 2: 최빈값, 3: 범위
        Arrays.sort(arr);

        answer[1] = arr[N / 2];
        answer[3] = Math.abs(arr[0] - arr[N - 1]);

        Map<Integer, Integer> map = new HashMap<>();
        double sum = 0;
        for (int num : arr) {
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        answer[0] = (int) Math.round(sum / N);
        answer[2] = getModeValue(map);

        return answer;
    }

    private static int getModeValue(Map<Integer, Integer> map) {
        int modeCnt = map
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .get().getValue();
        int[] maxValues = map
                .entrySet()
                .stream()
                .filter(o -> o.getValue() == modeCnt)
                .mapToInt(Map.Entry::getKey)
                .toArray();

        Arrays.sort(maxValues);
        return maxValues[(maxValues.length > 1 ? 1 : 0)];
    }
}
