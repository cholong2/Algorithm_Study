
/**
 * 백준 1261번 알고스팟
 * start : 2023-10-26 13:08
 * end : 2023-10-26 13:56
 * 알고리즘 : BFS?
 * int로 visited 체크하기 방문했으면 1로 바꿔주고
 * 0이 아니라면 여기까지 오면서 부신 방 개수랑 여기원래 개수랑 비교
 * 근데 그냥 PriorityQueue썼으면 더 쉽게 풀 수 있었넴 ㅎ
 * pq의 우선순위를 벽 부신 수 기준으로 내림차순하고 젤 먼저 n,m에 도착하면 끝내는 BFS로 풀 수 이따...
 */

import java.io.*;
import java.util.*;
public class BJ_1261 {
    static int n,m;
    static int[][] board;
    static int[][] v;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        v = new int[n][m];

        for (int i = 0 ; i < n ; i++){
            String temp = bf.readLine();

            for (int j = 0 ; j < m ; j++){
                board[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0}); // x, y, 부신 벽 수
        v[0][0] = 1;

        while (!q.isEmpty()){
            int[] now = q.poll();

            for (int i = 0 ; i < 4 ; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx>=0 && ny >= 0 && nx < n && ny < m){
                    //벽 없는 곳
                    if (board[nx][ny] == 0) {
                        //첫방문이라면 현재 부신 수+방문했다는 뜻의 +1
                        if (v[nx][ny] == 0) {
                            v[nx][ny] = now[2]+1;
                            q.offer(new int[]{nx, ny, now[2]});
                        }
                        else {
                            //첫방문이 아니라면 여기 원래 있던 수랑 내 방문수랑 비교
                            if (v[nx][ny]-1 > now[2]){
                                v[nx][ny] = now[2]+1;
                                q.offer(new int[]{nx, ny, now[2]});
                            }
                        }
                    }
                    //벽이 있다면
                    else {
                        //첫방문이라면 +2 = 오면서 부신거+1 방문했다는 뜻의+1
                        if (v[nx][ny] == 0) {
                            v[nx][ny] = now[2]+2;
                            q.offer(new int[]{nx, ny, now[2]+1});
                        }
                        //첫방문이 아니라면
                        else {
                            //원래 있던 곳의 부신 개수 : 여기까지 오면서 부신 거
                            if (v[nx][ny]-1 > now[2]+1){
                                v[nx][ny] = now[2]+2;
                                q.offer(new int[]{nx, ny, now[2]+1});
                            }
                        }
                    }
                }

            }
//            for (int i = 0 ; i < n ; i++){
//                for (int j = 0 ; j < m ; j++){
//                    System.out.print(v[i][j] + " " );
//                }
//                System.out.println();
//            }
        }
        System.out.println(v[n-1][m-1]-1);
    }
}
