import java.io.*;
import java.util.*;

/**
 * start : 2023-09-07 15:38
 * end : 2023-09-07 16:31
 * 알고리즘 : 재귀, DFS
 */
public class BJ_1074 {
    static int n, r, c;

    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 0, 1};
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = 1;

        for (int i = 0 ; i < n ; i++)
            m*=2;

        dfs(m, 0, 0, 0);
    }
    public static void dfs (int size, int cnt, int x, int y){
        //나눠진 그 분기점을 나눠줘야하넴
        if (size!=2){
            int sum = size*size; // 16
            int div = sum/4; // 4
            if (r<x+size/2){
                if (c<y+size/2){
                    dfs(size/2, cnt, x, y);
                }
                else{
                    dfs(size/2, cnt+div, x, y+size/2);
                }
            }
            else{
                if (c<y+size/2){
                    dfs(size/2, cnt+div*2, x+size/2, y);
                }
                else{
                    dfs(size/2, cnt+div*3, x+size/2, y+size/2);
                }
            }
        }
        else {
            for (int i = 0 ; i < 4;  i++){
                int nx = dx[i]+x;
                int ny = dy[i]+y;
                if (nx==r && ny==c) {
                    System.out.println(cnt++);
                    System.exit(0);
                }
                cnt++;
//                board[nx][ny] = cnt++;
            }
        }
    }
}
