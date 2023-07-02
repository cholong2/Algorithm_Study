/*
백준 1965번 : 상자넣기
start : 2023-06-30 17:41
end : 2023-06-30 16:22
알고리즘 : DP
한줄평 : LIS는 최장증가수열 찾기 연속되지 않아도 될때 증가하는 수열을 찾는거임
dp는 1로 초기화 하고 이전의 값들 중 나보다 값이 작으면 증가할 수 있는거니까 dp[내순서]랑 dp[값 작은애]+1이랑 비교해서 가장 큰값 찾는거임
 */

import java.io.*;
import java.util.*;

public class BJ_1965 {
    static int n, max = Integer.MIN_VALUE;
    static int[] arr, dp;

    static Stack<Integer> stack = new Stack<>();

    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < n ; i++){
           dp[i] = 1;
           for (int j =0 ; j<i ; j++){
                if (arr[j] < arr[i])
                {
                    dp[i] = Math.max (dp[i], dp[j]+1);
                }

               max = Math.max(max, dp[i]);           }
        }

        System.out.println(max);
    }

}
