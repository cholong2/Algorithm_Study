/*
백준 17086번 : 아기상어2
알고리즘 : DP
start : 2023-06-15 22:34
end : 2023-06-15 23:38

 */
import java.io.*;
import java.util.*;
public class BJ_17086 {
    static int n, m, answer;
    static int[][] board ,check;

    static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};


    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        //8방향으로 계속 가다가 1이면 return

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        check = new int[n][m];
        answer = 0;

        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer (bf.readLine());
            for (int j = 0 ; j< m ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j <m ; j++){
                if (board[i][j] == 0){
                    bfs(i, j);
                }

            }
        }
        System.out.println(answer);
    }
    public static void bfs (int row, int col) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList();
        visited[row][col] = true;
        q.add(new int[]{row, col, 0});


        while (!q.isEmpty()) {

            int temp[] = q.poll();
            int x = temp[0];
            int y = temp[1];
            int cnt = temp[2]; // 0

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    if (board[nx][ny] == 1) {
                        answer = Math.max(cnt + 1, answer);
                            return;
                        }
                        q.add(new int[]{nx, ny, cnt + 1});
                        visited[nx][ny] = true;


                    }
                }
            }

        }
    }


