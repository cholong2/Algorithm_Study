package Level2;
import java.util.*;

/**
 * 알고리즘 : Hashmap
 */
public class 귤고르기 {

    class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;
            HashMap <Integer, Integer> hm = new HashMap<>();

            for (int tan : tangerine){
                hm.put(tan, hm.getOrDefault(tan, 0)+1);
            }

            List<Integer> ks = new ArrayList<>(hm.keySet());

            ks.sort((o1, o2)->hm.get(o1)-(hm.get(o2)));

            for (int key : ks){
                System.out.println(hm.get(key));
            }

            for (int key : ks)
            {
                if (k<=0)
                    break;

                k-= hm.get(key);
                answer++;
            }


            return answer;
        }
    }
}
