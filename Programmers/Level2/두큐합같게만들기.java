package Level2;

/**
 * 알고리즘 : 큐, 투포인터기
 *
 */
public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = Integer.MAX_VALUE;
        long div = 0;
        int len = queue1.length;
        int[] q = new int[len*2];

        for (int i = 0 ; i < len ; i++){
            div +=queue1[i] + queue2[i];
            q[i] = queue1[i];
            q[len+i] = queue2[i];
        }

        if (div%2 !=0) return -1;
        div /= 2;
        long sum = q[0];

        for (int L = 0, R = 0 ; L < 2*len ; L++){
            while (sum < div){
                R = (R+1)%(2*len);
                sum+=q[R];
            }

            //합이 딱 절반이면
            if (sum == div){
                int cnt = 0;
                if (R < len-1)
                    cnt = 3*len + 1 + L + R;
                else cnt = L+(R-len+1);
                answer = Math.min(answer, cnt);
            }
            sum -= q[L];
        }

        if (answer == Integer.MAX_VALUE) answer = -1;

        return answer;
    }

}
