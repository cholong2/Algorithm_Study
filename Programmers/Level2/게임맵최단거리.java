package Level2;
import java.util.*;

/**
 * 알고리즘 : BFS
 * DFS로 풀면 시간초과
 * BFS > DFS 승!
 */
public class 게임맵최단거리 {

    class Solution {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int n, m;
        int min = Integer.MAX_VALUE;
        boolean[][] v;
        public int solution(int[][] maps) {
            int answer = Integer.MAX_VALUE;
            n = maps.length; //row
            m = maps[0].length; //col
            v = new boolean[n][m];
            Queue <int[]> q = new LinkedList<>();
            v[0][0] = true;
            q.offer(new int[] {0, 0, 1});
            int cnt = 1;

            // dfs(maps, new int[] {0, 0}, 1);
            while (!q.isEmpty()){
                int[] now = q.poll();
                int nowX = now[0];
                int nowY = now[1];

                if (now[0]==n-1 && now[1] == m-1)
                {
                    System.out.println("왓");
                    answer = now[2];
                    break;
                }
                for (int i = 0 ; i < 4 ; i++){
                    int nx = nowX + dx[i];
                    int ny = nowY + dy[i];
                    if (nx<0 || ny <0 || nx >= n || ny >= m || maps[nx][ny] == 0 || v[nx][ny])
                        continue;

                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny, now[2]+1});
                }
            }



            if (answer == Integer.MAX_VALUE)
                answer = -1;

            return answer;
        }
//     public void dfs (int[][] maps, int[] now,  int cnt){
//         int nowX = now[0];
//         int nowY = now[1];

//         if (nowX == n-1 && nowY == m-1){
//             min = Math.min(min, cnt);
//             return;
//         }
//         for (int i = 0 ; i < 4 ; i++){
//             int nx = nowX + dx[i];
//             int ny = nowY + dy[i];
//             if (nx<0 || ny <0 || nx >= n || ny >= m || maps[nx][ny] == 0 || v[nx][ny])
//                 continue;
//             else
//                 {
//                 v[nx][ny] = true;
//                 // for (int j = 0 ; j < n ; j++){
//                 //     for (int k = 0 ; k < m ; k++){
//                 //         System.out.print(v[j][k] + " ");
//                 //     }
//                 //     System.out.println();
//                 // }
//                 // System.out.println("___________________");
//                 dfs(maps, new int[] {nx, ny}, cnt+1);
//                 v[nx][ny] = false;
//             }
//         }

//     }
    }
}
