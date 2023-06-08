// 백준 3197번: 백조의 호수
// start : 2023.04.13 16:00
// end :

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3197 {

    private static int n, m;
    private static Queue<Integer> x = new LinkedList<Integer>();
    private static Queue<Integer> y = new LinkedList<Integer>();

    private static boolean visited[][];
    private static boolean ice[][];
    private static char board[][];
    private static int day = 0;
    private static int[][] swan = new int[2][2];
    private static int tx, ty;

    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        ice = new boolean[n][m];

        board = new char[n][m];
        int c = 0;

        for (int i = 0 ; i < n ; i ++){
            String temp = bf.readLine();
            char[] line = temp.toCharArray();
            board[i] = line;

            for (int j = 0 ; j < m ; j++) {
                if (board[i][j] == 'L') {
                    swan[c][0] = i;
                    swan[c][1] = j;
                    c++;
                    ice[i][j] = true;
                }
                if (board[i][j] == '.') {
                    ice[i][j] = true;
                }


            }
        }

        // (0,0)L부터 넣고 시작

        // 일단 만날 수 있는지 검사 먼저 해 -> bfs
        // 만날 수 없으면 다 초기화하고 얼음 뿌시고 다음날 ++
        // 이걸 만날 수 있을 때 까지 반복

        x.add(swan[0][0]);
        y.add(swan[0][1]);
        visited[x.peek()][y.peek()] =true;

                //x.peek() != swan[1][0] && y.peek() != swan[1][1]
        while (!visited[swan[1][0]][swan[1][1]]) {

//            for (int i = 0 ; i < n ; i ++){
//                for (int j = 0 ; j < m ;j++){
//                    System.out.println(visited[i][j]);
//                }
//            }
            if (x.isEmpty()) {
                day++;
                //얼름도 녹여야함
                for (int i = 0; i < n ; i++){
                    for (int j = 0 ; j < m ; j ++){
                        if (board[i][j] =='.' && ice[i][j] == true){
                            if (i-1 >= 0 && board[i-1][j] == 'X'){
                                board[i-1][j] = '.';
                            }
                            if (i+1 < n && board[i+1][j] == 'X'){
                                board[i+1][j] = '.';
                            }
                            if (j-1 >= 0 && board[i][j-1] == 'X'){
                                board[i][j-1] = '.';
                            }
                            if (j+1 < m && board[i][j+1] == 'X'){
                                board[i][j+1] = '.';
                            }
                        }
                    }
                }

                for (int i = 0 ; i < n ; i ++){
                    for (int j = 0 ; j < m ; j ++){
                        if (board[i][j] == '.')
                            ice[i][j] = true;
                    }
                }

                for (int i = 0; i < n; i++) {
                    Arrays.fill(visited[i], false);
                }

                x.add(swan[0][0]);
                y.add(swan[0][1]);

                visited[x.peek()][y.peek()] = true;
            }
            else {
                tx = x.poll();
                ty = y.poll();

                //위
                if (tx - 1 >= 0 ) {
                    if (!visited[tx - 1][ty] && board[tx - 1][ty] != 'X')
                    {
                        x.add(tx - 1);
                        y.add(ty);

                        visited[tx - 1][ty] = true;
                    }
                }
                //아래
                if (tx + 1 < n ) {
                    if (!visited[tx + 1][ty] && board[tx + 1][ty] != 'X')
                    {
                        x.add(tx + 1);
                        y.add(ty);
                        visited[tx + 1][ty] = true;
                    }
                }
                //좌
                if (ty - 1 >= 0 ) {
                    if (!visited[tx][ty-1]&& board[tx][ty-1] != 'X') {
                        x.add(tx);
                        y.add(ty - 1);
                        visited[tx][ty - 1] = true;
                    }
                }
                //우
                if (ty + 1 < m ) {
                    if (!visited[tx][ty + 1] && board[tx][ty + 1] != 'X' ){
                    x.add(tx);
                    y.add(ty + 1);
                    visited[tx][ty + 1] = true;
                    }
                }


            }
        }

        System.out.println(day);


    }
}
