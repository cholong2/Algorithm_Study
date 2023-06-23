package Level2;
import java.util.*;

//정렬
//comparator 오버라이드

public class 가장_큰_수 {


    class Solution {

        public String solution(int[] numbers) {
            String answer = "";
            String[] num = new String[numbers.length];
            boolean exception = true;


            for (int i = 0; i< numbers.length ; i++)
            {
                num[i] = String.valueOf(numbers[i]);
                if (numbers[i]!= 0) exception = false;
            }
            Arrays.sort(num, new Comparator<String>(){
                @Override
                public int compare(String n1, String n2){
                    return (n2+n1).compareTo(n1+n2);
                }
            });

            for (int i = 0 ; i < num.length ; i++){
                answer += num[i];
            }

            if (exception) answer = "0";

            return answer;
        }

    }
}
