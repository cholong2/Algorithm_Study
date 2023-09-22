import java.io.*;
import java.util.*;

/**
 * start : 2023-09-16 12:30
 * end : 2023-09-16 13:20
 * 알고리즘  : DFS
 * 카운팅은 전역변수로 해서 그냥 해버리기~
 */
public class BJ_2667 {
    static int n;
    static char[][] board;
    static boolean[][] v;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cnt = 0;
    public static void main (String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        board = new char[n][n];
        v = new boolean[n][n];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0 ; i < n ; i++){
            String temp = bf.readLine();
            for (int j = 0 ; j < n ; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0 ; i < n ;i++){
            for (int j = 0 ; j < n ; j++){
                if (board[i][j] == '1' && !v[i][j]){
                    cnt = 0;
                    dfs(i, j);
                    arr.add(cnt);
                }
            }
        }


        System.out.println(arr.size());
        arr.sort((o1, o2) -> o1-o2);
        for (int temp : arr)
            System.out.println(temp);
    }
    public static void dfs (int r, int c){
        v[r][c] = true;
        cnt++;
        for (int i = 0 ; i < 4 ; i++){
            int nx = r + dx[i];
            int ny = c + dy[i];

            if(nx >=0 && ny >=0 && nx <n && ny <n && board[nx][ny]=='1' && !v[nx][ny]){
                dfs(nx, ny);
            }
        }
    }

}
