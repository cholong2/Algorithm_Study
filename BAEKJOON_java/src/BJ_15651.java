/*
N과M 3
dfs
 */

import java.util.*;
import java.io.*;

public class BJ_15651 {
    static int n, m;
    static boolean[] v;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main (String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v= new boolean[n];
        arr = new int [m];

        dfs(0);
        System.out.print(sb);
    }
    public static void dfs (int depth){
        if (depth == m){
            for (int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0 ; i < n ; i++){
            arr[depth] = i+1;
            dfs(depth+1);
        }
    }
}
