/*
백준 2630번 : 색종이 만들기
start: 2023-06-21 15:41
end : 2023-06-21 16:03
알고리즘 : 분할정복, 재귀
한줄 평 : 쏘이지
 */

import java.io.*;
import java.util.*;
public class BJ_2630 {
    static int n;
    static int[][] paper;
    static int[] ans = new int[2];

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        paper = new int[n][n];
        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j < n ; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, n);

        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
    public static void cut (int row, int col, int num){
        int check = paper[row][col];
        for (int i = row ; i < row+num ; i ++){
            for (int j = col ; j < col+num ; j++){
                if (paper[i][j]!=check) {
                    int div = num/2;
                    cut(row, col, div);
                    cut(row+div, col, div);
                    cut(row, col+div, div);
                    cut(row+div, col+div, div);
                    return;
                }

            }
        }
        ans[check]++;
    }
}
