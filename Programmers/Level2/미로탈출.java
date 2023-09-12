package Level2;

import java.util.*;
/*
*얍삽이 레버 안거쳐도 된다면서 레버 안거치고 그냥 exit으로 bfs하면 안나옴
준 문제 조건이 필요하지 않을 것 같아도 그냥 적용하기 !!!
*/

/**
 * start : 2023-09-13 07:30
 * end : 2023-09-13 08:21
 * 알고리즘 : BFS
 * 얍삽이 레버 안거쳐도 된다면서 레버 안거치고 그냥 exit으로 bfs하면 안나옴
 * bfs(start, lever) + bfs(lever, exit)
 */
import java.util.*;

class 미로탈출 {
    char board[][];
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int n, m;
    public int solution(String[] maps) {
        int answer = -1;
        n = maps.length;
        m = maps[0].length();
        board = new char[n][m];
        int[] start = new int[2];
        int[] lever = new int[2];
        int midCnt =0;
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < m ; j++){
                board[i][j] = maps[i].charAt(j);

                if (board[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                if (board[i][j] == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }
            }

        }
        int s = bfs(start, 'L');
        int e = bfs(lever, 'E');

        if (s==-1 || e==-1){
            return -1;
        }
        else return s+e;


    }
    public int bfs (int[] start, char target){

        boolean[][] v = new boolean[n][m];
        Queue <int[]> q = new LinkedList<>();
        q.offer(new int[] {start[0], start[1], 0});

        while (!q.isEmpty()){
            int[] temp = q.poll();

            //목적지도착확인
            if (board[temp[0]][temp[1]]==target){
                return temp[2];
            }
            else {
                for (int i = 0 ; i < 4 ;i++){
                    int nx = temp[0] + dx[i];
                    int ny = temp[1] + dy[i];
                    if (nx >=0 && ny >= 0 && nx < n && ny <m &&board[nx][ny]!='X' && !v[nx][ny]){
                        v[nx][ny] = true;
                        q.offer(new int[]{nx, ny, temp[2]+1});
                    }
                }
            }
        }

        return -1;
    }
}