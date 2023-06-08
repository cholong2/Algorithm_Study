/*
백준 2075번 N번째 큰 수
start: 2023-04-26 16:20
end : 2023-04-26 16:56
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2075 {

    public static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    public static int n;

    public static void main (String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());

        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
           while (st.hasMoreTokens()){
               q.add(Integer.parseInt(st.nextToken()));
           }
        }

        for (int i = 0 ; i < n-1 ; i ++){
            q.poll();

        }

        System.out.println(q.poll());
    }
}
