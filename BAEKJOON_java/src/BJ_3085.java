/*
백준 3085번 : 사탕게임
start : 2023-06-29 15:59
end : 2023-06-29 16:45
한줄평 : 인덱스 제대로 보자 좀!!!!
알고리즘 : 완전탐색
 */
import java.io.*;
import java.util.*;
public class BJ_3085 {
    static int n, max = 0;
    static String[][] board;
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        board = new String[n][n];

        for (int i= 0 ; i < n ; i++){
            String temp = bf.readLine();
            board[i] = temp.split("");
        }

        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j< n ; j++){

                //아래 스왑
                if (i < n-1 && !board[i][j].equals(board[i+1][j])){
                    String temp = board[i][j];
                    board[i][j] = board[i+1][j];
                    board[i+1][j] = temp;
                    count();
                    board[i+1][j] = board[i][j];
                    board[i][j] = temp;
                }
                String temp2[][] = board.clone();
                //오른쪽 스왑
                if (j < n-1 && !board[i][j].equals(board[i][j+1])){
                    String temp = board[i][j];
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = temp;
                    count();
                    board[i][j+1] = board[i][j];
                    board[i][j] = temp;
                }
            }
        }
        System.out.println(max);
    }
    public static void count(){

        for (int i = 0 ; i < n; i ++) {
            int count = 1;

            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }

        // 열에서 긴 수열 탐색
        for (int i = 0 ; i < n; i ++) {
            int count = 1;

            for (int j = 0; j < n - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }

    }

}
