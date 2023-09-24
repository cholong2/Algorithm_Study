import java.io.*;
import java.util.*;

/**
 * start : 2023-09-24 13:30
 * end : 2023-09-24 15:11
 * 메모리 초과로 잡아먹음 ㅠ 큐에 추가할 때마다 true해줘야함 뺄 때 true해주면 메모리 초과 왜 그러죠?
 * 큐에서 뺄 때 방문체크하면 중복 방문할 수 있음 ! 뺄 때만 하면 넣을때는 얘가 큐에 있어도 아직 방문처리 안했으니 또 들어가고
 * 그럼 중복이 어마무시하게 되겠져?
 */
public class BJ_2468 {
    static int n = 0, answer = 0;
    static int maxDepth = 0;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main (String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        board = new int[n][n];
        for (int i = 0 ; i  < n ; i ++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j < n ; j ++){
                board[i][j] = Integer.parseInt(st.nextToken());
                maxDepth = Math.max(board[i][j], maxDepth);
            }
        }
        boolean[][] v;
        for (int dep = maxDepth ; dep>=0 ; dep--) {
            v = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] <= dep) {
                        v[i][j] = true;
                    }
                }
            }

            for (int i = 0 ; i < n ; i ++){
                for (int j = 0 ; j < n ; j++){
                    if (!v[i][j]){
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[] {i, j});
                        v[i][j] = true;
                        cnt++;
                        while (!q.isEmpty()){
                            int[] temp = q.poll();

                            for (int k = 0 ; k < 4 ; k++){
                                int nx = temp[0] + dx[k];
                                int ny = temp[1] + dy[k];

                                if (nx>=0 && ny >=0 && nx < n && ny < n && !v[nx][ny]){
                                    q.add(new int[] {nx, ny});
                                    v[nx][ny] = true;
                                }
                            }
                        }
                    }

                }
            }

            answer = Math.max (cnt, answer);
        }
        System.out.println(answer);
    }

}
