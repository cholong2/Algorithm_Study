package Level2;

import java.util.*;

/**
 * 알고리즘 : DP
 */
class 숫자변환하기 {
    static int min = Integer.MAX_VALUE;
    static int[] arr = {2, 3, 0};
    public int solution(int x, int y, int n) {
        int answer = 0;
        int cnt = 0;
        arr[2] = n;
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;

        for (int i = x ; i<= y ; i++){
            if (dp[i] != Integer.MAX_VALUE){
                for (int j = 0 ; j < 3 ; j++){
                    if (j<2 && i*arr[j] <= y){

                        dp[i*arr[j]] = Math.min(dp[i*arr[j]], dp[i]+1);
                        // System.out.println("곱하기~~"+i*arr[j] + " "+ dp[i*arr[j]]);
                    }
                    else if(j == 2 && i+arr[j] <= y){
                        dp[i+arr[j]] = Math.min(dp[i+arr[j]], dp[i]+1);
                        // System.out.println("더하기~"+i+arr[j] + " "+ dp[i+arr[j]]);
                    }
                }
            }
        }

        if (dp[y] == Integer.MAX_VALUE)
            answer = -1;
        else
            answer = dp[y];

        return answer;
    }
}
