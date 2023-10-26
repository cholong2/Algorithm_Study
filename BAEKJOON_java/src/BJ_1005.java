/**
 * 백준 1005번 : ACM Craft
 * start : 2023-10-26 14:03
 * end : 2023-10-26 15:52
 * 알고리즘 : DFS는 아니고 DP입니다 ~ 위상정렬이라고 하네요~
 * 구하고자 하는 애부터 타고 들어가기 하려고 했는데 안됩니다~
 * DFS로 풀려고 하니 시간초과 왜냐면 선행 되는 건물이 겹치면 다 확인하고 또 반복하니 시간초과가 될 수 밖에~
 * 망할 자바~ 위상 정렬이란? 사이클이 없는 방향 그래프 일 때 선행 되는 순서에 맞게 나열하는 것
 * 진입차수 ? : 밖에서 한 정점으로 들어오는 간선의 수
 * 진출차수? : 한 정점에서 나가는 간선의 수
 * 위상 정렬 과정
 * 1. 진입차수가 0인 정점과 이와 연결된 모든 간선 지우기
 * 2. 남아있는 정점의 진입차수 갱신
 * 3. 모든 정점 없어질때까지 반복
 */

import java.io.*;
import java.util.*;
public class BJ_1005 {
    static int test, n, k; // 테스트, 건물개수, 규칙 개수
    static StringBuilder sb = new StringBuilder();
    public static void main (String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        test = Integer.parseInt(bf.readLine());

        for (int t = 0 ; t< test ; t++){
            st = new StringTokenizer(bf.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int[] d = new int[n+1];
            st = new StringTokenizer(bf.readLine());
            for (int i = 1 ; i < n+1 ; i++){
               d[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            boolean[] v = new boolean[n+1];
            for (int i = 0 ; i < n+1 ; i++)
                arr.add(new ArrayList<>());

            int[] degreeCnt = new int[n+1];

            for (int i = 0 ; i < k ; i++){
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr.get(x).add(y);
                degreeCnt[y]++;
            }

            int target = Integer.parseInt(bf.readLine());
            //-----------------입력 끝 ------------------//
            int now = target;
            int sum=0;

            Queue<Integer> q = new LinkedList<>();
            int[] dp = new int[n+1];

            for (int i = 1 ; i < n+1; i++){
                dp[i] = d[i];

                if (degreeCnt[i] == 0)
                    q.offer(i);
            }

            while(!q.isEmpty()) {
                int node = q.poll();

                for(Integer i : arr.get(node)) {
                    dp[i] = Math.max(dp[i], dp[node] + d[i]);
                    degreeCnt[i]--;

                    if(degreeCnt[i] == 0)
                        q.offer(i);
                }

            }

            sb.append(dp[target]).append("\n");
        }
        System.out.println(sb);
    }
}
