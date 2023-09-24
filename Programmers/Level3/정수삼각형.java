package Level3;

import java.util.*;
/*
 * start : 2023-09-15 16:13
 * end : 2023-09-15 16:42
 * 알고리즘 : DP 
 */
class 정수삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int m = triangle[n-1].length;

        int dp[][] = new int[n][m];
        dp[0][0] = triangle[0][0];


        for (int i = 1 ; i < n ; i++){
            for (int j = 0 ; j < triangle[i].length ; j++){
                //위칸에서 -1, 바로 위 비교
                if (j>0){
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
            }
        }
        for (int i = 0 ; i < n ; i++){
            answer = Math.max(dp[n-1][i], answer);
        }
        return answer;
    }
}
