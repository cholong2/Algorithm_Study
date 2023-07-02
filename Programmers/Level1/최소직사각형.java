package Level1;
import java.util.*;
//완전탐색

public class 최소직사각형 {

    class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;
            int r= 0, c = 0;

            for (int[] card : sizes){
                r = Math.max(r, Math.max(card[0], card[1]));
                c = Math.max(c, Math.min(card[0], card[1]));
            }
            answer = r*c;
            return answer;

        }
    }
}
