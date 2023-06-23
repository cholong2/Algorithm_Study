package Level2;
import java.util.*;
// 완전탐색
import java.util.*;

public class 모의고사 {

    class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};
            int[] math1 ={1, 2, 3, 4, 5};
            int[] math2 = { 2,1,2,3,2,4,2,5};
            int[] math3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int[]math = new int[3];
            int max = 0;

            for (int i  = 0 ; i < answers.length ; i++){
                if (answers[i] == math1[i%5])
                    math[0]++;
                if (answers[i] == math2[i%8])
                    math[1]++;
                if (answers[i] == math3[i%10])
                    math[2]++;


            }

            max = Math.max(math[0], Math.max(math[1], math[2]));


            // 최대 점수를 가진 수포자 리스트 생성
            List<Integer> answ = new ArrayList<Integer>();
            for(int i=0; i<math.length; i++) if(max == math[i]) answ.add(i+1);
            answer = new int[answ.size()];

            for(int i=0; i<answ.size(); i++){
                answer[i] = answ.get(i);
            }
            return answer;
        }

    }

}
