/*
백준 15663번 : N과 M (9)
알고리즘 : 백트래킹, DFS
start : 2023-06-14 00:21
end : 2023-06-14
end :
 */
import java.io.*;
import java.util.*;
public class BJ_15663 {
    static int n, m;
    static int[] arr,result;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        v = new boolean[n];
        result = new int[m];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0 ; i < n ; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 정렬
        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb.toString());
    }
    public static void dfs (int depth){
        if (depth == m)
        {
           for (int var : result){
               sb.append(var).append(" ");
           }
            sb.append('\n');
           return;
        }
        int temp = 0;
        for (int i = 0 ; i < n ; i++){
            if (v[i])
                   continue;
            if (temp!=arr[i]){
                result[depth] = arr[i];
                v[i] = true;
                temp = arr[i];
                dfs(depth+1);
                v[i] = false;

            }
        }
    }

}
