/*
백준 10844번: 쉬운 계단 수
start : 2023-07-04 14:35
end : 2023-07-04 15:58
알고리즘 : DP
한줄 평 :(A+B)%DIV = (A%DIV+B%DIV)%DIV 기억해보도록하자!
 */

import java.util.*;
import java.io.*;

public class BJ_10844 {
    static int n;
    static int[][] dp;

    public static void main (String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int DIV =  1000000000;

        n = Integer.parseInt(bf.readLine());
        dp = new int[n][10];
        dp[0] = new int[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 1 ; i < n ; i++){
            for (int j = 0 ; j < 10 ; j++){
                dp[i][j] += ((j>0 ? dp[i-1][j-1] : 0) + (j < 9 ? dp[i-1][j+1]:0))%DIV;
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n - 1][i]) % DIV;
        }

        System.out.println(sum);
    }
}
