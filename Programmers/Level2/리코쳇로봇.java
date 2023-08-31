package Level2;

/**
 * start : 2023-08-30 16:20
 * end : 2023-08-30 17:20
 * 알고리즘 : BFS
 */
import java.util.*;

class 리코쳇로봇 {
    boolean[][] v;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(String[] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        Queue<int[]> q = new LinkedList<>();
        int[] now = new int[3];
        v = new boolean[n][m];
        // System.out.println(n);
        for (int i = 0 ; i < n ; i++){
            if (board[i].contains("R"))
            {
                now[0] = i;
                now[1] = board[i].indexOf("R");
                break;
            }
        }

        // System.out.println(now[0]+" "+now[1]);

        q.add(now);
        v[now[0]][now[1]] = true;

        while (!q.isEmpty()){
            int[] temp = q.poll();
            //도착지점이라면
            if (board[temp[0]].charAt(temp[1]) == 'G')
            {
                answer = temp[2];
                break;
            }
            for (int i = 0 ; i < 4 ; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                //벽에 부딪히거나 장애물까지 쭉
                while (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx].charAt(ny) != 'D' ){
                    nx+=dx[i];
                    ny+=dy[i];
                    // System.out.println(board[nx]);
                }
                nx -= dx[i];
                ny -= dy[i];
                if (!v[nx][ny])
                {
                    // System.out.println(nx + " " + ny);
                    q.add(new int[] {nx, ny, temp[2]+1});
                    v[nx][ny] = true;
                }
            }

        }

        if (answer == 0)
            answer = -1;

        return answer;
    }
}
