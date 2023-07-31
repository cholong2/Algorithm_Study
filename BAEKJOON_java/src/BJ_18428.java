/*
백준 18428번 감시 피하기
start : 2023-07-25 14:00
end : 2023-07-26 15:33
알고리즘 : 백트래킹, bfs
한줄평 : 나는 감자당
 */

import java.io.*;
import java.util.*;

public class BJ_18428 {
    static int n, answer, idx = 0;
    static String[][] board;

    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static ArrayList<int[]> student = new ArrayList<>();

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        board = new String[n][n];

        for (int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j < n ; j++) {
                board[i][j] = st.nextToken();
                if (board[i][j].equals("S")){
                    student.add(new int[] {i, j});
                }
            }
        }


    bt(0);
    System.out.println("NO");
    }

    static void bt(int cnt){

        if (cnt == 3)
        {
            bfs();
            return;
        }

        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                if (board[i][j].equals("X")){
                    board[i][j] = "O";
                    bt(cnt+1);
                    board[i][j] = "X";
                }
            }
        }

    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean [][] check = new boolean[n][n];
        String[][] copy = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < n ; j++){
                if (copy[i][j].equals("T"))
                {
                    q.add(new int[] {i,j});
                    check[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()){
            int[] now = q.poll();

            int x = now[0];
            int y = now[1];


            for (int i = 0 ; i < 4 ; i++ ){
                int nx = x + dx[i];
                int ny = y + dy[i];

                while (nx>= 0 && nx < n && ny >= 0 && ny < n ){
                    if (copy[nx][ny] != "O"){
                        check[nx][ny] = true;
                        nx += dx[i];
                        ny += dy[i];
                    }
                    else
                        break;
                }
            }
        }
        if (find(check)){
            System.out.println("YES");
            System.exit(0);
        }
    }

    static boolean find (boolean[][] check){
//        for (int i = 0 ; i < n ; i++){
//            for (int j = 0 ; j < n ; j++){
//                System.out.print(check[i][j] + " ");
//            }
//            System.out.println();
//        }
        for (int[] node : student){
            if (check[node[0]][node[1]]){
                return false;
            }
        }
        return true;
    }
}
