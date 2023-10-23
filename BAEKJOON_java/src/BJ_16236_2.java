import java.io.*;
import java.util.*;
//2023-10-22 코테 대비 다시 풀어보기

public class BJ_16236_2 {
    static int n, size, cnt, t;
    static int[][] b;
    static boolean[][] v;
    static int[] nx = {0, 1, 0, -1};
    static int[] ny = {1, 0, -1, 0};

    public static void main (String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        Queue<int[]> q = new LinkedList<>();
        size = 2;
        t = 0;
        cnt = 0;

        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j  =  0 ; j < n ; j++){
                b[i][j] = Integer.parseInt(st.nextToken());
                if (b[i][j] == 9){
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        while (!q.isEmpty()){
            int[] temp = q.poll();
            for (int i = 0 ; i < 4 ;i++){
                int dx = nx[i] + temp[0];
                int dy = ny[i] + temp[1];
                if (dx >= 0 && dy>=0 && dx < n && dy< n) {
                    //먹을 수 있다면
                    if (b[dx][dy] < size) {
                        q.offer(new int[] {dx, dy, temp[2]+1});
                        b[dx][dy] = 0;
                        cnt++;
                    }
                    //못먹고 이동만
                    else if (b[dx][dy] == size || b[dx][dy] == 0){
                        q.offer(new int[] {dx, dy, temp[2]+1});
                    }

                    if (cnt == size){
                        size++;
                        cnt = 0;
                    }
                }
            }
        }
    }
}
