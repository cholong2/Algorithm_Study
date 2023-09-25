package Level3;

/**
 * start : 2023-09-25 15:43
 * end : 2023-09-25 16:02
 * 알고리즘 : 그래프, BFS
 */
import java.util.*;

class 가장먼노드 {수
    boolean[] v;
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        v =  new boolean[n+1];
        for (int i = 0 ; i <= n ; i++)
            arr.add(new ArrayList<>());

        for (int i = 0 ; i < edge.length ; i++){
            arr.get(edge[i][0]).add(edge[i][1]);
            arr.get(edge[i][1]).add(edge[i][0]);
        }

        //맥스 값 찾고 같으면 ++ 더 크면 값 초기화 max 갱신
        int max = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        v[1] = true;

        while (!q.isEmpty()){
            int[] now = q.poll();
            if(max == now[1]){
                answer++;
            }
            else if (max < now[1]){
                answer = 1;
                max = now[1];
            }
            for (int next : arr.get(now[0])){
                if (!v[next]){
                    q.add(new int[] {next, now[1]+1});
                    v[next] = true;
                }
            }

        }


        return answer;
    }
}