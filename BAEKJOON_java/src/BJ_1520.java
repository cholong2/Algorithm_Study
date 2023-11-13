/**
 * 백준 1520번 : 내리막길
 * start : 2023-11-13 14:54
 * end : 2023-11-13 15:40
 * 알고리즘 : DFS + DP
 * 한줄평 : 1트 시간초과
 * 그냥 dp로 하면 4^(500*500) 라서 시간초과 나옴
 * dp랑 콜라보레이션해서 풀어야함
 * 경로를 기록하면서 푸는거임~
 */
import java.io.*;
import java.util.*;

public class BJ_1520 {
    static int n, m, cnt;
    static int[][] board;
    static int[][] dp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dp = new int[n][m];

        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j < m ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dfs(0, 0);
        System.out.println(dp[0][0]);
    }
    public static int dfs (int x, int y){
        if (x == n-1 && y == m-1){
           return 1;
        }

        dp[x][y] = 0;

        for (int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >=0 && ny >= 0 && nx<n && ny <m && board[nx][ny] < board[x][y]){
                if (dp[nx][ny] !=-1) dp[x][y] += dp[nx][ny];
                else dp[x][y] += dfs(nx,ny);
            }
        }
        return dp[x][y];
    }
}










