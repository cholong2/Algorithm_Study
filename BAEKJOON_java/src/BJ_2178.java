import java.io.*;
import java.util.*;

public class BJ_2178 {
    static int n = 0, m = 0;
    static boolean[][] v;
    static char board[][];
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        v = new boolean[n][m];
        board = new char[n][m];

        for (int i = 0 ; i  < n ; i++){
            String temp = bf.readLine();
            for (int j = 0 ; j < m ; j++){
                board[i][j] = temp.charAt(j);
            }
        }

        q.add(new int[] {0, 0, 1});
        v[0][0] = true;
        while (!q.isEmpty()){
            int[] now = q.poll();
            if (now[0] == n-1 && now[1] == m-1){
                System.out.println(now[2]);
                return;
            }
            for (int i = 0 ; i < 4 ; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !v[nx][ny] && board[nx][ny]=='1')
                {

                    v[nx][ny] = true;
                    q.add(new int[] {nx, ny, now[2]+1});
                }
            }

        }

    }
}
