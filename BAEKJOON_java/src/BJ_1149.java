/*
백준 1149번 : RGB거리
start : 2023-06-29 15:30
end :2023-06-29 15:59
알고리즘 : DP
한줄평 : 완탐인줄 ㅎㅎ;;
 */

import java.util.*;
import java.io.*;

public class BJ_1149 {
    static int n, ans;
    static int[][] dp, rgb;

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        dp = new int[n][3];
        rgb = new int[n][3];
        ans = Integer.MAX_VALUE;
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0  ; j < 3 ; j++)
                rgb[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < 3 ; j++){
                if (i == 0)
                    dp[i][j] = rgb[i][j];
                else{
                    int min = Integer.MAX_VALUE;
                       for (int k = 0 ; k < 3 ; k++){
                           if (j!=k) {
                               min = Math.min(min, rgb[i][j]+dp[i-1][k]);
                           }
                       }
                    dp[i][j]=min;
                }
            }
        }

        for (int i = 0 ; i < 3 ; i++)
            ans = Math.min(ans, dp[n-1][i]);

        System.out.println(ans);
    }
}
