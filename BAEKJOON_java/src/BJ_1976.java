/*
백준 1976번 : 여행가자
start : 2023-07-26 15:36
end : 2023-07-26
modify : 2023-11-07 16:34 -
알고리즘 : union-find or bfs / union-find가 메모리나 시간적으로 더 효율적
한줄평 :
 */

import java.io.*;
import java.util.*;


public class BJ_1976 {
    static int n, m;
    static int[] parent;
    public static void main (String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());

        parent = new int [n+1];

        for (int i = 1 ; i <= n ; i++){
            parent[i] = i;
        }

        for (int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 1 ; j<=n ; j++) {
                int next =  Integer.parseInt(st.nextToken());
                //1이먄 연결된거 union
                if (next == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i < m ; i++){
           int next =Integer.parseInt(st.nextToken());
           if (parent[start] != parent[next]){
               System.out.println("NO");
               return;
           }
        }

        System.out.println("YES");
//        for (int t : parent){
//            System.out.print(t+ " ");
//        }
    }

    public static void union (int x, int y){
        x = find(x);
        y = find(y);

        if (x == y) return;

        //값 두개 중 더 작은 값을 부모로 지정
        if (x > y) parent[x] = y;
        else parent[y] = x;
    }
    public static int find (int x){
        if (parent[x] == x){
            return x;
        }
        else {
            //최적화 경로압축
            //find하면서 만난 모든 값의 부모 노드를 root로 만듦
            //트리 구조가 완전 비대칭이면 최악의 경우 1<-2<-3<-4 으로 연결 리스트형태가 됨
            // 트리의 높이가 최대가 되고 그럼 시간 복잡도가 o(N) 배열로 구현하는 것보다 비효율적! 그러니 최적화가 필수
            return parent[x] = find(parent[x]);
        }
    }
}
