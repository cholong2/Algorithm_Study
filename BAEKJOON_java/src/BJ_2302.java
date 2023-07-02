/*
백준 2302번 : 극장 좌석
start : 2023-06-21 12:13
end : 2023-06-21
알고리즘 : DP
한줄평 : 이게 왜 dp ..? 난 감자야...
 */
import java.io.*;
import java.util.*;

/*
vip는 무조건 자기자리만
일반은 자기자리 +-1
모든 가짓수 구하기 완탐
bfs dfs
말도 안돼 dp라니
왜 3부터 하면 안되지..? 2부터 시작해야 되넴 흠
 */

public class BJ_2302 {
    static int n, m, answer;
    static int[] dp;
    static Set<Integer> set = new HashSet<>();

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        dp = new int[n+1];
        for (int i = 0 ; i < m ; i++){
            set.add(Integer.parseInt(bf.readLine()));
        }

        dp[0]= 1;
        dp[1] = 1;

        for (int i = 2; i<=n ; i++){
            if (set.contains(i)||set.contains(i-1)){
                dp[i] = dp[i-1];
            }
            else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        System.out.println(dp[n]);
    }

}
