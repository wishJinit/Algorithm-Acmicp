package simulation;

// https://www.acmicpc.net/problem/1966
// 크로아티아 알파벳

import java.io.*;

public class Q2941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] alphabets = {"c=", "c-", "dz=", "d-", "s=", "z=", "lj", "nj"};
        String str = br.readLine();
        for(int i = 0; i <alphabets.length; i++) {
            str = str.replace(alphabets[i],"a");
        }
        System.out.println(str.length());
    }
}
