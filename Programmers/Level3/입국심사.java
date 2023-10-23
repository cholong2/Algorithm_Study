package Level3;
/**
 * start : 2023-10-19 17:09
 * end : 2023-10-19 17 17:55
 * 알고리즘 : 이분탐색
 * 말도 안돼 이게 어케 이분탐색?!
 * 이게 이분탐색..
 * 0부터 최대로 걸리는 시간을 범위로 잡고 mid값 구해서
 * mid 값을 심사관마다 걸리는 시간으로 나누면 몇명의 사람을 심사하는 지 구할 수 있음!
 첨에 심사관이 10억인줄 알았음 ㅎㅋ 문제를 잘 읽자!!!
 */
import java.util.*;
public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long l = times[0];
        long r = times[times.length-1]*(long)n;
        long mid;

        //
        while (l<=r){
            mid = (l+r)/2;
            long sum = 0;

            for (int t : times){
                sum += mid/t;
            }

            if (sum>=n){
                r = mid-1;
                answer = mid;
            }
            else
                l = mid+1;
        }
        return answer;
    }
}
