/**
 * 백준 2048(easy)
 * start : 2023-10-29 19:19
 * end : 2023-10-30 15:58
 * 알고리즘 : DFS+구현
 * 조건 많은 구현 문제 어질어질
 * 처음에는 dfs 호출할 때 움직인 새로운 보드를 매개변수로 넘겨줬는데 이렇게 하니까 stackoverflow가 났음
 * 재귀함수를 사용하면 호출한 함수가 종료되지 않은 채 새로운 함수를 계속 호출하니까 스택에 메모리가 쌓임
 * 해결방법 : 어레이에 방향 정보 넣고 깊이가 5가 되면 그때 방향 명령어에 맞게 한번에 이동시킴
 * 메모리도 생각하자 초롱아~ 
 */

import java.io.*;
import java.util.*;

public class BJ_12100 {
    static int n, answer;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main (String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        board = new int[n][n];
        int[][] copy = new int[n][n];
        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j < n ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = board[i][j];
            }
        }

        answer = 0;
        int[] com = new int[5];
        //위 왼 오 아
//        int[] testCom = {0, 0, 0, 0, 1};
//        int[][] temp = move(testCom);
//
//        for (int i = 0 ; i < n ; i++){
//            for (int j = 0 ; j < n ; j++){
//                System.out.print(temp[i][j]+" ");
//            }
//            System.out.println();
//        }
        dfs(0, com);
        System.out.println(answer);

    }



    public static void dfs (int cnt, int[] com){
        if (cnt >= 5){
            int[][] moveBoard = move(com);
           for (int i = 0 ; i < n ; i ++){
              for (int j = 0 ; j < n ; j++){
                   answer = Math.max(answer, moveBoard[i][j]);
//                  System.out.print(moveBoard[i][j] +" ");
               }
//              System.out.println();
           }
//            System.out.println("===============================");
            return;
        }
        //상하좌우
        for (int i = 0 ; i < 4 ; i++){
            com[cnt] = i;
            dfs (cnt+1, com);
        }

    }
    public static int[][] move (int[] com){
        int [][] b = new int[n][n];
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0 ; i < n ; i++){
            b[i] = board[i].clone();
        }
        for (int k = 0 ; k < 5 ; k++) {
            //위
            int dir = com[k];
            if (dir == 0) {
                for (int j = 0; j < n; j++) {
                    //한 열씩 다 넣기
                    for (int i = 0; i < n; i++) {
                        if (b[i][j] != 0) {
                            q.offer(b[i][j]);
                            b[i][j] = 0;
                        }
                    }
                    int last = 0;
                    int idx = 0;
                    boolean flag = false;
                    while (!q.isEmpty()) {
                        int now = q.poll();
                        if (last == 0) {
                            last = now;
                            b[idx][j] = now;
                            idx++;
                        } else if (last == now) {
                            if (!flag) {
                                b[idx - 1][j] = now * 2;
                                last = b[idx - 1][j];
                                flag = true;
                            } else {
                                b[idx][j] = now;
                                last = b[idx][j];
                                flag = false;
                                idx++;
                            }
                        } else if (last != now) {
                            flag = false;
                            b[idx][j] = now;
                            last = b[idx][j];
                            idx++;
                        }
                    }

                }
            }
            //왼쪽
            else if (dir == 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (b[i][j] != 0) {
                            q.offer(b[i][j]);
                            b[i][j] = 0;
                        }
                    }
                    int last = 0;
                    int idx = 0;
                    boolean flag = false;
                    while (!q.isEmpty()) {
                        int now = q.poll();
//                        System.out.println(now+ " "+flag);
                        if (last == 0) {
//                            System.out.println("맨첫번째 요소");
                            last = now;
                            b[i][idx] = now;
                            idx++;
                        }
                        else if (last == now) {

                            if (!flag) {
//                                System.out.println("앞에 있는애랑 지금 꺼낸애랑 같고 앞에 애가 충돌하지 않았을때");
                                b[i][idx - 1] = now * 2;
                                last = b[i][idx-1];
                                flag = true;
                            } else {
//                                System.out.println("앞에 있는애랑 지금 꺼낸애랑 같고 앞에 애가 충돌함");
                                b[i][idx] = now;
                                last = b[i][idx];
                                flag = false;
                                idx++;
                            }
                        }


                        else if (last != now) {
//                            System.out.println("앞에 애랑 나랑 다름 ");
                            flag = false;
                            b[i][idx] = now;
                            last = b[i][idx];
                            idx++;
                        }
                    }
                }
            }
            //오른쪽
            else if (dir == 2) {
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        if (b[i][j] != 0) {
                            q.offer(b[i][j]);
                            b[i][j] = 0;
                        }
                    }
                    int last = 0;
                    int idx = n - 1;
                    boolean flag = false;
                    while (!q.isEmpty()) {
                        int now = q.poll();

                        if (last == 0) {
                            last = now;
                            b[i][idx] = now;
                            idx--;
                        } else if (last == now) {
                            if (!flag) {
                                b[i][idx + 1] = now * 2;
                                last = b[i][idx+1];
                                flag = true;
                            } else {
                                b[i][idx] = now;
                                last = b[i][idx];
                                flag = false;
                                idx--;
                            }
                        } else if (last != now) {
                            flag = false;
                            b[i][idx] = now;
                            last = b[i][idx];
                            idx--;
                        }
                    }
                }
            }
            //아래
            else {
                for (int j = 0; j < n; j++) {
                    //한 열씩 다 넣기
                    for (int i = n-1; i >= 0; i--) {
                        if (b[i][j] != 0) {
                            q.offer(b[i][j]);
                            b[i][j] = 0;
                        }
                    }

                    int last = 0;
                    int idx = n - 1;
                    boolean flag = false;
                    while (!q.isEmpty()) {
                        int now = q.poll();
                        if (last == 0) {
                            last = now;
                            b[idx][j] = now;
                            idx--;
                        } else if (last == now) {
                            if (!flag) {
                                b[idx + 1][j] = now * 2;
                                last = b[idx + 1][j];
                                flag = true;
                            } else {
                                b[idx][j] = now;
                                last = b[idx][j];
                                flag = false;
                                idx--;
                            }
                        } else if (last != now) {
                            flag = false;
                            b[idx][j] = now;
                            last = b[idx][j];
                            idx--;
                        }
                    }

                }
            }
//            for (int x = 0 ; x < n ; x++){
//                for (int y = 0 ; y < n ; y++){
//                    System.out.print(b[x][y]+" ");
//                }
//                System.out.println();
//            }
        }
        return b;
    }
}
