import java.util.*;
import java.io.*;

/**
 * 백준 10026번 : 10026번
 * start : 2023-09-25 14:38
 * end : 2023-09-25 14:59
 * 알고리즘 : 완전탐색
 * 함수로 짜서 하면 더 가독성 좋았을듯 함수로 하려면 board를 바꿔야겠지만여
 */

public class BJ_10026 {
    static int n = 0, ans1= 0, ans2 = 0;
    static char board[][];
    static boolean v[][];
    static boolean v1[][];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main (String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        board = new char[n][n];
        v = new boolean[n][n];
        v1 = new boolean[n][n];

        for (int i = 0 ; i < n ; i++){
            String temp = bf.readLine();
            for (int j = 0 ; j < n ; j++){
                board[i][j] = temp.charAt(j);
            }
        }
        Queue<int[]> q = new LinkedList<>();

        //그냥 BFS 두번 돌리면 나오긴 하는데 한번에 구할 방법이 없을까
        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < n ; j++){
                if (!v[i][j]){
                    q.add(new int[] {i, j});
                    v[i][j] = true;
                    char now = board[i][j];
                    while (!q.isEmpty()){
                        int[] temp = q.poll();
                        for (int k = 0 ; k < 4 ; k++){
                            int nx = dx[k] + temp[0];
                            int ny = dy[k] + temp[1];

                            if (nx >=0 && ny >= 0 && nx < n && ny < n && !v[nx][ny] && board[nx][ny]==now){
                                q.add(new int[]{nx, ny});
                                v[nx][ny] = true;
                            }
                        }

                    }
                    ans1++;
                }
            }
        }

        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < n ; j++){
                if (!v1[i][j]){
                    q.add(new int[] {i, j});
                    v1[i][j] = true;
                    char now = board[i][j]; // R or G면 같은걸로 인식

                    while (!q.isEmpty()){
                        int[] temp = q.poll();
                        for (int k = 0 ; k < 4 ; k++){
                            int nx = dx[k] + temp[0];
                            int ny = dy[k] + temp[1];

                            if (nx >=0 && ny >= 0 && nx < n && ny < n && !v1[nx][ny] ){
                                if (now == 'B' ) {
                                    if (board[nx][ny] == now) {

                                        q.add(new int[]{nx, ny});
                                        v1[nx][ny] = true;
                                    }
                                }
                                else {

                                    if (board[nx][ny]=='R' || board[nx][ny]=='G'){

                                        q.add(new int[]{nx, ny});
                                        v1[nx][ny] = true;
                                    }
                                }
                            }
                        }

                    }
                    ans2++;
                }
            }
        }

        System.out.println(ans1+" "+ ans2);
    }

}
