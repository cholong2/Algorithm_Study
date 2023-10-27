/**
 * 백준 벽 부수고 이동하기
 * start : 2023-10-17 16:30
 * end : 2023-10-17
 * 알고리즘 : BFS
 * 근야 그 위치에서의 방문체크만 했는데 이게 부시고 갔을때랑 안부시고 갔을때 달라짐 다음 위치까지 최단거리는 맞지만 목적지까지의 최단거리인지는 모름
 * 언제 부시고 언제 돌아가야 최단거리인지 모름!
 * 그러니 벽을 부수고 갔을때 최단거리, 벽을 부수지 않고 갔을때 나눠서 최단거리를 찾아야행
 * pq로 이동횟수 기준으로 내림차순해서 목적지에 가장 먼저 도착하면 끝내두 됨~
 */
import java.io.*;
import java.util.*;

public class BJ_2206 {
    static int n, m;
    static int[][] board;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main (String[] args)throws IOException{
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        boolean v[][][] = new boolean[n][m][2]; // 벽안부시고 visited, 부시고 visited
        int answer = -1;

        for (int i = 0 ; i < n ; i++){
            String temp = bf.readLine();
            for (int j = 0 ; j < m ; j++){
                board[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o->o[3]));
        q.offer(new int[]{0, 0, 0, 1});//x, y, 벽, 이동횟수
        v[0][0][0] = true;

        while (!q.isEmpty()){
            int[] next = q.poll();

            if (next[0] == n-1 && next[1] == m-1){
                answer = next[3];
                break;
            }
            for (int i = 0 ; i < 4 ; i++){
                int nx = next[0] + dx[i];
                int ny = next[1] + dy[i];

                if (nx >=0 && ny >= 0 && nx < n && ny < m){
                    //한번도 안부신거 경로
                    if (!v[nx][ny][next[2]]){

                        if (board[nx][ny] + next[2] == 0){
                            q.offer(new int[] {nx, ny, 0, next[3]+1});
                            v[nx][ny][0] = true;
                        }
                        else if (board[nx][ny] + next[2] == 1){
                            q.offer(new int[] {nx, ny, 1, next[3]+1});
                            v[nx][ny][1] = true;
                        }
                    }


                }
            }
        }

        System.out.println(answer);
    }
}
