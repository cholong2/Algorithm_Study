/*
백준 16928번: 뱀과 사다리 게임
start : 2023-04-27 15:06
end : 2023-04-27 16:45
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class node {
    public int x, d;
    node(int x, int d){
        //x=위치, d는 이 위치까지 오면서 주사위를 굴린 횟수
        this.x = x;
        this.d = d;
    }
}
public class BJ_16928 {

        static int n, m;
        static ArrayList<Integer> arr1 = new ArrayList<Integer>();
        static ArrayList<Integer> arr2 = new ArrayList<Integer>();
        static Queue<node> q = new LinkedList<>();
        static boolean[] visited = new boolean[101];

        public static void main (String args[]) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            //arr1은 이전 위치, arr2는 이동 후 위치
            for (int i=0 ; i <n+m ; i++) {
                st = new StringTokenizer(bf.readLine());
                arr1.add(Integer.parseInt(st.nextToken()));
                arr2.add(Integer.parseInt(st.nextToken()));
            }

            q.offer(new node(1, 0));
            visited[1] = true;

            while (q.peek().x!=100){
                node cur = q.poll();

                for (int i = 1 ; i < 7 ; i ++) {
                    if (cur.x+i <=100 && !visited[cur.x + i] ) {
                        //현재 위치가 뱀이나 사다리 위에 있다면 이동하고 q에 넣기
                        if (arr1.contains(cur.x + i)) {
                            visited[cur.x + i] = true;
                            visited[arr2.get(arr1.indexOf(cur.x + i))] = true;
                            q.add(new node (arr2.get(arr1.indexOf(cur.x + i)), cur.d+1));
                        } else {
                            visited[cur.x + i] = true;
                            q.add(new node (cur.x + i, cur.d+1));
                        }

                    }
                }

            }
            System.out.println(q.peek().d);
        }
}
