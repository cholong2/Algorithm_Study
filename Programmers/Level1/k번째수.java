package Level1;
import java.util.*;

//정렬
// Arrays.copyOfRange(arr, start, end)를 기억해
public class k번째수 {


    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = {};
            int len = commands.length;
            answer = new int[len];


            for (int i = 0 ; i < len ; i++){
                int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(temp);
                int idx = commands[i][2]-1;

                answer[i] = temp[idx];
            }
            return answer;
        }
    }
}
