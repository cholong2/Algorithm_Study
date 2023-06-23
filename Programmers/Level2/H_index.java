package Level2;
import java.util.*;
//정렬
public class H_index {
    class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            Arrays.sort(citations);

            for (int i = 0 ; i < citations.length ; i++){
                if (citations[i] >= citations.length-i)
                    answer = citations[i];
            }

            return answer;

        }
    }
}
