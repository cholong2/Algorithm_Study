/*
백준 11501번 : 주식
start : 2023-06-17 16:06
end : 2023-06-17
참고자료 : https://kangwlgns.tistory.com/18
알고리즘 : 그리디 알고리즘
한줄평 : 답을 int로 해서 틀렸음 long으로 하니까 맞음 왜 why~
 */

import java.io.*;
import java.util.*;
public class BJ_11501 {
    static int t, n;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int max = Integer.MIN_VALUE;
            long answer = 0;
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = n - 1; j >= 0; j--) {
                if (max < arr[j]) {
                    max = arr[j];
                }
                if (max>arr[j]) {
                    answer += (max - arr[j]);
                }
            }
            sb.append(answer).append('\n');

        }
        System.out.println(sb.toString());
    }

}


