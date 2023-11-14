/**
 * 백준 1238번 : 파티
 * start : 2023-11-14 16:08
 * end : 2023-11-14 16:51
 * 알고리즘 : 다익스트라
 * 한줄평 : 한점에서 다른점으로 최단거리, 그점에서 다시 돌아올때 최단거리 단방향이라 왕복으로 구해야함
 * 최소 2n-2 플로이드 와샬로 풀수 있는데 그럼 3중이라 시초 날듯
 * 그렇다면 다익스트라도 있네욤,,^^
 * 그래프 알고리즘 중 최소 비용을 구하는 데는 다익스트라, 벨만-포드, 플로이드 와샬
 * 오늘은 그래프 정리하긔~
 */
import java.io.*;
import java.util.*;

public class BJ_1238 {
    static int n, m,  x, max;
    static ArrayList<ArrayList<int[]>> arr;
    static int[] stu;
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        stu = new int[n+1];
        for (int i = 0 ; i <= m ; i++){
            arr.add(new ArrayList<>());
        }

        for (int i = 0 ; i < m; i ++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            arr.get(s).add(new int[]{e, t});
        }


        for (int i = 1 ; i <= n ; i++){
            if (i == x) continue;

            int sdis = di(i, x);
            int edis = di(x, i);

            max = Math.max(sdis+edis, max);
        }
        System.out.println(max);
    }
    public static int di (int s, int e){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        boolean[] v = new boolean[n+1];
        pq.offer(new int[] {s, 0});
        int dis = 0;
        while (!pq.isEmpty()){
            int[] now = pq.poll();

            if (now[0] == e){
                dis = now[1];
                break;
            }

            for (int[] next : arr.get(now[0])){
                if (!v[next[0]]){
                    pq.offer(new int[] {next[0], next[1]+now[1]});
                }
            }
            v[now[0]] = true;
        }

        return dis;

    }
}
