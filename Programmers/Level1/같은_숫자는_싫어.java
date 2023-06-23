package Level1;
//스택
import java.util.*;

public class 같은_숫자는_싫어 {
    public class Solution {
        public int[] solution(int []arr) {
            int[] answer = {};
            Stack <Integer> st = new Stack<>();

            st.push(arr[0]);

            for (int i = 1 ; i < arr.length ; i++){
                if (st.peek()!=arr[i]){
                    st.push(arr[i]);
                }
            }


            answer = new int[st.size()];
            for (int i = 0 ; i < st.size(); i++){
                answer[i] = st.get(i);
            }
            return answer;
        }
    }
}
