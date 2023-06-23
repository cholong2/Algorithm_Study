package Level2;
import java.util.*;
//힙
public class 더_맵게 {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue <Integer> q = new PriorityQueue<>();
            for (int i = 0 ; i <scoville.length ; i++){
                q.add(scoville[i]);
            }

            while (q.peek()<K){
                try{
                    int n1 = q.poll();
                    int n2 = q.poll();
                    int mix = n1+(n2*2);
                    q.add(mix);
                    answer++;
                }catch(Exception e){
                    return -1;
                }

            }

            return answer;
        }
    }
}
