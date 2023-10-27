package Level3;
import java.util.*;
public class 미로탈출명령어 {
/**
 * start : 2023-10-27 14:20
 * end : 2023-10-27
 * 알고리즘 : 완탐?
 * d > l > r > u
 */
//    class Node{
//        int row;
//        int col;
//        int cnt;
//        String str;
//
//        Node(int r, int c, String st , int count){
//            this.row = r;
//            this.col = c;
//            this.str = st;
//            this.cnt = count;
//        }
//    }
//    class Solution {
//완탐은 시간초과 ~ 중간에 조건을 더 걸어줘야 함~
//        public String solution(int n, int m, int x, int y, int r, int c, int k) {
//            String answer = "";
//
//            Queue<Node> q = new LinkedList<>();
//            q.offer(new Node (x, y, "", 0));
//
//            int[] nx = {1, 0, 0, -1};
//            int[] ny = {0, -1, 1, 0};
//            String[] com = {"d", "l", "r", "u"};
//
//            ArrayList<ArrayList<String>> arr = new ArrayList<>();
//            for (int i = 0 ; i <= n*m ; i++ ){
//                arr.add(new ArrayList<>());
//            }
//
//
//            while (!q.isEmpty()){
//                Node now = q.poll();
//
//                if (now.cnt == k){
//                    //k번만에 목적지 도착
//                    if (now.row == r && now.col == c){
//                        if (answer.compareTo(now.str) > 0)
//                            answer = now.str;
//                        else if (answer.equals("")){
//                            answer = now.str;
//                        }
//                    }
//                }
//                else {
//                    for (int i = 0 ; i <4 ; i++){
//                        int dx = nx[i] + now.row;
//                        int dy = ny[i] + now.col;
//                        int idx = (dx-1)*m + dy;
//                        StringBuilder sb = new StringBuilder(now.str);
//                        sb.append(com[i]);
//                        if (dx >=1 && dy >= 1 && dx <= n && dy <= m && !arr.get(idx).contains(sb)){
//                            q.offer(new Node(dx, dy, sb.toString(), now.cnt+1));
//                            arr.get(idx).add(sb.toString());
//                        }
//                    }
//                }
//            }
//            if (answer.equals(""))
//                answer = "impossible";
//
//            return answer;
//        }
//
//    }
    int endR, endC, N, M;
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] com = {"d", "l", "r", "u"};
    StringBuilder sb= new StringBuilder ();;
    String answer = null;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dis = distance(x, y, r, c);
        //k가 최단거리보다 작거나, k와 최단거리가 둘다 짝수이거나 홀수여야함
        //왜냐면 거리가 남으면 와리가리 하면서 도착할 수 있어야하니까~
        if ((k-dis)%2 == 1 || k < dis) return "impossible";
        endR = r;
        endC = c;
        N = n;
        M = m;
        //현재 위치, 이동횟수, k
        dfs(x, y, 0, k);

        return answer==null? "impossible":answer;
    }
    //거리구하기
    private int distance(int a1, int b1, int a2, int b2){
        return (int) Math.abs(a1-a2)+(int) Math.abs(b1-b2);
    }
    private void dfs (int x, int y, int cnt, int k){
        //이동경로가 k인 경로가 처음 만들어 졌을 때
        if (answer != null) return;
        if (cnt+distance(x, y, endR, endC)>k) return; // 이동거리+남은거리가 k보다 크면 못감여
        //이동거리가 k일때
        if (cnt == k){
            answer = sb.toString();
            return;
        }
        for (int i= 0 ; i < 4 ; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx > 0 && ny >0 && nx <= N && ny <= M){
                sb.append(com[i]);
                dfs(nx, ny, cnt+1, k);
                sb.delete(cnt, cnt+1);
            }
        }


    }
}
