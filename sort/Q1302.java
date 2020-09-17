package sort;

// https://www.acmicpc.net/problem/1302
// 베스트셀러

import java.io.*;
import java.util.*;

public class Q1302 {
    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }
        List<String> keyList = new ArrayList<>(hashMap.keySet());
        keyList.sort(((o1, o2) -> {
            int value1 = hashMap.get(o1), value2 = hashMap.get(o2);
            if (value1 != value2) return (value1 < value2 ? 1 : -1);
            else return o1.compareTo(o2);
        }));

        System.out.println(keyList.get(0));
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
