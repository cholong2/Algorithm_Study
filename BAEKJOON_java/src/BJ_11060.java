/*
백준 11060번: 점프점프 DP
start : 2023-05-01 17:28
end : 2023-05-01
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11060 {

    public static int n;
    public static int[] dp, map;
    public static void main (String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n];
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0 ; i < n ; i ++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 0;
        for (int i = 0 ; i < n ; i ++)
        {   if (dp[i]!=Integer.MAX_VALUE) {
            int jump  = map[i];
            for (int j = 1; j <= jump; j++) {
                //인덱스가 n을 벗어나지 않게
                if (i + j > n-1)
                    continue;

                dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);

            }
        }
        }


        if (dp[n-1]==Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[n-1]);
    }
}
