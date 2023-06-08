/*
백준 : 16918번 봄버맨
start: 2023-06-01 17:57
end: 2023-06-01 20:30
 */
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16918 {

    private static char[][] board;
    private static boolean [][] check;
    private static int r,c,n,s;

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new char[r + 1][c + 1];
        check = new boolean[r + 1][c + 1];
        for (int i = 0; i < r; i++) {
            board[i] = bf.readLine().toCharArray();
        }


        for (int e = 1; e < n+1; e++) {
            //아무것도 안할때 -> 3초전거 폭발
            if (e %2 == 1)
            {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        // o이고 check가 true면 폭발
                        if (check[i][j])
                            boom(i, j);
                    }
                }
            }
            //폭탄설치할때 -> 아무것도 없는 칸에 설치
            if (e % 2 == 0) {
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            // o이면 true로 바꾸기
                            if (board[i][j] == 'O' && !check[i][j]) {
                                check[i][j] = true;
                            }
                            if (board[i][j] == '.') {
                                board[i][j] = 'O';
                                check[i][j] = false;
                            }
                        }
                    }
            }
        }


        for (int i = 0; i < r; i++)
            System.out.println(board[i]);
    }
    public static void boom (int i, int j){

        board[i][j] = '.';
        if (j < c-1)
           board[i][j+1] = '.';

        if (i < r-1)
            board[i+1][j] = '.';

        if (j > 0)
            board[i][j-1] = '.';

        if (i>0)
            board[i-1][j] = '.';

    }
}
