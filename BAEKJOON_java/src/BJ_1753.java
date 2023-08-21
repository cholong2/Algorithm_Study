import java.io.*;
import java.util.*;

public class BJ_1753 {
    static class Node{
        int v;
        int cost;
        public Node (int node, int cost){
            this.cost = cost;
            this.v = node;
        }
    }
    static int s, v, e, INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] visited;


    public static void main (String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(bf.readLine());
        graph = new ArrayList[v+1];
        dist = new int [v+1];
        visited = new boolean[v+1];

        for (int i = 1 ; i <=v ; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < e ; i++){
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            graph[n1].add(new Node(n2, n3));
        }

        Dijkstra (s);

    }
    public static void Dijkstra (int start){
        //cost 기준으로 오름차순
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.cost-o2.cost);
        pq.add(new Node(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node now = pq.poll();
            if (!visited[now.v])
                visited[now.v] = true;

            for (Node next : graph[now.v]){
                if (!visited[next.v]&& dist[next.v]>now.cost+next.cost){
                    dist[next.v] = now.cost+next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i < v+1 ; i++){
            if (dist[i] == INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }
}
