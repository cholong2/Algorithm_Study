/** 백준 13460: 구슬 탈출2
 * start : 2023-10-25 15:49
 * end : 2023-10-25 17:17
 * 알고리즘 : BFS?
 * 몇개월만에 다시 돌아와따 내가
 * 빨간구슬을 구멍을 통해 빼내기 근데 파란구슬이 구멍 들어가면 X
 * 구슬이 더이상 움직이지 않을때까지 기울이기 근데 10번 이하로 움직여서 할 수 없으면 -1 -> 최대 10번
 *
*/

import java.io.*;
import java.util.*;

public class BJ_13460 {
    static int n, m, answer = -1;
    static int[] dx = {0, 1, 0, -1};// 우 하 좌 상
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Queue<int[]> r = new LinkedList<>();
;

        char[][] board = new char[n][m];
        int[][] point = new int[3][2];// R, B, O
        for (int i = 0; i < n ; i ++){
            String temp = bf.readLine();
            for (int j = 0 ; j < m ; j++){
                board[i][j] = temp.charAt(j);

                if (board[i][j] == 'R'){
                    point[0][0] = i;
                    point[0][1] = j;
                }
                if (board[i][j] == 'B'){
                    point[1][0] = i;
                    point[1][1] = j;
                }
                if (board[i][j] == 'O'){
                    point[2][0] = i;
                    point[2][1] = j;
                }
            }
        }
        r.offer(new int[] {point[0][0], point[0][1], point[1][0], point[1][1], 1});
        boolean [][][][] v = new boolean[n][m][n][m];

        while (!r.isEmpty()){
            int[] now = r.poll(); // 01 R, 23 B, 4횟수

            if (now[4] > 10){
                break;
            }

            for (int i = 0 ; i < 4 ; i++){
                //벽이나 파란구슬에 막히거나, 구멍에 들어갈 때까지 기울이기
                int rx = now[0] + dx[i];
                int ry = now[1] + dy[i];

                int bx = now[2] + dx[i];
                int by = now[3] + dy[i];

                boolean rFlag = false;
                boolean bFlag = false;
                //빨간구슬이동 -> #벽을 만날 때까지
                while (board[rx][ry] !='#') {
                    //가다가 구멍에 들어갔다면
                    if (board[rx][ry] == 'O') {
                        rFlag = true;
                        break;
                    }
                    rx += dx[i];
                    ry += dy[i];
                }
                //파란 구슬 이동 -> #만날때까지
                while (board[bx][by] !='#'){

                    if (board[bx][by] == 'O'){
                        bFlag = true;
                        break;
                    }
                    bx+=dx[i];
                    by+=dy[i];
                }

                if (bFlag) continue;

                if (rFlag&&!bFlag) {
                    answer = now[4]+1;
                }

                if (rx == bx && ry == by){
                    //오른쪽으로
                    if (i==0){
                        if (now[1] > now[3]) by -=dy[i];
                        else ry -= dy[i];
                    }
                    //아래
                    else if (i == 1){
                        if (now[0] > now[2]) bx-=dx[i];
                        else rx -= dx[i];
                    }
                    //왼쪽
                    else if (i == 2){
                        if (now[1] > now[3]) ry -= dy[i];
                        else by -= dy[i];
                    }
                    //위쪽
                    else if (i == 3){
                        if (now[0] > now[1]) rx-=dx[i];
                        else bx -= dx[i];
                    }
                }

                if (!v[rx][ry][bx][by]){
                    v[rx][ry][bx][by] = true;
                    r.offer(new int[] {rx, ry, bx, by, now[4]+1});
                }

            }
        }

        System.out.println(answer);
    }


}
