/**
 * 백준 연구소 14502번
 * start : 2023-10-21 21:52
 * end : 2023-10-21
 * 알고리즘 : DFS, BFS
 *
 */

import java.io.*;
import java.util.*;
public class BJ_14502 {
    static int n, m, max;
    static int[][] lab;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][m];
        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j < m ; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }
    public static void dfs (int cnt){

        if (cnt == 3){
            getSafe();
            return;
        }

        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < m ; j++){
                if (lab[i][j]==0){
                    lab[i][j] = 1;
                    dfs (cnt+1);
                    lab[i][j] = 0;
                }
            }
        }
    }
    public static void getSafe(){

        Queue<int[]> q= new LinkedList<>();

        int[][] copyLab = new int[n][m];


        for (int i = 0 ; i < n ; i++){
            copyLab[i] = lab[i].clone();
        }

        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < m ; j++){
                if (copyLab[i][j] == 2){
                    q.offer(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()){
            int[] temp = q.poll();

            for (int i = 0 ; i < 4 ; i++){
                int nx = dx[i] + temp[0];
                int ny = dy[i] + temp[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && copyLab[nx][ny] == 0 ){
                    copyLab[nx][ny] = 2;
                    q.offer(new int[] {nx, ny});
                }
            }
        }

        int cnt = 0;

        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < m ; j++){
                if (copyLab[i][j] == 0){
                    cnt++;
                }
            }
        }
        max = Math.max(cnt, max);

    }
}

