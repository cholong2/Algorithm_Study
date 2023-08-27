/**
 * start : 2023-08-27 21:06
 * end : 2023-08-27
 * 알고리즘 : 그리디, 정렬
 */

import java.io.*;
import java.util.*;

public class BJ_1946 {
    static int test, n;
    static StringBuilder sb = new StringBuilder();
    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        test = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for (int t = 0 ; t < test ; t++){
            n = Integer.parseInt(bf.readLine());
            int[] arr = new int[n];

            for (int i = 0 ; i < n ; i++)
            {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a-1] = b;
            }
            int cnt = 1;
            int vot = arr[0];

            for (int j = 1 ; j < n ; j++){
                if (vot > arr[j]){
                    cnt++;
                    vot = arr[j];
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
