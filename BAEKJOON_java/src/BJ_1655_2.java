/**
 * start : 2023-10-20 17:32
 * end : 2023-10-20
 * 알고리즘 : 우선순위큐
 * 백준 가운데를 말해요
 * 풀었던 거지만 6개월전에 풀었던거 넥토리얼에서 비슷한거 나왔다고 하니 다시 풀어보자~
 * 안보고 풀려고 했는데 우선순위 큐인걸 봐버렸네..^^
 */
import java.io.*;
import java.util.*;

public class BJ_1655_2 {
    static int n;
    static PriorityQueue<Integer> maxH = new PriorityQueue<>((o1, o2) -> o2-o1);
    static PriorityQueue<Integer> minH = new PriorityQueue<>();

    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(bf.readLine());
            if (minH.size() == maxH.size()){
                maxH.offer(num);
            }
            else minH.offer(num);

            if (!minH.isEmpty()&&!maxH.isEmpty()){
                if (maxH.peek() > minH.peek()){
                    int temp = minH.poll();
                    maxH.offer(temp);
                    minH.offer(maxH.poll());
                }
            }
            sb.append(maxH.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
