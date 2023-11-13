/**
 * 백준 9466번 : 텀 프로젝트
 * start : 2023-11-13 16:32
 * end : 2023-11-13
 * 알고리즘 : 유니온파인드? 우마르세상에 dfs였습니당~
 * 한줄평 : dfs인데 이제 boolean체크 배열이 2개인,,
 * 방문한것과 사이클이 만들어진거 2개 필요함여
 * 방문했는데 탐색이 종료되지 않았다면 -> 돌고돌아서 사이클이 만들어진거!
 * 이제 거기서 선택된 사이클의 팀원들 세주면 됨!
 * 이렇게 생긴거 먼가 union-find같아서 풀어보려고 했는데 사이클을 어케 체크할지 모르겠어서 포기했땀
 * 위로 올라갈수록 전형적인 문제에서 업그레이드 되는구나 그래그래 그것 안타깝게도 현실이야~
 */

import java.io.*;
import java.util.*;

public class BJ_9466 {
    static int t, n, cnt;
    static int[] arr;
    static boolean[] v, done;

    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < t ; i++){
            n  = Integer.parseInt(bf.readLine());
            arr = new int[n+1];
            v = new boolean[n+1];
            done = new boolean[n+1];
            cnt = 0;
            st = new StringTokenizer(bf.readLine());
            for (int  j = 1 ; j <= n ; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1 ; j <=n ; j++){
                if (!done[j]){
                    dfs(j);
                }
            }
            sb.append(n-cnt).append("\n");
        }
        System.out.print(sb);
    }
    public static void dfs(int node){

       v[node] = true;
       int next = arr[node];
       //내가 선택한 애가 방문되지 않았다면 사이클 탐색하러감
       if (!v[next]) dfs(next);

       //내가 선택한 애를 이미 방문했다면
       else {
           //그리고 걔가 아직 탐색이 종료되지 않았다면
           if (!done[next]){
               cnt++;
               done[next] = true;
               while (next!=node){
                   cnt++;
                   next = arr[next];
                   done[next] = true;
               }
           }
       }
       done[node] = true;
    }
}
