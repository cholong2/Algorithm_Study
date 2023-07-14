/*
백준 - 숨바꼭질3 13549
Start : 23.04.25-16:40
End : 23.04.18:55
 */


import java.io.*;
import java.util.*;

public class BJ_13549 {

    static int n, k= 0;
    static int[] visited = new int[100001];
    static Queue<Loc> q = new LinkedList<>();
    static class Loc{
        int idx;
        int time;

        public Loc(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        q.add(new Loc(n,1));
        visited[n] = 1;

       while (!q.isEmpty()){
           Loc now = q.poll();

           if (now.idx+1>=0 && now.idx+1<=100000){
               if (visited[now.idx+1] == 0 || visited[now.idx+1] > now.time+1){
                   visited[now.idx+1] = now.time+1;
                   q.add(new Loc (now.idx+1, now.time+1));
               }
           }

           if (now.idx-1>=0 && now.idx-1<=100000){
               if (visited[now.idx-1] == 0 || visited[now.idx-1] > now.time+1){
                   visited[now.idx-1] = now.time+1;
                   q.add(new Loc(now.idx-1, now.time+1));
               }
           }

           if (now.idx*2>=0 && now.idx*2<=100000){
               if (visited[now.idx*2] == 0 || visited[now.idx*2] > now.time){
                   visited[now.idx*2] = now.time;
                   q.add(new Loc(now.idx*2, now.time));
               }
           }

       }

       System.out.println(visited[k]-1);
}
}
