package Level2;
/*
알고리즘 : BFS
계산도 했어야 했던 BFS문제~
 */
import java.util.*;
class 무인도여행 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] v;
    static char[][] board;
    static List<Integer> answer = new ArrayList<>();
    static int row, col;

    public int[] solution(String[] maps) {

        row = maps.length;
        col = maps[0].length();
        board = new char[row][col];
        v = new boolean[row][col];

        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ; j++){
                board[i][j] = maps[i].charAt(j);
            }
        }
        int temp = 0;
        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ; j++){
                if (board[i][j]!='X' && !v[i][j]){
                    v[i][j] = true;
                    temp = Character.getNumericValue(board[i][j]);
                    answer.add(bfs(i, j));
                }
            }

        }
        if (answer.size()==0){
            answer.add(-1);
        }
        Collections.sort(answer);
        int[] answerArr = new int[answer.size()];
        for (int i = 0 ; i < answerArr.length ; i++){
            answerArr[i] = answer.get(i);
        }
        return answerArr;
    }

    public static int bfs (int x, int y){
        int sum= 0;
        Queue <int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        v[x][y] = true;

        while (!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            sum+= Character.getNumericValue(board[nowX][nowY]);
            for (int i = 0 ; i < 4 ; i++){
                int nx = dx[i] + nowX;
                int ny = dy[i] + nowY;
                if(nx < 0 || ny < 0 || nx >= row || ny >= col)
                    continue;
                if(!v[nx][ny] && board[nx][ny] != 'X'){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return sum;
    }
}
