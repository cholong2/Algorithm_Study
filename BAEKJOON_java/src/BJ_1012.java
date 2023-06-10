/*
백준 1012번: 유기농배추
start : 2023-06-10 19:30
end : 2023-06-10 20:06
 */
import java.io.*;
import java.util.*;

public class BJ_1012 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board;
    static boolean[][] v;
    static int[] result;
    static int t, n, m, k;

    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        t = Integer.parseInt(st.nextToken());
        result = new int[t];
        for (int i = 0 ; i < t ; i++){
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            board = new int[n][m];
            v = new boolean[n][m];
            for (int j = 0 ; j <k ; j++){
               st = new StringTokenizer(bf.readLine());
               int tx = Integer.parseInt(st.nextToken());
               int ty = Integer.parseInt(st.nextToken());
               board[tx][ty] = 1;
            }

            for (int row=0; row <n ; row++){
                for (int col =0; col < m ; col++){
                    if (board[row][col]==1 && !v[row][col]){
                        v[row][col] = true;
                        dfs(row, col);
                        result[i]++;
                    }
                }
            }
            System.out.println(result[i]);
        }


    }
    public static void dfs(int x, int y){
        for (int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >=0 && nx <n && ny <m && !v[nx][ny] && board[nx][ny]==1){
                v[nx][ny] = true;
                dfs(nx,ny);
            }
        }
    }

}
