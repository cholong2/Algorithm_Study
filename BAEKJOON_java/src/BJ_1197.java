import java.io.*;
import java.util.*;

/**
 * start : 2023-10-24 21:28
 * end : 2023-10-24 22:10
 * 알고리즘 : 최소스패닝트리, 크루스칼, 그리디, union-find
 * 선택되지 않은 간선들 중 최소 가중치 선택 -> 정렬 후 union
 * 사이클이 없을때만 선택 -> find
 * v-1개의 간선이 선택될때까지 선택
 */

public class BJ_1197 {
    static int v, e;
    static int[] parent;
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        ArrayList<int[]> arr = new ArrayList<>();
        parent = new int[v+1];
        for (int i = 1 ; i < v+1 ; i++)
            parent[i] = i;

        for (int i = 0 ; i < e ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.add(new int[]{a, b, c});
        }

        arr.sort(Comparator.comparingInt(o -> o[2]));
        int sum = 0;

        for (int[] temp :arr){
           int A = temp[0];
           int B = temp[1];
           int C = temp[2];

           //부모노드가 같으면 사이클이 생기니까 continue;
           if (find(A) == find(B))
               continue;

           //그게 아니라면 코스트 더해주고 두개 노드 합치기
           sum+=C;
           union(A,B);

        }
        System.out.println(sum);
    }

    public static int find(int A){
        if (parent[A]==A){
            return A;
        }
        else return find(parent[A]);
    }
    public static void union(int A, int B){
        int a = find(A);
        int b = find(B);

        if (a!=b) parent[b] = a;
    }
}
