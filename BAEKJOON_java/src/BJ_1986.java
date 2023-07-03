/*
백준 1986 : 체스
start : 2023-07-02 14:46
end : 2023-07-03 16:11
알고리즘 : 구현
한줄평 : Arrays.asList.contains 는 만능이 아니다,, boolean은 왜 안될까
다시 찾아보기 꼭꼭
 */

import java.io.*;
import java.util.*;

public class BJ_1986 {
    static int n, m, ans;
    static int[][] chess; //퀸 나이트 폰
    static boolean[][] board;

    static int[] kx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] ky = {2, -2, 1, -1, 2, -2, 1, -1};

    static int[] qx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] qy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = n*m;
        board = new boolean[n][m];
        chess = new int[n][m];

        for (int i = 1; i <= 3 ; i++){
            st = new StringTokenizer(bf.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0 ; j < cnt ; j++){
                int row = Integer.parseInt(st.nextToken())-1;
                int col = Integer.parseInt(st.nextToken())-1;
                board[row][col] = true;
                chess[row][col] = i;
                ans--;
            }
        }

        for (int i = 0 ; i <  n ; i++){
            for (int j =0 ; j < m  ;j++){
             if (chess[i][j] > 0){
                 check(i, j, chess[i][j]);
             }
            }
        }

        System.out.println(ans);
    }

    public static void check(int row, int col, int type){
        //나이트일때
        if (type==2){
            for (int i = 0 ; i < 8 ; i++){
                int dx = kx[i] + row;
                int dy = ky[i] + col;

                if (dx >= 0 && dy >= 0 && dx < n && dy < m && !board[dx][dy]){
                    board[dx][dy] = true;
                    ans--;
                }
            }
        }
        //퀸일때
        else if (type == 1){
            //아래로 2대각선 1세로
            //가로 세로를 먼저봅시다
            String[] v = {"false", "false","false","false","false","false","false","false"};
            int xc = 0;
            int yc = 0;

            //다막힐때까지
            while (Arrays.asList(v).contains("false")){

                xc++;
                yc++;
                for (int i = 0 ; i < 8 ; i++){
                    //아직 안막혔다면
                    if (v[i].equals("false")){
                        int dx = row + qx[i]*xc;
                        int dy = col + qy[i]*yc;

                        //기물이 없다면 범위 체크하고 체크하지 않은 곳이라면 --
                        if (dx < 0 || dy < 0 || dx >= n || dy >= m || chess[dx][dy] >0){
                            v[i] = "true";
                        }
                        else {
                            if (!board[dx][dy]) {
                                board[dx][dy] = true;
                                ans--;
                            }
                        }
                    }
                }
            }

        }
    }
}
