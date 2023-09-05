import java.util.*;
import java.io.*;

/**
 * start : 2023-09-04 09:49
 * end : 2023-09-05 17:00
 * 알고리즘 : 분할정복, 재귀
 * 입력 1000
 * 종이가 다 같은 숫자인지 확인
 * 아니라면 자르기 n/3으로
 * 자른거 첫번째부터 시작?
 */
public class BJ_1780 {
    static int n = 0;
    static int[][] board;
    static boolean v;
    static int ans1 = 0, ans2 = 0, ans3 = 0;

    public static void main (String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        board = new int[n][n];

        for (int i = 0 ; i < n ; i ++)
        {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j < n ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0, 0, n);

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }


    //종이가 모두 같은 수로 되어 있는지 확인
    public static void check(int x, int y, int num) {

        int start = board[x][y];
        boolean flag = true;
        // 같지 않을 때
        for (int i = x; i < x + num; i++) {
            for (int j = y; j < y + num; j++) {
                if (start != board[i][j]) {
                    //9등분 자르기
                    for (int k = x; k < x+num; k += num / 3) {
                        for (int z = y; z < y+num; z += num / 3) {
                            check(k, z, num / 3);
                        }
                    }
                return;
                }

            }
        }


        if (start == -1)
            ans1++;
        else if (start == 0)
            ans2++;
        else
            ans3++;


    }
}
