// 백준 1655 가운데를 말해요
// start : 2023.04.12 17:12
// end : 2023.04.12 19:14


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_1655 {
    private static int n;
    private static int[] result, arr;

    //오름차순 최소값이 우선순위인 큐
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //내림차순 최대 값이 우선순위
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
        n = Integer.parseInt(bf.readLine());

        result = new int[n+1];
        arr = new int[n];
        int t;

        for (int i = 1 ; i <= n ;  i++){
            t = Integer.parseInt(bf.readLine());
            if (i == 1)
                maxHeap.add(t);
            else if (result[i-1] < t){
                minHeap.add(t);
            }
            else if (result[i-1]>= t){
                maxHeap.add(t);
            }

            if (i%2 == 0){
                if (maxHeap.size() > minHeap.size()){
                        minHeap.add(maxHeap.peek());
                        maxHeap.remove();
                }
            }
            else {
                if (maxHeap.size()<minHeap.size()){
                    maxHeap.add(minHeap.peek());
                    minHeap.remove();
                }
            }
            result[i] = maxHeap.peek();
        }

        for (int i = 1 ; i < n+1 ; i ++){
            System.out.println(result[i]);
        }
    }
}
