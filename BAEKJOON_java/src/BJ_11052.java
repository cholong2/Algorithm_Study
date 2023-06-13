/*
백준 11052번 : 카드 구매하기
알고리즘 : DP
start : 2023-06-13 23:18
end : 2023-06-14 00:18
 */
import java.io.*;
import java.util.*;

public class BJ_11052 {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        dp = new int[n+1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1 ; i < n+1 ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1 ; i < n+1 ; i++){
            if (i == 1)
                dp[1] = arr[1];
            else if (i == 2){
                dp[2] =Math.max(dp[1]+arr[1], arr[2]);
            }
            else {
                int m = arr[i];
                for (int j = 1 ; j <= Math.floorDiv(i, 2) ; j++) {
                    m = Math.max(dp[j] + dp[i-j], m);
                }
                dp[i] = m;
            }
        }

        System.out.println(dp[n]);
    }
}
