/*
백준 1927번 : 최소 힙
start: 2023-06-21 15:29
end : 2023-06-21 15:41
알고리즘 : 최소힙
한줄 평 : 최소, 최대힙은 우선순위 큐로 구현 할 수 있음
최소, 최대힙이란?
자식 노드는 부모 노드보다 작거나 큰 이진트리
 */

import java.io.*;
import java.util.*;

public class BJ_1927 {
    static PriorityQueue <Integer> heap = new PriorityQueue<>();
    static int n;
    static StringBuilder sb = new StringBuilder();


    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int temp;
        for (int i = 0 ; i < n ;i++){
            temp = Integer.parseInt(bf.readLine());
            if (temp == 0) {
                if (heap.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(heap.poll()).append('\n');
            }
            else
                heap.add(temp);
        }

        System.out.println(sb.toString());
    }
}
