import java.io.*;
import java.util.*;

/**
 * start : 2023-09-06 18:36
 * end : 2023-09-06 18
 * 알고리즘 : DFS
 * union find인줄 알고 깝침 ㅜ 그냥 간단하게 인접리스트 생성해서 하면 쉬운 DFS문제
 * 인접리스트 ? :     static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
 * 어레이리스트를 여러개 선언해서 연결된 거 다 추가
 */
public class BJ_2644 {
    static int n = 0, m = 0;
    static int[] target = new int[2];
    static boolean[] v;
    static int answer = -1;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        v = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        target[0] = Integer.parseInt(st.nextToken());
        target[1] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(bf.readLine());

        for (int i = 0 ; i < n+1; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0 ; i < m ; i++){
            st = new StringTokenizer(bf.readLine());
            int par = Integer.parseInt(st.nextToken());
            int ch = Integer.parseInt(st.nextToken());

           graph.get(par).add(ch);
           graph.get(ch).add(par);
        }

        int cnt = 0;
        dfs(target[0], cnt);

        System.out.println(answer);
    }
    public static void dfs (int now, int cnt){
        v[now] = true;

        for (int temp : graph.get(now)){
            if(!v[temp]) {
                if (temp == target[1]) {
                    answer = cnt+1;
                    return;

                }
                dfs(temp, cnt+1);
            }

        }
    }
}
