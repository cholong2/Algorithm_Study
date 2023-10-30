/**
 * 백준 줄세우기
 * start : 2023-10-29 23:59
 * end : 2023-10-30 1:00
 * 알고리즘 : 무슨무슨 정렬 인데 위상정렬이다!
 */

import java.util.*;
import java.io.*;

public class BJ_2252 {
    static int n, m;

    static int degreeCnt[];
    public static void main (String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        degreeCnt = new int [n+1];
        int maxCnt = 0;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n+1 ; i++)
            arr.add(new ArrayList<>());

        for (int i = 0 ; i < m ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);

            degreeCnt[b]++;
            maxCnt = Math.max(degreeCnt[b], maxCnt);
        }


        for (int j = 1; j < n+1; j++) {
            if (degreeCnt[j] == 0)
                q.offer(j);
        }

        while (!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");

            ArrayList<Integer> next = arr.get(now);

            for (int temp : next){
                degreeCnt[temp]--;
                if (degreeCnt[temp] == 0){
                    q.offer(temp);
                }
            }

        }

        System.out.println(sb);
    }
}
