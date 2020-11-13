package datastructure;

// https://www.acmicpc.net/problem/9012
// 괄호

import java.util.*;
import java.io.*;

public class Q9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(solution(br.readLine())).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            stack.add(c);
        }
        return (stack.isEmpty() ? "YES" : "NO");
    }
}
