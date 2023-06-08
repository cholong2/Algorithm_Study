// 백준 13460: 구슬 탈출2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13460 {
    private static int n, m;

    public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    String[][] board = new String[n][m];

    for (int i = 0; i < n ; i ++){
        for (int j = 0 ; j < m ; j++){
            board[i][j] = st.nextToken();
        }
    }
    }


}
