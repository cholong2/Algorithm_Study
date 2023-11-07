/**
 * 백준 9521번 : LCS
 * start : 2023-11-06 16:55
 * end : 2023-11-06 17:34
 * 알고리즘 : DP
 *       S F A B B B
 *     B 0 0 0 1 1 1
 *     B 0 0 0 1 2 2
 *     B 0 0 0 1 2 3
 *     R 0 0 0 1 2 3
 *     E 0 0 0 1 2 3
 *     G 0 0 0 1 2 3
 * 앞, 뒤, 중간  연결 됐는지 아닌지 
 * 나부터 시작이 더 많은지? 뒤에 붙는게 더 큰지?
 * DP이중 배열로 행 열이 한 문자열이라고 생각 DP돌면서 같은지 다른지 체크 같다면 내 이전 알파벳 비교하는 문자열의 전 문자열에서 +1
 * 다르면 내 전이랑 비교되는 문자열의 전에서 가장 큰값 넣어주긔
 */

import java.io.*;
import java.util.*;

public class BJ_9251 {
    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String arr1 = bf.readLine();
        String arr2 = bf.readLine();
        int n = arr1.length();
        int m = arr2.length();

        int [][] dp = new int[1001][1001];

        for (int i = 1 ; i < n+1 ; i++){
            for (int j = 1 ; j < m+1 ; j++){
                //같으면 내 이전의 알파벳과 비교되는 문자열의 전의 알파벳과의 DP에 +1
                if ( arr1.charAt(i-1) == arr2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                //다를 때 이전의 행과 이전 열과 비교
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
//        for (int i = 0 ; i < n ; i++){
//            for (int j = 0 ; j < m ; j++)
//                System.out.print(dp[i][j]+" ");
//            System.out.println();
//        }

        System.out.println(dp[n][m]);
    }
}
