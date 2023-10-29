package Level2;
/**
start : 2023-10-29 17:33
end : 2023-10-29 18:33
알고리즘 : 누적합?
*/
import java.util.*;

public class 연속부분수열합의개수 {
    class Solution {
        public int solution(int[] elements) {
            int answer = 0;
            Set <Integer> set = new HashSet<>();
            int n = elements.length;

            //길이가 1부터 n까지
            for (int j = 1 ; j <= n ; j++){
                int l = 0;
                int r = 0;
                int sum = elements[0];
                while (l < n){
                    if (r-l+1 < j){
                        // System.out.println("r-1<j");
                        r++;
                        sum+=elements[r%n];
                    }
                    else if (r-l+1 == j){
                        // System.out.println("r-1==j");
                        set.add(sum);
                        r++;
                    }
                    else {
                        // System.out.println("r-1>j" + r + " "+ l + " "+sum);
                        sum-=elements[l];
                        sum+=elements[r%n];
                        l++;
                    }
                }
            }
            // System.out.println(set);
            answer = set.size();
            return answer;
        }
    }
}
