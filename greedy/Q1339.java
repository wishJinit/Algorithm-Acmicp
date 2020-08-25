package greedy;

// https://www.acmicpc.net/problem/9084
// 단어 수학

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Q1339 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = br.readLine();
        System.out.println(solution(N, arr));
    }

    public static int solution(int N, String[] arr) {
        int result = 0, max = 0;
        for (int i = 0; i < N; i++) max = Math.max(max, arr[i].length());
        String exp = "";
        for (int i = 0; i < N; i++) {
            arr[i] = String.format("%" + max + "s", arr[i]);
            exp += arr[i] + "+";
        }

        Map<Character, Integer> calMap = new HashMap<>();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < N; j++) {
                char c = arr[j].charAt(i);
                if (c == ' ') continue;
                int value = calMap.getOrDefault(c, 0) + (int) Math.pow(10.0, (max - i));
                calMap.put(c, value);
            }
        }

        ArrayList<String> priority = new ArrayList<>();
        for (Character c : calMap.keySet()) priority.add(calMap.get(c) + "-" + c);
        priority.sort((o1, o2) -> Integer.compare(parseInt(o2.split("-")[0]), parseInt(o1.split("-")[0])));

        int order = 9;
        for (String f : priority) exp = exp.replace(f.split("-")[1].charAt(0), (char) (order-- + '0'));

        for (String s : exp.split("\\+")) result += parseInt(s.trim());
        return result;
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
