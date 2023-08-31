package Level2;
import java.util.*;

/**
 * 알고리즘 : 수..?
 * 각 자리수에 잇는 숫자들 비교
 * 4이하로 작으면 -> 빼는게 이득
 * 6이상으로 크면 더하는게 이득 (앞자리에 1더하기)
 * 5는 앞자리에 따라 결정됨
 * -> 앞자리가 4이하면 5빼는게 이득
 * -> 앞자리가 6이상이면 5 더하는게 이득
 */
public class 마법의엘레베이 {
    class Solution {
        public int solution(int storey) {
            int answer = 0;
            String tmp = Integer.toString(storey);
            int[] arr = new int[tmp.length()];
            for (int i = 0 ; i < tmp.length() ; i++)
                arr[i] = tmp.charAt(i)-'0';

            for (int i = arr.length-1 ; i>=0 ; i--){
                if (arr[i] > 5){
                    answer += 10-arr[i];

                    if (i == 0)answer++;
                    else arr[i-1]++;
                }
                else if (arr[i]==5 && i>0 && arr[i-1]>=5 ){

                    arr[i-1]++;
                    answer +=5;

                }
                else{
                    answer+=arr[i];
                }
            }

            return answer;
        }
    }
}
