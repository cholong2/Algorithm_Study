import java.io.*;
import java.util.*;

/**
 * 백준 9205번 : 맥주 마시면서 걸어가기
 * start : 2023-09-08 21:04
 * end : 2023-09-08 22:18
 * 알고리즘 : BFS
 */
public class BJ_9205 {
    static int test, n;
    static int[][] coord;
    static int[] h = new int[2];
    static int[] target = new int[2];
    static boolean[] v;
    public static void main (String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        test = Integer.parseInt(bf.readLine());
        int beer = 1000;
        StringBuilder sb = new StringBuilder();

        for (int t = 0 ; t < test ; t++ ){
            n = Integer.parseInt(bf.readLine());
            coord = new int[n+1][2];
            Queue<Integer> q = new LinkedList<>();
            v = new boolean[n+1];
            for (int i = 0 ; i < n+2 ; i++){
                st = new StringTokenizer(bf.readLine());
                if (i == n+1){
                    target[0] = Integer.parseInt(st.nextToken());
                    target[1] = Integer.parseInt(st.nextToken());
                }
                else {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    coord[i][0] = x;
                    coord[i][1] = y;
                }
            }
            // -일수도 있는거 생각해주기
            // 집좌표 넣고 시작
            // 1000안으로 다음으로 넘어갈 수 있는지
            q.add(0);
            boolean check = false;
            while (!q.isEmpty()){
                int temp = q.poll();
                v[0] =true;
                if (Math.abs(target[0]-coord[temp][0]) + Math.abs(target[1]-coord[temp][1]) <=1000){
                    check = true;
                    break;
                }
                for (int i = 0 ; i < n+1 ; i++){
                    if (!v[i] && Math.abs(coord[i][0]-coord[temp][0]) + Math.abs(coord[i][1]-coord[temp][1]) <=1000){
                        v[i] = true;
                        q.offer(i);
                    }
                }
            }
            if (check)
                sb.append("happy").append("\n");
            else
                sb.append("sad").append("\n");
        }

        System.out.println(sb);
    }
}
