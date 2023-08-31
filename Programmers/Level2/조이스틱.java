package Level2;
import java.util.*;

/**
 * 알고리즘 : Greedy
 */
public class 조이스틱 {

    class Solution {
        public int solution(String name) {
            int answer = 0;
            int name_len = name.length();
            String[] arr = new String[name_len];
            Arrays.fill(arr, "A");

            int move = name_len-1; //쭉 갔을 때 횟수
            int cntA;

            for (int i = 0 ; i < name_len ; i++){
                answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

                cntA = i+1;
                while (cntA < name_len && name.charAt(cntA)=='A'){
                    cntA++;
                }
                move = Math.min(move, (i*2)+name_len-cntA);//오른쪽으로 갔다가 왼쪽으로 꺾을때
                move = Math.min(move, i+((name_len-cntA)*2));//왼쪽으로 갔다가 오른쪽으로 꺾을때
            }

            return answer+move;
        }
    }
}
