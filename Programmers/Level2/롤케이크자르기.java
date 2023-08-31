package Level2;
import java.util.*;
/**
 * start : 2023-08-29 16:20
 * end : 2023-08-29 17:04
 * 알고리즘 : Hashmap
 */
public class 롤케이크자르기 {

    class Solution {
        public int solution(int[] topping) {
            int answer = -1;
            int n = topping.length;
            HashMap <Integer, Integer> hm = new HashMap<>();
            Set <Integer> set = new HashSet<>();
            int cnt = 0;

            for (int i = 0 ;  i < n ; i++){
                hm.put(topping[i], hm.getOrDefault(topping[i], 0)+1);
            }

            for (int i = 0 ; i < n ; i++){
                set.add(topping[i]);
                if (hm.get(topping[i])==1)
                    hm.remove(topping[i]);
                else
                    hm.put(topping[i], hm.get(topping[i])-1);

                if (set.size()==hm.size())
                    cnt++;
            }

            answer = cnt;

            return answer;
        }
    }
}
