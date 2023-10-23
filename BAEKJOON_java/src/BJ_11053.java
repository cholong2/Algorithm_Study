/**
 * start : 2023-10-20 17:00
 * end : 2023-10-20 17:30
 * 알고리즘 : LIS, DP
 * 가장 긴 증가하는 수열 찾기 수열은 그냥 수의 나열이야~ 규칙이 있으면 앞에 붙는거고~
 */
import java.io.*;
import java.util.*;

public class BJ_11053 {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        int answer = 0;
        for (int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < n ; i++){
            dp[i] = 1;

            for (int j = 0 ; j < i ; j++){
                if (arr[j]<arr[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }

//            for (int num : dp)
//                System.out.print(num+" ");
//
//            System.out.println();
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);

    }
}
