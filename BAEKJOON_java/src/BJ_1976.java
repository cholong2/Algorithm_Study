/*
백준 1976번 : 여행가자
start : 2023-07-26 15:36
end : 2023-07-26
알고리즘 : union-find or bfs / union-find가 메모리나 시간적으로 더 효율적
한줄평 :
 */

import java.io.*;
import java.util.*;


public class BJ_1976 {
    static int n, m, ans=0;
    static int[][] g;
    static int[] target;
    static  Queue<Integer> q = new LinkedList<>();

    public static void main (String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        g = new int[n][n];

        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j<n ; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());

        target = new int[m];
        for (int i = 0 ; i < m ; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        bfs(ans);

        System.out.println("NO" + ans);
    }

    public static void bfs(int idx) {
        q.clear();

        if (idx == m-1){
            System.out.println("YES");
            System.exit(0);
        }

        boolean[] v = new boolean[n];
        v[target[idx]-1] = true;

        q.add(target[idx]-1);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < n; i++) {
                //연결되었다면
                if (g[now][i] == 1 && !v[i]) {
                    //그게 다음 여행 계획이라면
                    if (i==target[idx+1]-1){
                        bfs(idx+1);
                        break;
                    }
                    q.add(i);
                }
            }
        }
    }
}
