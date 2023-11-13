/**
 * 백준 동전1 : 2293번
 * start : 2023-11-07 16:52
 * end : 2023-11-07
 * 알고리즘 : DP
 * 1~k까지 입력받은 동전으로 만들 수 있는지 확인하면서 갱신하기
 * 1 2 5가 주어졌다면
 * 1로 1~k까지 만들 수 있는 가짓수 구하기
 * 2로 2~k까지 만들 수 있는 가짓수 구하기
 * 이 때 가짓수는 dp[i] = dp[i] + dp[i-coin] -> coin은 현재 동전
 * 이전 디피랑 지금 디피랑 공존하는 걸 생각해내는 어려운 ㅁ누제 흐긓ㄱ
 */
import java.io.*;
import java.util.*;


public class BJ_2293 {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] val = new int[n];
        int[] dp = new int[k+1];
        dp[0] = 1;

        for (int i = 0 ; i < n ; i++){
            val[i] = Integer.parseInt(bf.readLine());
            for (int j = val[i] ; j <= k ; j++){
                dp[j] += dp[j-val[i]];
            }
        }

        System.out.println(dp[k]);

    }
}
