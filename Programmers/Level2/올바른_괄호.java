package Level2;
import java.util.*;
//스택
public class 올바른_괄호 {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Stack <Character> st = new Stack<>();

            for (int i = 0 ; i < s.length() ; i++){
                if (s.charAt(i) == ('(')){
                    st.push('(');
                }
                else {
                    if (st.isEmpty())
                        return false;
                    else
                        st.pop();
                }
            }

            if (st.isEmpty())
                answer = true;
            else
                answer = false;

            return answer;
        }
    }
}
