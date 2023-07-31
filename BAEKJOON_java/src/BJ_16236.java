/*
백준 16236 : 아기 상어
알고리즘 : BFS
start : 2023-07-14 22:14
end : 2023-07-15 20:45
알고리즘 : BFS
한줄평 : 그냥 위, 왼 순으로만 넣으면 저절로 높은것부터 들어갈거라는 안일한 생각으로 어마무시하게 헤맴
그리고 언제 검사를 해야하는지 잘못넣어서 우선순위큐에 넣어도 잘 안됐음
큐에 넣고 정렬 되고나서 우선순위가 가장 높은==가장위가장왼쪽 에 있는 애부터 야미 해야한다~
 */
import java.io.*;
import java.util.*;
/*
상어 크기는 2 나랑 크기가 같은 수의 ㅁ물고기를 먹으면 +1
나보다 작은 물고기는 야미
같으면 지나갈 수만 있음
크면 못지나감
먹는 우선순위는 최단거리 물고기 그중에서도 좌 -> 상이 우선순위
이동은 1초

 */
public class BJ_16236 {
    static int n;
    static int dSize = 2;
    static int cnt = 0;
    static int ans = 0;
    static int[][] board;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main (String args[])throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        int row = 0;
        int col = 0;
        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j < n ; j++){
                int temp = Integer.parseInt(st.nextToken());
                board[i][j] = temp;
                if (temp == 9){
                    row = i;
                    col = j;
                }
            }
        }

        board[row][col] = 0;
        bfs(row, col, 0);
        System.out.println(ans);
    }

    public static void bfs (int row, int col, int time){
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->
                o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
        );
        boolean[][] v = new boolean[n][n];

        q.add(new int[]{row, col, time});
        v[row][col] = true;

        while (!q.isEmpty()){
            int[] now = q.poll();
            if (board[now[0]][now[1]] < dSize && board[now[0]][now[1]] > 0){
                cnt++;
                board[now[0]][now[1]] = 0;
                if (cnt == dSize) {
                    dSize++;
                    cnt=0;
                }
                ans += now[2];
//                System.out.println("먹기 "+now[0] + " "+ now[1] + " 시간 " +  (now[2]+1));
//                System.out.println("크기 " + dSize + " 먹은 물고기 " + cnt );
                bfs (now[0], now[1], 0);
                return;
            }

            for (int i = 0 ; i < 4 ; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx>=0 && ny >= 0 && nx < n && ny < n && board[nx][ny] <= dSize  && !v[nx][ny]){
                    v[nx][ny] = true;
//                    System.out.println("이동"+nx + " "+ ny);
                    q.add(new int[] {nx, ny, now[2]+1});
                }
            }
        }

    }
}

























