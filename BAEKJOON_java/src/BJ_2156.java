/*
백준 2156번 : 포도주 시식
start : 2023-06-09 15:01
end : 2023-06-09
 */

import java.io.*;
import java.util.*;

public class BJ_2156 {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main (String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(bf.readLine());
    arr = new int[n];
    dp = new int[n];
    for (int i = 0 ; i < n ; i++){
        arr[i] = Integer.parseInt(bf.readLine());
    }

    dp[0] = arr[0];


    for (int i = 1 ; i < n ; i ++){
        if (i == 1) {
            dp[1] = arr[0] + arr[1];
            continue;
        }
        if (i ==2 ) {
            dp[2] = Math.max(dp[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));
            continue;
        }
       dp[i] = Math.max(dp[i-1], Math.max(arr[i]+dp[i-2], arr[i]+arr[i-1]+dp[i-3]));

    }
    System.out.println(dp[n-1]);
    }

}
