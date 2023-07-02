/*
백준 9372번 : 상근이의 여행
start : 2023-06-28 16:37
end : 2023-06-28 17:05
알고리즘 : 그래프 이론

 */

import java.io.*;
import java.util.*;

public class BJ_9372 {
    static int t, n, m;
    static StringBuilder sb = new StringBuilder();
    public static void main (String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());

        for (int i = 0 ; i < t ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[m][2];
            boolean[] node = new boolean[n];
            for (int j = 0 ; j < m ; j++) {
                st = new StringTokenizer(bf.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            if (m>=n)
                sb.append(n-1).append('\n');
            else
                sb.append(m).append('\n');
       }
        System.out.println(sb.toString());
    }


}
