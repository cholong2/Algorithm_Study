import java.io.*;
import java.util.*;

/**
 * start : 2023-09-08 20:21
 * end : 2023-09-08 21:01
 * 알고리즘 : 그래프 탐색, DFS, BFS
 */
public class BJ_2583 {
    static int n, m, k, cnt;
    static boolean[][] v;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main (String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        v = new boolean[n][m];
        ArrayList<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < k ; i++){
            st = new StringTokenizer(bf.readLine());
            int lc = Integer.parseInt(st.nextToken());
            int lr = n-Integer.parseInt(st.nextToken())-1;
            int rc = Integer.parseInt(st.nextToken())-1;
            int rr = n-Integer.parseInt(st.nextToken());

            for (int j = rr ; j <= lr ; j++){
                for (int w = lc ; w <= rc ; w++){
//                    System.out.println(j+ ", " +w);
                    v[j][w] = true;
                }
            }
        }
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < m ; j++){
                if (!v[i][j]){
                    v[i][j] = true;
                    //영역 넓이 찾기
                    cnt = 1;
                    dfs (i, j);
                    ans.add(cnt);
                }
            }
        }

        ans.sort(Comparator.comparingInt(o -> o));
        sb.append(ans.size()).append("\n");
        for (int temp : ans){
            sb.append(temp).append(" ");
        }
        System.out.println(sb);
    }
    public static void dfs (int x, int y){
       for (int i = 0 ; i < 4 ; i++){
           int nx = dx[i] + x;
           int ny = dy[i] + y;
           if (nx>=0 && ny >=0 && nx < n && ny < m && !v[nx][ny]){
               cnt++;
               v[nx][ny] = true;
               dfs (nx, ny);
           }
       }
    }
}
