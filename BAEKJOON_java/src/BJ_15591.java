/**
 * start : 2023-10-20 18:57
 * end : 2023-10-20
 * 알고리즘 : 그래프,스패닝트리, BFS
 * node의 개수가 n이고 간선의 개수가 n-1이고 모두가 서로 무조건 연결됐으면 == spaning tree구하는 문제란다~
 * https://velog.io/@jyleedev/%EB%B0%B1%EC%A4%80-15591-MooTube
 *
 * 백준 MooTube
 */

import java.io.*;
import java.util.*;

public class BJ_15591 {
    static int n, q;
    static ArrayList<ArrayList<int[]>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            arr.get(a).add(new int[]{b, u});
            arr.get(b).add(new int[]{a, u});
        }


        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cnt = 0;

            Queue<Integer> q = new LinkedList<>();
            boolean visited[] = new boolean[n+1];

            visited[v] = true;
            q.offer(v);

            while (!q.isEmpty()){
                int now = q.poll();

                for (int[] next : arr.get(now)){
                    if (!visited[next[0]] && next[1] >= k){
                        cnt++;
                        q.offer(next[0]);
                        visited[next[0]] = true;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }


}
