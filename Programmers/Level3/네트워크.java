package Level3;
/*
알고리즘 : BFS
아무점에서 BFS로 시작하면서 방문처리해주고 끝날때 ++
그걸 모든점 돌면서 해주기
 */
import java.util.*;

class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean v[] = new boolean[n];
        Queue <Integer> q = new LinkedList<>();

        //현재 탐색할 노드
        for (int i = 0 ; i < n ; i++){
            //연결된 노드탐색
            if (!v[i]){
                q.add(i);
                v[i] = true;
                while (!q.isEmpty()){
                    int now = q.poll();
                    for (int j = 0 ; j < n ; j++){
                        if(computers[now][j]==1 && !v[j]){
                            q.add(j);
                            v[j] = true;
                        }
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}