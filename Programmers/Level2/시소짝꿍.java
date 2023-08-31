package Level2;
/**
 * 알고리즘 : 수, hashmap
 *
 */

import java.util.*;

class 시소짝꿍 {
    public long solution(int[] weights) {
        long answer = 0;


        HashMap<Double, Integer> hm = new HashMap();

        Arrays.sort(weights);

        for (int w : weights){

            double w1 = 1.0*w;
            double w2 = (1.0*w)/2.0;
            double w3 = (2.0*w)/3.0;
            double w4 = (3.0*w)/4.0;

            if (hm.containsKey(w1)) answer+= hm.get(w1);
            if (hm.containsKey(w2)) answer+= hm.get(w2);
            if (hm.containsKey(w3)) answer+= hm.get(w3);
            if (hm.containsKey(w4)) answer+= hm.get(w4);

            hm.put((1.0*w), hm.getOrDefault((1.0*w), 0)+1);
        }


        return answer;
    }
}