/*
백준 : 14500번 테트로미노
알고리즘 : 브루트포스, 백트래킹, dfs
문제 : 칸마다 수가 적힌 보드가 주어졌을때 테트리스를 어케 해야 합이 최댓값일까

시간 : 2초
start : 2023-06-06 14:20
end : 2023-06-07 16:30
 */
import java.io.*;
import java.util.*;

public class BJ_14500 {
    static int n, m, max;
    static boolean[][] v;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ex[][] = {{0, 0, 0, 1}, {0, 0, 0, -1}, {0, 1, 2, 1}, {0, 1, 2, 1}};
    static int ey[][] = {{0, 1, 2, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, 0, 0, 1}};
    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer (bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        v = new boolean[n][m];
        max= 0;

        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j < m ; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < m ; j++){
                if (!v[i][j])
                {
                    v[i][j] = true;
                    check(i, j);
                    dfs(i, j, board[i][j], 1);
                    v[i][j] = false;
                }
            }
        }
        System.out.println(max);
    }
    public static void dfs (int row, int col, int sum, int cnt){
        if (cnt >= 4){
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0 ; i < 4 ; i++){
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !v[nx][ny]){
                v[nx][ny] = true;
                dfs(nx, ny, sum+board[nx][ny], cnt+1);
                v[nx][ny] = false;
            }

        }
    }

    public static void check(int row, int col){
       int nx, ny;
       for (int i = 0 ; i < 4 ; i++){
           int sum = 0;
           boolean isOut = false;
           for (int j = 0 ; j<4 ; j++){
               nx = row + ex[i][j];
               ny = col + ey[i][j];
               if (nx < 0 || ny <0 || nx >= n || ny >=m  )
               {
                   isOut = true;
                   break;
               }
               else {
                   sum +=board[nx][ny];
               }
           }
           if (!isOut){
               max = Math.max(max, sum);
           }
       }
    }

}
