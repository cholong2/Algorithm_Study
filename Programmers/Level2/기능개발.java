package Level2;
import java.util.*;

//스택/큐
public class 기능개발 {
    // 내 코드 히든케이스 2, 4에 걸림 ㅠ
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};

            answer = new int[100];
            int idx=-1;

            for (int i = 0 ; i < progresses.length ; i++){
                if (progresses[i]>=100){
                    answer[idx]++;
                }

                else {
                    int day = (int)Math.ceil((100-progresses[i])/speeds[i]);
                    for (int j = i+1 ; j<progresses.length ; j++){
                        progresses[j] += (day*speeds[j]);
                    }
                    idx++;
                    answer[idx]++;
                }

            }

            return Arrays.stream(answer).filter(i->i!=0).toArray();
        }
    }
}

//지리는 다른 사람 코드
//import java.util.ArrayList;
//        import java.util.Arrays;
//class Solution {
//    public int[] solution(int[] progresses, int[] speeds) {
//        int[] dayOfend = new int[100];
//        int day = -1;
//        for(int i=0; i<progresses.length; i++) {
//            while(progresses[i] + (day*speeds[i]) < 100) {
//                day++;
//            }
//            dayOfend[day]++;
//        }
//        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
//    }
//}

