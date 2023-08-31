package Level2;
import java.util.*;

/**
 * 알고리즘 : 수
 */
public class 점찍기 {

    class Solution {기
        public long solution(int k, int d) {
            long answer = 0;
            double temp = 2.14;
            int t = (int) (temp/2);


            for (long i = 0 ; i <= d ; i++){
                if (i*k <= d)
                    answer += (int)((Math.sqrt(Math.pow(d, 2) - Math.pow (i*k, 2)))/k) +1;

            }
//          for (long i = 0 ; i*k <= d ; i++){
//               answer += (int)((Math.sqrt(Math.pow(d, 2) - Math.pow (i*k, 2)))/k) +1;

//         }
            return answer;
        }
    }
}
