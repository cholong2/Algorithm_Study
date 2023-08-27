/**
 * start : 2023-08-27 20:30
 * end : 2023-08-27 21:04
 * 알고리즘 : bfs 
 */

import java.io.*;
import java.util.*;

public class BJ_7562 {
    static int t, n;
    static boolean[][] v;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] start, end;
    static StringBuilder sb = new StringBuilder();
    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        start = new int[3];
        end = new int[2];

        t = Integer.parseInt(st.nextToken());
        for (int c = 0 ; c < t ; c++){
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            v = new boolean[n][n];

            st = new StringTokenizer(bf.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            start[2] = 0;
            st = new StringTokenizer(bf.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            bfs();
        }
        System.out.println(sb);
    }
    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        v[start[0]][start[1]] = true;

        while (!q.isEmpty()){
            int[] now = q.poll();

            if (now[0]==end[0] && now[1]==end[1]){
                sb.append(now[2]).append("\n");
                return;
            }

            for (int i = 0 ; i < 8 ; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx >= 0 && ny >=0 && nx < n && ny < n && !v[nx][ny]){
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny, now[2]+1});
                }
            }
        }

    }
}
